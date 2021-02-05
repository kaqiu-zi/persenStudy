import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/1/26
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class PatternTest {
    private static final String letter = "[a-zA-Z]";
    private static final Pattern LETTER = Pattern.compile(letter);

    @Test
    public void test() {
        String words = "zx1c3651qw5e1qw31z3v1d4tjf5gzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2j4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2jzx1c3651qw5e1qw31z3v1d4tjf5g4j65a1s53d1z3x5v1df5h4fg2j";
        LocalDateTime one, two;
        String result;
        final int num = 100 ;
        one = LocalDateTime.now();
        for (int i = 0 ; i < num ; i++) {
            result = Stream.of(words.split(""))
                // 正则表达式
                .filter(s -> s.matches(letter))
                .collect(Collectors.joining());
        }
        two = LocalDateTime.now();
        System.out.println("first time:" + Duration.between(one, two));


        one = LocalDateTime.now();
        for (int i = 0 ; i < num ; i++) {
            result = Stream.of(words.split(""))
                // 正则表达式
                .filter(s -> LETTER.matcher(s).matches())
                .collect(Collectors.joining());
        }
        two = LocalDateTime.now();
        System.out.println("second time:" + Duration.between(one, two));

    }
}
