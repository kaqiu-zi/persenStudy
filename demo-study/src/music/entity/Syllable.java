package music.entity;

import music.common.BusinessException;
import music.constant.Constants;

import java.util.Optional;

/**
 * 音符类
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/2
 * @since 1.0.0
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

    private Syllable(int index) {
        this.index = index;
    }

    /**
     * 从单一字符串转为音符，遵循特殊规则。没有参数校验，必须保证参数正确。
     * <pre>
     *     1、简谱必须含有一个合法数字，五线谱需要含有一个字母和数字
     *     2、可选项，'' ,,
     *     3、可选项，音长符号
     * </pre>
     *
     * @param s     符合规则的字符串
     * @param index 当前序号
     * @return 音符
     */
    public static Syllable from(String s, int index) {
        Syllable syllable = new Syllable(index);
        // 判断是五线谱还是简谱，存在字母则为五线谱，否则为简谱
        Optional<NoteEnum> noteOptional = generateNoteByChar(s);
        if (noteOptional.isPresent()) {
            // 五线谱
            syllable.note = noteOptional.get();
            Character pitch = s.chars()
                .mapToObj(c -> (char) c)
                .filter(Constants.STAFF_PITCH_SET::contains)
                .findFirst()
                .orElseThrow(() -> new BusinessException(s + "五线谱缺少音高符"));
            syllable.pitch = pitch - Constants.NUMBER_STOP;
        } else {
            // 简谱
            Character note = s.chars()
                .mapToObj(c -> (char) c)
                .filter(Constants.NUMBER_SET::contains)
                .findFirst()
                .orElseThrow(() -> new BusinessException(s + "简谱中不含有数字"));
            syllable.note = NoteEnum.from(note - Constants.NUMBER_STOP);
            // 音高
            syllable.pitch = generatePitchByNum(s);
        }
        // 时值
        syllable.noteLength = generateLength(s).orElseThrow(() -> new BusinessException(s + "音符时值无法判断"));
        return syllable;
    }

    public int computeNoteValue(int baseNoteValue) {
        if (NoteEnum.ZERO == this.note) {
            return this.note.getValue();
        }
        return pitch * 12 + note.getValue() - baseNoteValue;
    }

    public int getIndex() {
        return index;
    }

    public NoteLengthEnum getNoteLength() {
        return noteLength;
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

    /**
     * 获取 音符的时值
     *
     * @param s 字符串
     * @return 时值
     */
    private static Optional<NoteLengthEnum> generateLength(String s) {
        StringBuilder sb = new StringBuilder();
        Optional<Character> length = s.chars()
            .mapToObj(c -> (char) c)
            .filter(Constants.NOTE_LENGTH_SET::contains)
            .findFirst();
        if (!length.isPresent()) {
            return Optional.of(NoteLengthEnum.ZERO);
        }
        sb.append(length.get());
        long num = s.chars()
            .mapToObj(c -> (char) c)
            .filter(Constants.NOTE_LENGTH_SET::contains)
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

    /**
     * 通过 简谱的方式生成音符
     *
     * @param s 字符串
     * @return 音符
     */
    private static int generatePitchByNum(String s) {
        Optional<Character> pitch = s.chars()
            .mapToObj(c -> (char) c)
            .filter(Constants.NUMBER_PITCH_SET::contains)
            .findFirst();
        if (pitch.isPresent()) {
            long num = s.chars()
                .mapToObj(c -> (char) c)
                .filter(Constants.NUMBER_PITCH_SET::contains)
                .count();
            if (Constants.LOW_PITCH == pitch.get()) {
                return Constants.BASE_PITCH - (int) num;
            }
            return Constants.BASE_PITCH + (int) num;
        }
        return Constants.BASE_PITCH;
    }

    /**
     * 通过 五线谱的方式生成音符。
     *
     * @param s 字符串
     * @return 音符
     */
    private static Optional<NoteEnum> generateNoteByChar(String s) {
        StringBuilder sb = new StringBuilder();
        Optional<Character> note = s.chars()
            .mapToObj(c -> (char) c)
            .filter(Constants.STAFF_SET::contains)
            .findFirst();
        if (!note.isPresent()) {
            return Optional.empty();
        }
        sb.append(note.get());
        if (Constants.STAFF_STOP == note.get()) {
            return Optional.of(NoteEnum.ZERO);
        }
        s.chars()
            .mapToObj(c -> (char) c)
            .filter(Constants.STAFF_HALF_SET::contains)
            .findFirst()
            .ifPresent(sb::append);
        return Optional.ofNullable(NoteEnum.from(sb.toString()));
    }

}
