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

    /** 文件路径名 */
    public static final String FILE_PATH = "D:/c.txt";
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
    public static final String HEAD_TEXT = "var x=2340;var x1=760;var x2=960.0;var x3=1160.0;var x4=1360.0;var x5=1560;var y=1080;var y1=200;var y2=400.0;var y3=600;";
    /** 各按键js文本 */
    public static final String PRESS_ZERO = "";
    public static final String PRESS_ONE = "function c4() press(x1, y1, 1);";
    public static final String PRESS_TWO = "function d4() press(x2, y1, 1);";
    public static final String PRESS_THREE = "function e4() press(x3, y1, 1);";
    public static final String PRESS_FOUR = "function f4() press(x4, y1, 1);";
    public static final String PRESS_FIVE = "function g4() press(x5, y1, 1);";
    public static final String PRESS_SIX = "function a4() press(x1, y2, 1);";
    public static final String PRESS_SEVEN = "function b4() press(x2, y2, 1);";
    public static final String PRESS_EIGHT = "function c5() press(x3, y2, 1);";
    public static final String PRESS_NINE = "function d5() press(x4, y2, 1);";
    public static final String PRESS_TEN = "function e5() press(x5, y2, 1);";
    public static final String PRESS_ELEVEN = "function f5() press(x1, y3, 1);";
    public static final String PRESS_TWELVE = "function g5() press(x2, y3, 1);";
    public static final String PRESS_THIRTEEN = "function a5() press(x3, y3, 1);";
    public static final String PRESS_FOURTEEN = "function b5() press(x4, y3, 1);";
    public static final String PRESS_FIFTEEN = "function c6() press(x5, y3, 1);";

    /** 中央C位置 */
    public static final int BASE_PITCH = 4;
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
    /** 保留符号，实际上没有作用 */
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