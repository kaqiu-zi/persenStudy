package music.constant;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/5
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class Constants {
    private Constants(){}

    public static final String HEAD_TEXT = "var x=2340;var x1=760;var x2=960.0;var x3=1160.0;var x4=1360.0;var x5=1560;var y=1080;var y1=200;var y2=400.0;var y3=600;";

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
    public static final char ZERO_NOTE = '0';
    /** 简谱 c音 */
    public static final char ONE_NOTE = '1';
    /** 简谱 b音 */
    public static final char MAX_NOTE = '7';

    /** 五线谱的最高音 */
    public static final char MAX_FIVE_NOTE = '7';

    /** 五线谱的最低音 */
    public static final char MIN_FIVE_NOTE = '1';


    /** 五线谱 休止符 */
    public static final char STOP_NOTE = 'H';
    /** 五线谱 a音 */
    public static final char A_NOTE = 'A';
    /** 五线谱 g音 */
    public static final char G_NOTE = 'G';
    /** 升高半音 */
    public static final char HIGH_NOTE = '#';
    /** 降低半音 */
    public static final char LOW_NOTE = 'b';
    /** 终止符 */
    public static final char END = '$';
    /** 高音符 */
    public static final char HIGH_PITCH = '\'';
    /** 低音符 */
    public static final char LOW_PITCH = ',';
    /** 附点符 */
    public static final char POINT_PITCH = '*';


}
