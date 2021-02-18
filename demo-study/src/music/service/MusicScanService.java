package music.service;

import music.common.BusinessException;
import music.constant.Constants;
import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.entity.NoteLengthEnum;
import music.entity.Syllable;
import music.service.impl.FileServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static music.constant.Constants.BASE_PITCH;
import static music.constant.Constants.PRESS_CHARS;
import static music.constant.Constants.PRESS_X_NUM;
import static music.entity.NoteLengthEnum.WHOLE;

/**
 * 乐谱转换服务类
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/8
 * @since 1.0.0
 */
public class MusicScanService {
    private static final MusicScanService INSTANCE = new MusicScanService();
    private static final int[] PRESS_INDEX = {
        -1, 0, 2, 4, 5, 7, 9, 11,
        12, 14, 16, 17, 19, 21, 23, 24};
    private final HashMap<Integer, String> timeMap = new HashMap<>(16);
    private final IFileService fileService = FileServiceImpl.of();
    private boolean isTest;

    private MusicScanService() {
    }

    public static MusicScanService of() {
        return INSTANCE;
    }

    /**
     * 正式转换逻辑
     *
     * @param path 路径
     * @return 谱子
     */
    public MusicScore scan(String path) {
        LinkedList<String> data = fileService.read(path);
        boolean isStaff = false;
        int speed;
        int row;
        //
        Iterator<String> iterator = data.iterator();
        // 预检测
        if (!Constants.JAVA_SCRIPT.equals(iterator.next())) {
            throw new BusinessException("头文件第一行不正确");
        }
        final String staff = iterator.next();
        if (Constants.STAFF_TRUE.equals(staff)) {
            isStaff = true;
        } else if (!Constants.STAFF_FALSE.equals(staff)) {
            throw new BusinessException("头文件第二行不正确");
        }
        // 获取曲速
        final String speedString = iterator.next();
        if (null == speedString) {
            throw new BusinessException("获取曲速失败");
        }
        speed = Integer.parseInt(speedString.substring(Constants.SPEED_TEXT.length()));
        // 获取行数
        final String rowString = iterator.next();
        if (null == rowString) {
            throw new BusinessException("获取行数失败");
        }
        row = Math.min(Integer.parseInt(rowString.substring(Constants.ROWS_TEXT.length())), Constants.MAX_ROWS);
        String[] tmp = new String[row];
        for (int i = 0; i < row; i++) {
            final String dataString = iterator.next();
            if (null == dataString) {
                throw new BusinessException("读取内容失败，文件内容不足");
            }
            tmp[i] = dataString;
        }
        MusicScore musicScore;
        if (isStaff) {
            musicScore = MusicScore.fromStaff(tmp);
        } else {
            musicScore = MusicScore.fromNum(tmp);
        }
        musicScore.setSpeed(speed);
        musicScore.setRhythm(Constants.BASE_RHYTHM / speed);
        return musicScore;
    }

    public MusicScore splice(MusicScore musicScore, String path) {
        // TODO(mingJie-Ou): 2021/2/18 拼接伴奏功能
        return null;
    }

    public void toSky(MusicScore musicScore, String path, String baseNote) {
        musicScore.setBaseNote(NoteEnum.from(baseNote.substring(0, baseNote.length() - 1)));
        musicScore.setBasePitch(Integer.parseInt(baseNote.substring(baseNote.length() - 1)));
        // TODO(mingJie-Ou): 2021/2/8 给musicScore加上判定
        this.toSky(musicScore, path);
    }

    public void toSky(MusicScore musicScore, String path) {
        LinkedList<String> tmpList = this.generateMusic(musicScore);
        fileService.write(path, tmpList);
    }

    /**
     * 转为光遇谱子
     *
     * @param musicScore 转好的乐谱
     * @return linked list
     */
    private LinkedList<String> generateMusic(MusicScore musicScore) {
        LinkedList<String> tmpList = new LinkedList<>();
        final int baseValue = musicScore.getBaseValue();
        final Map<Integer, String> pressMap = this.generateCallPress();
        // 编辑头文件
        tmpList.add(isTest ? Constants.HEAD_TEST_TEXT : Constants.HEAD_TEXT);
        tmpList.add(StringUtils.EMPTY);
        // 编辑按键函数
        for (String pressString : this.generateFunctionPress()) {
            tmpList.add(pressString);
            tmpList.add(StringUtils.EMPTY);
        }
        tmpList.add(StringUtils.EMPTY);
        // 遍历写入音符
        int index = 0;
        for (Syllable syllable : musicScore.getSyllables()) {
            final int interval = syllable.getIndex() - index;
            // TODO(mingJie-Ou): 2021/2/18 修复最后一个音符没有调用等待函数的bug，如果不实现片段的前后拼接，可以不实现。
            this.getTime(interval, musicScore.getRhythm()).ifPresent(tmpList::add);
            tmpList.add(pressMap.getOrDefault(syllable.computeNoteValue(baseValue), "Error:无法识别（" + syllable + ")"));
            if (0 != index && (index % WHOLE.getValue()) == 0 && (syllable.getIndex() % WHOLE.getValue()) != 0) {
                tmpList.add(StringUtils.EMPTY);
            }
            index = syllable.getIndex();
        }
        return tmpList;
    }

    /**
     * 利用 间隔key，以及旋律rhythm生成 调用等待函数
     * <p>利用hashMap作为缓存</p>
     *
     * @param key    map的key，这里为间隔
     * @param rhythm 节拍
     * @return 等待函数的调用
     */
    private Optional<String> getTime(Integer key, int rhythm) {
        // TODO(mingJie-Ou): 2021/2/18 调用中，使用变量代替常量。方便直接进行简单的曲速修改
        if (null == key || key < 0) {
            throw new BusinessException("key must no null");
        }
        if (timeMap.containsKey(key)) {
            return Optional.of(timeMap.get(key));
        }
        if (0 == key) {
            return Optional.empty();
        }
        String timeCall = String.format(Constants.CALL_SLEEP_TEXT, rhythm * key / NoteLengthEnum.CROTCHETS.getValue());
        timeMap.put(key, timeCall);
        return Optional.of(timeCall);
    }

    /**
     * 生成按键函数map
     *
     * @return Integer - String map
     */
    private List<String> generateFunctionPress() {
        return IntStream.range(-1, Constants.PRESS_SIZE)
            .mapToObj(i -> {
                if (-1 == i) {
                    return "";
                }
                return String.format(Constants.PRESS_TEXT, PRESS_CHARS[i % PRESS_CHARS.length],
                    BASE_PITCH + i / PRESS_CHARS.length, i % PRESS_X_NUM, i / PRESS_X_NUM);
            })
            .collect(Collectors.toList());
    }

    /**
     * 生成按键调用map
     *
     * @return Integer - String map
     */
    private Map<Integer, String> generateCallPress() {
        return IntStream.range(-1, Constants.PRESS_SIZE)
            .boxed()
            .collect(Collectors.toMap(i -> PRESS_INDEX[i + 1], i -> {
                if (-1 == i) {
                    return "";
                }
                return String.format(Constants.CALL_PRESS_TEXT,
                    PRESS_CHARS[i % PRESS_CHARS.length], BASE_PITCH + i / PRESS_CHARS.length);
            }));
    }

    public void setTest(boolean test) {
        isTest = test;
    }
}
