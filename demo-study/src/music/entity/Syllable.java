package music.entity;

import music.BusinessException;
import music.constant.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/2
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class Syllable implements Comparable<Syllable> {
    /** 序号 */
    private int index;
    /** 音符，C D E F G A B */
    private NoteEnum note;
    /** 音高，1，2，3，4，5，6，7，8，9 */
    private int pitch;
    /** 音长，此属性暂时不使用 */
    private NoteLengthEnum noteLength = NoteLengthEnum.ZERO;

    private Syllable() {
    }

    /**
     * 从单一字符串转为音符，遵循特殊规则。没有参数校验，必须保证参数正确。
     * <pre>
     *     1、简谱必须含有一个合法数字，五线谱需要含有一个字母和数字
     *     2、可选项，'' ,,
     *     3、可选项，音长符号
     * </pre>
     *
     * @param s 符合规则的字符串
     * @return 音符
     */
    public static Syllable from(String s) {
        Syllable syllable = new Syllable();
        // 判断是五线谱还是简谱，存在字母则为五线谱，否则为简谱
        Optional<NoteEnum> noteOptional = generateNoteByChar(s);
        if (noteOptional.isPresent()) {
            // 五线谱
            syllable.note = noteOptional.get();
            Character pitch = s.chars()
                .filter(c -> Constants.MIN_FIVE_NOTE <= c && c <= Constants.MAX_FIVE_NOTE)
                .mapToObj(c -> (char) c)
                .findFirst()
                .orElseThrow(() -> new BusinessException("五线谱缺少音高符"));
            syllable.pitch = pitch - Constants.ZERO_NOTE;
        } else {
            // 简谱
            Character note = s.chars()
                .filter(c -> Constants.ZERO_NOTE <= c && c <= Constants.MAX_NOTE)
                .mapToObj(c -> (char) c)
                .findFirst()
                .orElseThrow(() -> new BusinessException("简谱中不含有数字"));
            syllable.note = NoteEnum.from(note - Constants.ZERO_NOTE);
            // 音高
            syllable.pitch = generatePitchByNum(s);
        }

    }

    private static Optional<NoteLengthEnum> generateLength(String s) {
        StringBuilder sb = new StringBuilder();
        Optional<Character> length = s.chars()
            .filter(NoteLengthEnum::isLength)
            .mapToObj(c -> (char) c)
            .findFirst();
        if (!length.isPresent()) {
            return Optional.of(NoteLengthEnum.ZERO);
        }
        sb.append(length.get());
        long num = s.chars()
            .filter(NoteLengthEnum::isLength)
            .count();
        for (; num > 1; num--) {
            sb.append(length.get());
        }
        s.chars()
            .filter(c -> Constants.POINT_PITCH == c)
            .findFirst()
            .ifPresent(c -> sb.append(Constants.POINT_PITCH));
        return Optional.ofNullable(NoteLengthEnum.from(sb.toString()));
    }

    private static int generatePitchByNum(String s) {
        Optional<Character> pitch = s.chars()
            .filter(c -> Constants.HIGH_PITCH == c || Constants.LOW_PITCH == c)
            .mapToObj(c -> (char) c)
            .findFirst();
        if (pitch.isPresent()) {
            long num = s.chars()
                .filter(c -> Constants.HIGH_PITCH == c || Constants.LOW_PITCH == c)
                .count();
            if (Constants.LOW_PITCH == pitch.get()) {
                return Constants.BASE_PITCH - (int) num;
            }
            return Constants.BASE_PITCH + (int) num;
        }
        return Constants.BASE_PITCH;
    }

    private static Optional<NoteEnum> generateNoteByChar(String s) {
        StringBuilder sb = new StringBuilder();
        Optional<Character> note = s.chars()
            .filter(c -> Constants.A_NOTE <= c && c <= Constants.STOP_NOTE)
            .mapToObj(c -> (char) c)
            .findFirst();
        if (!note.isPresent()) {
            return Optional.empty();
        }
        sb.append(note.get());
        if (Constants.STOP_NOTE == note.get()) {
            return Optional.of(NoteEnum.ZERO);
        }
        s.chars()
            .filter(c -> Constants.HIGH_NOTE == c || Constants.LOW_NOTE == c)
            .mapToObj(c -> (char) c)
            .findFirst()
            .ifPresent(sb::append);
        return Optional.ofNullable(NoteEnum.from(sb.toString()));
    }


    public int computeNotValue(int baseNoteValue) {
        return pitch * 12 + note.getValue() - baseNoteValue;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Syllable o) {
        if (null == o) {
            throw new NullPointerException();
        }
        if (this.index == o.index) {
            return 0;
        }
        return this.index > o.index ? 1 : -1;
    }

    @Override
    public String toString() {
        return "index=" + index +
            ", note=" + note + pitch +
            ", noteLength=" + noteLength;
    }
}
