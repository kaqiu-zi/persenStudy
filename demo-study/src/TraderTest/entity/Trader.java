package TraderTest.entity;

/**
 * 例题 交易员类
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/29 09:50
 * @since 1.0.0
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
    }
}
