package music.test;

import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.entity.Syllable;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/5
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class MusicScoreTest {

    @Test
    public void test() {
        String s = "756~451~~123~~~$";

        MusicScore musicScore = MusicScore.from(s);
        Assertions.assertNotNull(musicScore.getSyllables());
        LinkedList<Syllable> list = musicScore.getSyllables();
        Assertions.assertEquals(9, list.size());
        System.out.println(s);
    }

    @Test
    public void test2() {
        NoteEnum noteEnum = NoteEnum.from(7);
        Assertions.assertNotNull(noteEnum);
    }
}
