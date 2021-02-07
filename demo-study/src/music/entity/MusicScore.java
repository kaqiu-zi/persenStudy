package music.entity;


import music.BusinessException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
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
    /** 基准音，默认 */
    private String baseNote;
    /** 音符数 */
    private int size;
    /** 曲速 */
    private int speed;

    private static final HashSet<Character> availableSet = new HashSet<>(Arrays.asList(
        '0', '1', '2', '3', '4', '5', '6', '7', '\'', ',', '&', '-', '=', '~', '#', '^', '*', '$'));
    private MusicScore() {}

    /**
     * 生成光遇谱，需要设定曲速
     *
     * @return
     */
    public String toLight() {
        return null;
    }

    /**
     * <pre>
     *     有效字符：
     *     0 ~ 7 ： 简谱音符
     *     '' ,, ： 简谱音高、音低符
     *     &-~=#^： 全音符、二分音符...三十二分音符，能使用一个符号，就不要使用两个符号，减少重复。
     *     $     ： 终止符，这之后的任何输入都不再影响结果。
     * </pre>
     * <p>例子： 5~=5=2'~=2'=3'~=3'=1'~=1'=</p>
     * <p>没有做太多的参数校验，请保证输入的格式正确，否则输出的结果无法保证</p>
     *
     * @param s 简谱表
     * @return 转换好的乐谱
     * @throws NullPointerException 如果不规范
     */
    public static MusicScore from(String s) {
        // 参数校验
        char[] chars = StringUtils.trimToEmpty(s).toCharArray();
        if (chars.length < 1) {
            throw new BusinessException("字符串不能为空");
        }

        MusicScore musicScore = new MusicScore();
        // 索引
        int index = 0;
        // 当前音符
        Syllable syllable = null;
        // 主循环
        for (char c : chars) {
            if (!availableSet.contains(c)) {
                throw new BusinessException("含有非法字符");
            }
            // 获取简谱的数字
            if (ZERO_NOTE <= c && MAX_NOTE > c) {
                if (null != syllable) {
                    musicScore.syllables.add(syllable);
                }
//                syllable = new Syllable(index, NoteEnum.from(c - ONE_NOTE), BASE_PITCH);
            }
            if (HIGH_PITCH == c) {
                syllable.addPitch();
            } else if (LOW_PITCH == c) {
                syllable.minusPitch();
            }
            // 音长的判断
            if (NoteLengthEnum.isLength(c)) {
                index += syllable.addLength(c);
            }
            // 终结符
            if (END == c) {
                musicScore.syllables.add(syllable);
                break;
            }
        }
        return musicScore;
    }

    public LinkedList<Syllable> getSyllables() {
        return syllables;
    }
}
