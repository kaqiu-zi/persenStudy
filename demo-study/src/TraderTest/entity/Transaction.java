package TraderTest.entity;

/**
 * 例题 交易类
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/29 09:51
 * @since 1.0.0
 */
public class Transaction {
    private final Trader trader;
    private final Integer year;
    private final Integer value;

    public Transaction(Trader trader, Integer year, Integer value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "trader=" + trader +
            ", year=" + year +
            ", value=" + value +
            '}';
    }
}
