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
    /** zero */
    ZERO(0),
    /** 32分音符 */
    THIRTY_SECOND(1),
    /** 16分音符 */
    SIXTEEN(2),
    /** 16分·音符 */
    SIXTEEN_POINT(3),
    /** 8分音符 */
    QUAVER(4),
    /** 8分·音符 */
    QUAVER_POINT(4),
    /** 4分音符 */
    CROTCHETS(8),
    /** 4分·音符 */
    CROTCHETS_POINT(12),
    /** 2分音符 */
    MINIMS(16),
    /** 2分·音符 */
    MINIMS_POINT(24),
    /** 全音符 */
    WHOLE(32),
    /** 全·音符 */
    WHOLE_PONT(48);

    private final int value;
    private static final Map<Integer, NoteLengthEnum> VALUE_MAP = Arrays.stream(NoteLengthEnum.values()).collect(Collectors.toMap(NoteLengthEnum::getValue, Function.identity()));
    private static final HashSet<NoteLengthEnum> POINT_SET = new HashSet<>(Arrays.asList(SIXTEEN_POINT, QUAVER_POINT, CROTCHETS_POINT, MINIMS_POINT, WHOLE_PONT));

    public static NoteLengthEnum from(int num) {
        return VALUE_MAP.get(num);
    }

    NoteLengthEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NoteLengthEnum add(NoteLengthEnum one, NoteLengthEnum two) {
        if (null == one || two == null) {
            return null;
        }
        return VALUE_MAP.get(one.getValue() + two.getValue());
    }

    public static NoteLengthEnum point(NoteLengthEnum origin) {
        if (null == origin) {
            return null;
        }
        if (NoteLengthEnum.isPoint(origin)) {
            throw new NullPointerException("存在多重加点的情况");
        }
        return VALUE_MAP.get(origin.getValue() + origin.getValue() / 2);
    }

    public static boolean isPoint(NoteLengthEnum origin) {
        if (null == origin) {
            throw new NullPointerException();
        }
        return POINT_SET.contains(origin);
    }

}
