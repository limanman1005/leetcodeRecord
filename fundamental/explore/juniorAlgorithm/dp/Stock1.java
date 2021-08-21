package explore.juniorAlgorithm.dp;

import java.util.TreeMap;
import java.util.concurrent.CyclicBarrier;

/**
 * ClassName: Stock1
 * Description:  此题同array包里面的
 * date: 2020/6/19 17:48
 *
 * @author liyh
 */
public class Stock1 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
        integerIntegerTreeMap.put(2, 2);
        integerIntegerTreeMap.put(3, 3);
        integerIntegerTreeMap.put(4, 4);
        integerIntegerTreeMap.put(5, 5);
        integerIntegerTreeMap.put(6, 6);
        integerIntegerTreeMap.put(1, 2);
        integerIntegerTreeMap.forEach((k, v) -> System.out.println(k));
//        new CyclicBarrier()
    }
}
