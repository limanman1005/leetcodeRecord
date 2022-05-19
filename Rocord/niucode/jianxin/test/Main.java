package niucode.jianxin.test;

import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/23 19:23
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
        LinkedList<Integer> integers1 = new LinkedList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(4);
        System.out.println(integers1.contains(3));
        System.out.println(integers1.pollFirst());
    }
}
