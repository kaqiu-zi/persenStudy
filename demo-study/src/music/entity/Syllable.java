package music.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/2
 * @since 1.0.0 TODO:需要跟随版本号
 */
@Data
@NoArgsConstructor
@Builder
public class Syllable implements Comparable<Syllable> {
    /** 序号 */
    private int index;
    /** 音符，C D E F G A B */
    private NoteEnum note;
    /** 音高，1，2，3，4，5，6，7，8，9*/
    private int pitch;
    /** 音长，此属性暂时不使用 */
    private NoteLengthEnum noteLength;

    public Syllable(int index, NoteEnum note, int pitch, NoteLengthEnum noteLength) {
        this.index = index;
        this.note = note;
        this.pitch = pitch;
        this.noteLength = noteLength;
    }

    public int computeNotValue(int baseNoteValue) {
        return pitch * 12 + note.getValue() - baseNoteValue;
    }

    public int addLength(NoteLengthEnum noteLength) {
        int origin = this.noteLength.getValue();
        this.noteLength = NoteLengthEnum.add(this.noteLength, noteLength);
        return this.noteLength.getValue() - origin;
    }

    public int pointLength() {
        if (NoteLengthEnum.isPoint(this.noteLength)) {
            throw new NullPointerException("已经加过点");
        }
        // TODO(mingJie-Ou): 2021/2/5 补充实现
        return 0;
    }

    public void addPitch() {
        this.pitch++;
    }

    public void minusPitch() {
        this.pitch--;
    }

    public int getIndex() {
        return index;
    }

    public NoteEnum getNote() {
        return note;
    }

    public int getPitch() {
        return pitch;
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
}
