import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * lambda表达式的产出
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/23 14:12
 * @since 1.0.0
 */
public class LambdaDemoTest {

    @Test
    public void test2() {
        String str = "We Attack123At2@Dawn";
        String result = streamP(str);
        assertEquals("atwcdekn", result);
    }

    public String streamP(String words) {
        return Stream.of(words.split(""))
            // 过滤字母
            .filter(i -> i.matches("[a-zA-Z]"))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(String::toString, Collectors.counting())).entrySet().stream()
            // 对分组排序，如果出现的次数相同，则根据字典序排序
            .sorted((v1, v2) -> 0 == v2.getValue().compareTo(v1.getValue()) ?
                v1.getKey().compareTo(v2.getKey()) : v2.getValue().compareTo(v1.getValue()))
            .flatMap(k -> Stream.of(k.getKey()))
            .collect(Collectors.joining());
    }

    /** 筛选颜色苹果 */
    public List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 筛选条件
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public  void prettyPrintApple(List<Apple> inventory, ApplePrint applePrint) {
        for (Apple apple: inventory) {
            String output = applePrint.print(apple);
            System.out.println(output); }
    }

    public void test() {
        List<Apple> list = new LinkedList<>();
        prettyPrintApple(list, new ApplePrint() {
            @Override
            public String print(Apple apple) {
                return apple.getColor();
            }
        });
    }

    interface ApplePredicate {
        /** 接口标准建模 */
        boolean test (Apple apple);
    }

    interface ApplePrint {
        String print (Apple apple);
    }




    private class Apple {
        private String color;

        public String getColor() {
            return color;
        }
    }

}
