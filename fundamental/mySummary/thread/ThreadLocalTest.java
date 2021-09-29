package mySummary.thread;

import java.util.HashMap;

/**
 * ClassName: ThreadLocal
 * Description:
 * date: 2021/9/28 10:40
 *
 * @author liyh
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> localInt = new ThreadLocal<>();

    public static void main(String[] args) {
    }

    public int setAndGet(Integer newValue){
        localInt.set(newValue);
        return localInt.get();
    }
}
