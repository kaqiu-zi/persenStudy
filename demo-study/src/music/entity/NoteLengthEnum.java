package music.entity;

import java.util.Arrays;
import java.util.HashSet;
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
public enum NoteLengthEnum {
    /** 同时音 */
    ZERO(0, ""),
    /** 16分音符 */
    SIXTEEN(1, "+"),
    /** 8分音符 */
    QUAVER(2, "~"),
    /** 8分·音符 */
    QUAVER_POINT(3, "~*"),
    /** 4分音符 */
    CROTCHETS(4, "-"),
    /** 4分·音符 */
    CROTCHETS_POINT(6, "-*"),
    /** 2分音符 */
    MINIMS(8, "="),
    MINIMS_DOUBLE(8, "--"),
    /** 2分·音符 */
    MINIMS_POINT(12, "=*"),
    MINIMS_DOUBLE_POINT(12, "--*"),
    /** 全音符 */
    WHOLE(16, "&"),
    WHOLE_DOUBLE(16, "=="),
    WHOLE_FOUR(16, "----");

    private final int value;
    private final String string;
    private static final Map<String, NoteLengthEnum> NAME_MAP = Arrays.stream(NoteLengthEnum.values()).collect(Collectors.toMap(NoteLengthEnum::getString, Function.identity()));
    private static final HashSet<Character> NOTE_LENGTH_SET = new HashSet<>(Arrays.asList('&', '=', '-', '~', '+'));

    public static boolean isLength(int c) {
        return NOTE_LENGTH_SET.contains((char) c);
    }

    public static NoteLengthEnum from(String s) {
        return NAME_MAP.get(s);
    }

    NoteLengthEnum(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return string;
    }

    public static NoteLengthEnum point(NoteLengthEnum origin) {
        String s = origin.getString() + "*";
        return NAME_MAP.get(s);
    }
}
