package TraderTest.entity;

import TraderTest.entity.dao.TraderDAO;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 小测试
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/29 10:12
 * @since 1.0.0
 */
public class TraderTest {

    private final static List<Transaction> daoTa = TraderDAO.transactionList;
    private final static List<Trader> daoTr = TraderDAO.tradersList;

    /**
     * 输出
     * [Transaction{trader=Trader{name='Brian', city='Cambridge'}, year=2011, value=300}, Transaction{trader=Trader{name='Raoul', city='Cambridge'}, year=2011, value=400}]
     * [Cambridge, Milan]
     * [Trader{name='Alan', city='Cambridge'}, Trader{name='Brian', city='Cambridge'}, Trader{name='Raoul', city='Cambridge'}]
     * [Alan, Brian, Mario, Raoul]
     * true
     * 2650
     * 1000
     * Transaction{trader=Trader{name='Brian', city='Cambridge'}, year=2011, value=300}
     * 4060
     * {2011=700, 2012=3360}
     * Trader{name='Mario', city='Milan'}
     */
    @Test
    public void allTest() {
        System.out.println(findTransaction());
        System.out.println(findLocation());
        System.out.println(findTrader());
        System.out.println(findAllTrader());
        System.out.println(findMiLan());
        printCambridgeTrader();
        System.out.println(findMaxValue());
        System.out.println(findMinTransaction());
        System.out.println(totalAllValue());
        printByYear();
        System.out.println(findMaxPerson());

    }

    /** 找出2011年发生的所有交易，并按交易额排序(从低到高) */
    public List<Transaction> findTransaction() {
        return daoTa.stream()
            .filter(t -> 2011 == t.getYear())
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
    }

    /** 交易员都在哪些不同的城市工作过 */
    public List<String> findLocation() {
        return daoTr.stream()
            .map(Trader::getCity)
            .distinct()
            .collect(Collectors.toList());
    }

    /** 查找所有来自于剑桥的交易员，并按名字排序 */
    public List<Trader> findTrader() {
        return daoTr.stream()
            .filter(t -> "Cambridge".equals(t.getCity()))
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
    }

    /** 返回所有交易员的姓名字符串，按字母顺序排序 */
    public List<String> findAllTrader() {
        return daoTr.stream()
            .sorted(Comparator.comparing(Trader::getName))
            .map(Trader::getName)
            .collect(Collectors.toList());
    }

    /** 有没有交易员是在米兰工作的 */
    public boolean findMiLan() {
        return daoTr.stream().anyMatch(t -> "Milan".equals(t.getCity()));
    }

    /** 打印生活在剑桥的交易员的所有交易额 */
    public void printCambridgeTrader() {
        int sum = daoTa.stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .mapToInt(Transaction::getValue)
            .sum();
        System.out.println(sum);
    }

    /** 所有交易中，最高的交易额是多少 */
    public int findMaxValue() {
        Optional<Transaction> max = daoTa.stream().max(Comparator.comparing(Transaction::getValue));
        return max.get().getValue();
    }

    /** 找到交易额最小的交易 */
    public Transaction findMinTransaction() {
        return daoTa.stream().min(Comparator.comparing(Transaction::getValue)).get();
    }

    /** 所有人的交易总额是多少 */
    public int totalAllValue() {
        return daoTa.stream()
            .mapToInt(Transaction::getValue)
            .sum();
    }

    /** 根据年份分组，打印每年的交易总额 */
    public void printByYear() {
        Map<Integer, Integer> result = daoTa.stream()
            .collect(Collectors.groupingBy(Transaction::getYear,
                Collectors.summingInt(Transaction::getValue)));
        System.out.println(result);
    }

    /** 找出每个人交易总额中，最高的那一个人 */
    public Trader findMaxPerson() {
        return daoTa.stream()
            .collect(Collectors.groupingBy(Transaction::getTrader,
                Collectors.summingInt(Transaction::getValue))).entrySet().stream()
            .max(Map.Entry.comparingByValue()).get().getKey();
    }
}
