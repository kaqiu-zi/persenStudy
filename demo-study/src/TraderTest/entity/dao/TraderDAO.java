package TraderTest.entity.dao;

import TraderTest.entity.Trader;
import TraderTest.entity.Transaction;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * 底层写死的数据
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/29 09:54
 * @since 1.0.0
 */
public class TraderDAO {
    public final static List<Trader> tradersList = new ImmutableList.Builder<Trader>()
        .add(new Trader("Raoul", "Cambridge"))
        .add(new Trader("Mario","Milan"))
        .add(new Trader("Alan","Cambridge"))
        .add(new Trader("Brian","Cambridge"))
        .build();

    public final static List<Transaction> transactionList = new ImmutableList.Builder<Transaction>()
        .add(new Transaction(tradersList.get(3), 2011, 300))
        .add(new Transaction(tradersList.get(0), 2012, 1000))
        .add(new Transaction(tradersList.get(0), 2011, 400))
        .add(new Transaction(tradersList.get(1), 2012, 710))
        .add(new Transaction(tradersList.get(1), 2012, 700))
        .add(new Transaction(tradersList.get(2), 2012, 950))
        .build();
}
