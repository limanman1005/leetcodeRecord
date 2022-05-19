package niucode.shopee.one;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: TestPriorityQueue
 * Description:
 * date: 2021/10/30 1:09
 *
 * @author liyh
 */
public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) ->{
            return o2 - o1;
        });

        integers.add(6);
        integers.add(3);
        integers.add(9);
        integers.add(1);
        while(!integers.isEmpty()){
            Integer poll = integers.poll();
            System.out.println(poll);
        }
    }
}
