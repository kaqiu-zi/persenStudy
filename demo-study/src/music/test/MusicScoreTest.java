package music.test;

import music.constant.Constants;
import music.entity.MusicScore;
import music.entity.NoteEnum;
import music.service.MusicScanService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        musicScanService.toSky(musicScore, Constants.FILE_PATH_WRITE, "D4");
    }

    @Test
    public void test2() {
        NoteEnum noteEnum = NoteEnum.from(7);
        Assertions.assertNotNull(noteEnum);
    }
}
