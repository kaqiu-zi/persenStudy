package music.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static music.constant.Constants.LENGTH_MULTIPLE;
import static music.constant.Constants.SPLIT_NUM;

/**
 * 符值枚举类
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/2
 * @since 1.0.0
 */
public enum NoteLengthEnum {
    /** 同时音 */
    ZERO(0, ""),
    /** 16分音符 */
    SIXTEEN(LENGTH_MULTIPLE, "+"),
    /** 8分音符 */
    QUAVER(2 * LENGTH_MULTIPLE, "~"),
    /** 8分·音符 */
    QUAVER_POINT(3 * LENGTH_MULTIPLE, "~*"),
    /** 4分音符，分割为三 */
    CROTCHETS_SPLIT(4 * LENGTH_MULTIPLE / SPLIT_NUM, "-^"),
    /** 4分音符 */
    CROTCHETS(4 * LENGTH_MULTIPLE, "-"),
    /** 4分·音符 */
    CROTCHETS_POINT(6 * LENGTH_MULTIPLE, "-*"),
    /** 2分音符 */
    MINIMS(8 * LENGTH_MULTIPLE, "="),
    MINIMS_DOUBLE(8 * LENGTH_MULTIPLE, "--"),
    /** 2分·音符 */
    MINIMS_POINT(12 * LENGTH_MULTIPLE, "=*"),
    MINIMS_DOUBLE_POINT(12 * LENGTH_MULTIPLE, "--*"),
    /** 全音符 */
    WHOLE(16 * LENGTH_MULTIPLE, "&"),
    WHOLE_DOUBLE(16 * LENGTH_MULTIPLE, "=="),
    WHOLE_FOUR(16 * LENGTH_MULTIPLE, "----");

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
}
