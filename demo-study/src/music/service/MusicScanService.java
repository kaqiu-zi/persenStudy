package music.service;

import music.common.BusinessException;
import music.constant.Constants;
import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.entity.NoteLengthEnum;
import music.entity.Syllable;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        File file = new File(path);
        boolean isStaff = false;
        int speed;
        int row;
        try (FileReader fileReader = new FileReader(file);
             final BufferedReader input = new BufferedReader(fileReader)) {
            // 预检测
            final String head = input.readLine();
            if (!Constants.JAVA_SCRIPT.equals(head)) {
                throw new BusinessException("头文件被破坏，请检查");
            }
            final String staff = input.readLine();
            if (Constants.STAFF_TRUE.equals(staff)) {
                isStaff = true;
            } else if (!Constants.STAFF_FALSE.equals(staff)) {
                throw new BusinessException("头文件被破坏，请检查");
            }
            // 获取曲速
            final String speedString = input.readLine();
            if (null == speedString) {
                throw new BusinessException("获取曲速失败");
            }
            speed = Integer.parseInt(speedString.substring(Constants.SPEED_TEXT.length()));
            // 获取行数
            final String rowString = input.readLine();
            if (null == rowString) {
                throw new BusinessException("获取行数失败");
            }
            row = Math.min(Integer.parseInt(rowString.substring(Constants.ROWS_TEXT.length())), Constants.MAX_ROWS);
            String[] data = new String[row];
            // 根据行数读取内容，不足时抛出异常
            for (int i = 0; i < row; i++) {
                final String dataString = input.readLine();
                if (null == dataString) {
                    throw new BusinessException("读取内容失败，文件内容不足");
                }
                data[i] = dataString;
            }
            MusicScore musicScore;
            if (isStaff) {
                musicScore = MusicScore.fromStaff(data);
            } else {
                musicScore = MusicScore.fromNum(data);
            }
            musicScore.setSpeed(speed);
            return musicScore;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        this.write(path, tmpList);
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
        // TODO(mingJie-Ou): 2021/2/15 时间变量 先去map找有没有，没有就生成，并放入map中
        final Map<Integer, String> pressMap = this.generateCallPress();
        // 写入头文件
        tmpList.add(Constants.HEAD_TEXT);
        tmpList.add(StringUtils.EMPTY);
        // 写入按键函数
        for (String pressString : this.generateFunctionPress()) {
            tmpList.add(pressString);
            tmpList.add(StringUtils.EMPTY);
        }
        tmpList.add(StringUtils.EMPTY);
        // 遍历写入音符
        int index = 0;
        int rhythm = Constants.BASE_RHYTHM / musicScore.getSpeed();
        for (Syllable syllable : musicScore.getSyllables()) {
            final int interval = syllable.getIndex() - index;
            if (0 != interval) {
                tmpList.add(String.format(Constants.CALL_SLEEP_TEXT,
                    rhythm * (interval) / NoteLengthEnum.CROTCHETS.getValue()));
            }
            tmpList.add(pressMap.getOrDefault(syllable.computeNoteValue(baseValue), "Error:无法识别（" + syllable + ")"));
            if (0 != index && (index % WHOLE.getValue()) == 0 && (syllable.getIndex() % WHOLE.getValue()) != 0) {
                tmpList.add(StringUtils.EMPTY);
            }
            index = syllable.getIndex();
        }
        return tmpList;
    }

    private void write(String path, LinkedList<String> strings) {
        File file = new File(path);
        try (final FileWriter writer = new FileWriter(file);
             final BufferedWriter out = new BufferedWriter(writer)) {
            for (String string : strings) {
                if (StringUtils.isBlank(string)) {
                    out.newLine();
                } else {
                    out.write(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
