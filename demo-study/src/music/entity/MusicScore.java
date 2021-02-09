package music.entity;


import music.common.BusinessException;
import music.constant.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.function.Predicate;

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
    private NoteEnum baseNote = NoteEnum.C;
    /** 基准音高，默认 */
    private int basePitch = Constants.BASE_PITCH;
    /** 音符数 */
    private int size;
    /** 曲速 */
    private int speed;

    private MusicScore() {
    }

    /**
     * <pre>
     *     有效字符：
     *     0 ~ 7 ： 简谱音符
     *     '' ,, ： 简谱音高、音低符
     *     &-~=#^： 全音符、二分音符...三十二分音符，能使用一个符号，就不要使用两个符号，减少重复。
     *     $     ： 保留符号，暂不会起任何作用
     * </pre>
     * <p>例子： 5~=5=2'~=2'=3'~=3'=1'~=1'=</p>
     * <p>没有做太多的参数校验，请保证输入的格式正确，否则输出的结果无法保证</p>
     *
     * @param data 数据字符串
     * @return 转换好的乐谱
     * @throws BusinessException 如果不规范
     */
    public static MusicScore fromNum(String[] data) {
        return fromData(data, Constants.NUMBER_SET::contains);
    }

    /**
     * <pre>
     *     有效字符：
     *     A ~ H ： 五线谱音符
     *     # b   ： 五线谱半音
     *     1 ~ 7 ： 五线谱
     *     &-~=#^： 全音符、二分音符...三十二分音符，能使用一个符号，就不要使用两个符号，减少重复。
     *     $     ： 保留符号，暂不会起任何作用
     * </pre>
     * <p>例子： 5~=5=2'~=2'=3'~=3'=1'~=1'=</p>
     * <p>没有做太多的参数校验，请保证输入的格式正确，否则输出的结果无法保证</p>
     *
     * @param data 数据字符串
     * @return 转换好的乐谱
     * @throws BusinessException 如果不规范
     */
    public static MusicScore fromStaff(String[] data) {
        return fromData(data, Constants.STAFF_SET::contains);
    }

    /**
     * 将数据字符串转为谱子
     *
     * @param data 数据字符串
     * @param predicate 判定条件
     * @return 谱子
     */
    private static MusicScore fromData(String[] data, Predicate<Character> predicate) {
        MusicScore musicScore = new MusicScore();
        // 索引
        int index = 0;
        for (String s : data) {
            char[] chars = StringUtils.trimToEmpty(s).toCharArray();
            if (chars.length < 1) {
                throw new BusinessException("字符串不能为空");
            }
            for (int i = 0; i < chars.length; i++) {
                if (predicate.test(chars[i])) {
                    for (int j = i + 1; j < chars.length; j++) {
                        if (j == chars.length - 1 || predicate.test(chars[j])) {
                            Syllable syllable;
                            if (j == chars.length -1){
                                syllable = Syllable.from(String.valueOf(chars, i, j - i + 1), index);
                            } else {
                                syllable = Syllable.from(String.valueOf(chars, i, j - i), index);
                            }
                            musicScore.syllables.add(syllable);
                            index += syllable.getNoteLength().getValue();
                            i = j - 1;
                            musicScore.size++;
                            break;
                        }
                    }
                }
            }
        }
        return musicScore;
    }

    public int getBaseValue() {
        if (NoteEnum.ZERO == this.baseNote) {
            throw new BusinessException("基准音不能为0");
        }
        return basePitch * 12 + baseNote.getValue();
    }

    public void setBaseNote(NoteEnum note) {
        this.baseNote = note;
    }

    public void setBasePitch(int pitch) {
        this.basePitch = pitch;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Syllable> getSyllables() {
        return syllables;
    }
}
