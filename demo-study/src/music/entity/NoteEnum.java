package music.entity;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/2
 * @since 1.0.0 TODO:需要跟随版本号
 */
public enum NoteEnum {
    /** 音符对应数字 */
    ZERO(-1, "0"),
    C(0, "C"),
    Cp(1, "C#"),
    Db(1, "Db"),
    D(2, "D"),
    Dp(3, "D#"),
    Eb(3, "Eb"),
    E(4, "E"),
    F(5, "F"),
    Fp(6, "F#"),
    Gb(6, "Gb"),
    G(7, "G"),
    Gp(8, "G#"),
    Ab(8, "Ab"),
    A(9, "A"),
    Ap(10, "A#"),
    Bb(10, "Bb"),
    B(11, "B");

    private final int value;
    private final String chars;
//    private static final Map<Integer, NoteEnum> VALUE_MAP = Arrays.stream(NoteEnum.values()).collect(Collectors.toMap(NoteEnum::getValue, Function.identity()));
    private static final Map<String, NoteEnum> CHAR_MAP = Arrays.stream(NoteEnum.values()).collect(Collectors.toMap(NoteEnum::getChars, Function.identity()));
    private static final int NUM_ZERO = 0;
    private static final int NUM_SIX = 6;
    private static final int NUM_SEVEN = 7;

    public static NoteEnum from(String c) {
        return CHAR_MAP.get(c);
    }

    public static NoteEnum from(int num) {
        if (num < NUM_ZERO || num > NUM_SEVEN) {
            return null;
        } else if (NUM_ZERO == num) {
            return ZERO;
        }else if (num < NUM_SIX) {
            return CHAR_MAP.get(String.valueOf((char)('B' + num)));
        } else {
            String c = String.valueOf((char)('A' + num - NUM_SIX));
            return CHAR_MAP.get(c);
        }
    }

    NoteEnum(int value, String chars) {
        this.value = value;
        this.chars = chars;
    }

    public int getValue() {
        return value;
    }

    public String getChars() {
        return chars;
    }
}
