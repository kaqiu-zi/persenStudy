package music.test;

import music.constant.Constants;
import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.entity.Syllable;
import music.service.MusicScanService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * 一个普通的测试类
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/5
 * @since 1.0.0
 */
public class MusicScoreTest {

    @Test
    public void test() {
        final MusicScanService musicScanService = MusicScanService.of();

        MusicScore musicScore = musicScanService.scan(Constants.FILE_PATH);

        Assertions.assertNotNull(musicScore.getSyllables());
        LinkedList<Syllable> list = musicScore.getSyllables();
        Assertions.assertEquals(16, list.size());
        System.out.println(musicScore.getSyllables());
    }

    @Test
    public void test2() {
        NoteEnum noteEnum = NoteEnum.from(7);
        Assertions.assertNotNull(noteEnum);
    }
}
