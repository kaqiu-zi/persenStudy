package music.entity;


import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

/**
 * 乐谱类，使用linkedList存储音符
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/3
 * @since 1.0.0
 */
public class MusicScore {
    /** 存储音符的list */
    private final LinkedList<Syllable> syllables = new LinkedList<>();
    /** 基准音，默认C4，C5 */
    private String baseNote;
    /** 音符数 */
    private int size;
    /** 曲速 */
    private int speed;
    private static final int BASE_PITCH = 4;
    private static final char END = '$';
    private static final char HIGH_PITCH = '\'';
    private static final char LOW_PITCH = ',';
    private static final char LENGTH_PITCH = '~';
    private static final char MINUS_LENGTH_PITCH = '_';
    private static final char ZERO_NOTE = '0';
    private static final char MAX_NOTE = '8';
    private MusicScore() {}

    /**
     * 形如123~~4~5~6~~~~7~~~才能转换
     * 简谱
     * <p>必须以数字打头，以~作为间隔，以$符号结尾</p>
     *
     * @param s 简谱表
     * @return 转换好的乐谱
     * @throws NullPointerException 如果不规范
     */
    public static MusicScore from(String s) {
        MusicScore musicScore = new MusicScore();
        char[] chars = StringUtils.trimToEmpty(s).toCharArray();
        if (chars.length < 1) {
            throw new NullPointerException();
        }
        // 索引
        int index = 0;
        // 当前音符
        Syllable syllable = null;
        // 保险
        boolean enableHigh = false;
        boolean enableLow = false;

        for (char c : chars) {
            if (ZERO_NOTE < c && MAX_NOTE > c) {
                if (null != syllable) {
                    musicScore.syllables.add(syllable);
                }
                syllable = new Syllable(index, NoteEnum.from(c - ZERO_NOTE), BASE_PITCH, NoteLengthEnum.ZERO);
//                syllable = Syllable.builder()
//                    .index(index)
//                    .note(NoteEnum.from(c - ZERO_NOTE))
//                    .pitch(BASE_PITCH)
//                    .build();
                enableHigh = true;
                enableLow = true;
                continue;
            }
            if (enableHigh && HIGH_PITCH == c) {
                enableLow = false;
                syllable.addPitch();
                continue;
            } else if (enableLow && LOW_PITCH == c) {
                enableHigh = false;
                syllable.minusPitch();
                continue;
            }
            // 延长音的判定
            if (LENGTH_PITCH == c || MINUS_LENGTH_PITCH == c) {
                if (null == syllable) {
                    throw new NullPointerException();
                }
                enableHigh = false;
                enableLow = false;
                if (LENGTH_PITCH == c) {
                    syllable.addLength(NoteLengthEnum.QUAVER);
                    index += 4;
                } else {
                    syllable.addLength(NoteLengthEnum.SIXTEEN);
                    index += 2;
                }
                continue;
            }
            if (END == c) {
                musicScore.syllables.add(syllable);
                break;
            }
            throw new NullPointerException();
        }
        return musicScore;
    }

    public LinkedList<Syllable> getSyllables() {
        return syllables;
    }
}
