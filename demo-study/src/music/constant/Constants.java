package music.constant;

import java.util.Arrays;
import java.util.HashSet;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/5
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class Constants {
    private Constants() {
    }

    /** 文件写入路径名 */
    public static final String FILE_PATH = "D:/sky/test.txt";
    /** 文件输出路径名 */
    public static final String FILE_PATH_WRITE = "D:/sky/test_out.js";
    /** JavaScript */
    public static final String JAVA_SCRIPT = "JavaScript";
    /** staff */
    public static final String STAFF_TRUE = "Staff:true";
    /** staff */
    public static final String STAFF_FALSE = "Staff:false";
    /** 速度 */
    public static final String SPEED_TEXT = "Speed:";
    /** 行数 */
    public static final String ROWS_TEXT = "Rows:";
    /** 最大行数 */
    public static final int MAX_ROWS = 99;
    /** 文件头部 */
    public static final String HEAD_TEXT = "var x=2340;var x0=760;var x1=960.0;var x2=1160.0;var x3=1360.0;var x4=1560;var y=1080;var y0=200;var y1=400.0;var y2=600;";
    /** 时间js文本 */
    public static final String WAIT_TIME_TEXT = "var time%d = %d;";
    /** 各按键js文本 */
    public static final String PRESS_TEXT = "function %c%d() press(x%d, y%d, 1);";
    /** 调用各按键js文本 */
    public static final String CALL_PRESS_TEXT = "%c%d();";
    /** 调用等待时间js文本 */
    public static final String CALL_SLEEP_TEXT = "sleep(%d);";
    /** 按键总数 */
    public static final int PRESS_SIZE = 15;
    /** 一行的按键个数 */
    public static final int PRESS_X_NUM = 5;
    /** 可用音阶数，只能使用7 或 12 */
    public static final char[] PRESS_CHARS = {'c', 'd', 'e', 'f', 'g', 'a', 'b'};
    /** 时值的倍数 */
    public static final int LENGTH_MULTIPLE = 3;

    /** 中央C位置 */
    public static final int BASE_PITCH = 4;
    /** 节拍 */
    public static final int BASE_RHYTHM = 60000;
    /** 简谱 休止符 */
    public static final char NUMBER_STOP = '0';
    /** 五线谱 休止符 */
    public static final char STAFF_STOP = 'H';
    /** 升高半音 */
    public static final char HIGH_NOTE = '#';
    /** 降低半音 */
    public static final char LOW_NOTE = 'b';
    /** 高音符 */
    public static final char HIGH_PITCH = '\'';
    /** 低音符 */
    public static final char LOW_PITCH = ',';
    /** 附点符 */
    public static final char POINT_PITCH = '*';
    /** 分割音符 */
    public static final char SPLIT_PITCH = '^';
    /** 分割音符的分割数 */
    public static final int SPLIT_NUM = 3;
    /** 保留符号，目前用于分割小节，实际上不作任何作用。 */
    public static final char END = '$';

    /** 简谱有效数字 */
    public static final HashSet<Character> NUMBER_SET = new HashSet<>(Arrays.asList(
        '0', '1', '2', '3', '4', '5', '6', '7'));
    /** 简谱有效音高 */
    public static final HashSet<Character> NUMBER_PITCH_SET = new HashSet<>(Arrays.asList(
        HIGH_PITCH, LOW_PITCH));
    /** 五线谱有效字符 */
    public static final HashSet<Character> STAFF_SET = new HashSet<>(Arrays.asList(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'));
    /** 五线谱有效高音数字 */
    public static final HashSet<Character> STAFF_PITCH_SET = new HashSet<>(Arrays.asList(
        '1', '2', '3', '4', '5', '6', '7'));
    /** 五线谱有效半音符号 */
    public static final HashSet<Character> STAFF_HALF_SET = new HashSet<>(Arrays.asList(
        HIGH_NOTE, LOW_NOTE));
    /** 有效时值符 */
    public static final HashSet<Character> NOTE_LENGTH_SET = new HashSet<>(Arrays.asList(
        '&', '=', '-', '~', '+'));

}
