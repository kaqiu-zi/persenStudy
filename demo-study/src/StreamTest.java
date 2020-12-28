import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 测试Stream流
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/27 20:22
 * @since 1.0.0
 */
public class StreamTest {
    @Test
    public void testStreamWords() {
        String str = "We Attack123At2@Dawn";
        String result = streamWords(str);
        assertEquals("atwcdekn", result);
    }

    /**
     * 通过流，将字符串重新拆分，按照字母出现的频率重新组合，频率一样则按照字典序
     *
     * @param words 要统计的单词
     * @return 组合结果
     */
    public static String streamWords(String words) {
        return Stream.of(words.split(""))
            .filter(i -> i.matches("[a-zA-Z]"))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(String::toString, Collectors.counting())).entrySet().stream()
            // 对分组排序，如果出现的次数相同，则根据字典序排序
            .sorted((v1, v2) -> 0 == v2.getValue().compareTo(v1.getValue()) ?
                v1.getKey().compareTo(v2.getKey()) : v2.getValue().compareTo(v1.getValue()))
            .flatMap(k -> Stream.of(k.getKey()))
            .collect(Collectors.joining());
    }
}
