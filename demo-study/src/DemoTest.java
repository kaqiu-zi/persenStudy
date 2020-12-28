import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaqiu-omj
 * @version 1.0 2020/12/22 09:53
 * @since 1.0.0
 */

public class DemoTest {


    @Test
    public void testPECS_fail() {
        List<? super Fruit> list1 = new ArrayList<>();
//        List<? extends Fruit> list1 = new ArrayList<>();

        try {
//            list1.add(new Foo());
//            list1.add(new Fruit());
//            list1.add(new Apple());
//            list1 = new ArrayList<Foo>();
//            list1 = new ArrayList<Fruit>();
//            list1 = new ArrayList<Apple>();
//            list1.add(new Apple());
//            Fruit fruit = list1.get(0);
//            Object object = list1.get(0);

        } catch (Exception e) {

        }
    }

    static class Apple extends Fruit {

    }

    static class Fruit extends Foo {

    }

    static class Foo {

    }


}
