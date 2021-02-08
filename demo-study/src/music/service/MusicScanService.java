package music.service;

import music.common.BusinessException;
import music.constant.Constants;
import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.entity.NoteLengthEnum;
import music.entity.Syllable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static music.constant.Constants.BASE_PITCH;
import static music.constant.Constants.PRESS_CHARS;
import static music.constant.Constants.pressXNum;
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
        if ( 3 == baseNote.length()) {
            musicScore.setBaseNote(NoteEnum.from(baseNote.substring(0, 2)));
            musicScore.setBasePitch(Integer.parseInt(baseNote.substring(2)));
        } else {
            musicScore.setBaseNote(NoteEnum.from(baseNote.substring(0, 1)));
            musicScore.setBasePitch(Integer.parseInt(baseNote.substring(1)));
        }
        // TODO(mingJie-Ou): 2021/2/8 给musicScore加上判定
        this.toSky(musicScore, path);
    }

    /**
     * 转为光遇谱子
     *
     * @param musicScore 转好的乐谱
     * @param path 路径名
     */
    public void toSky(MusicScore musicScore, String path) {
        File file = new File(path);
        final int baseValue = musicScore.getBaseValue();
        final Map<Integer, String> pressMap = this.generateCallPress();
        try (FileWriter writer = new FileWriter(file);
             final BufferedWriter out = new BufferedWriter(writer)) {
            // 写入头文件
            out.write(Constants.HEAD_TEXT);
            out.newLine();
            // 写入按键函数
            for (String pressString : this.generateFunctionPress()) {
                out.write(pressString);
                out.newLine();
            }
            out.newLine();
            // 遍历写入音符
            int index = 0;
            int rhythm = Constants.BASE_RHYTHM / musicScore.getSpeed();
            for (Syllable syllable : musicScore.getSyllables()) {
                final int interval = syllable.getIndex() - index;
                if (0 != interval) {
                    out.write(String.format(Constants.CALL_SLEEP_TEXT,
                        rhythm * (interval) / NoteLengthEnum.CROTCHETS.getValue()));
                }
                out.write(pressMap.getOrDefault(syllable.computeNoteValue(baseValue), "Error;"));
                if (0 != index && (index % WHOLE.getValue()) == 0 && (syllable.getIndex() % WHOLE.getValue()) != 0 ) {
                    out.newLine();
                }
                index = syllable.getIndex();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将曲速转为Map
     *
     * @param speed 速度
     * @return Integer - String map
     */
    private List<String> translateSpeed(int speed) {
        int rhythm = Constants.BASE_RHYTHM / speed;
        return Arrays.stream(NoteLengthEnum.values())
            .map(NoteLengthEnum::getValue)
            .map(i -> String.format(Constants.WAIT_TIME_TEXT, i, rhythm * i / WHOLE.getValue()))
            .collect(Collectors.toList());
    }

    /**
     * 调用等待函数
     *
     * @param num 等待变量的总个数
     * @return Integer - String map
     */
    private Map<Integer, String> generateCallSleep(int num) {
        return IntStream.range(-1, num)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), i -> {
                if (-1 == i) {
                    return "";
                }
                return String.format(Constants.CALL_SLEEP_TEXT, i);
            }));
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
                    BASE_PITCH + i / PRESS_CHARS.length, i % pressXNum, i / pressXNum);
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
