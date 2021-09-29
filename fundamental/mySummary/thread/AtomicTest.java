package mySummary.thread;

import explore.recursion.ListNode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName: AtomicTest
 * Description:
 * date: 2021/9/28 10:19
 *
 * @author liyh
 */
public class AtomicTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);



    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 1000; ++i){
            executorService.execute(
                    () -> {
                        for(int j = 0; j < 2; ++j){
                            int incrementAndGet = atomicInteger.incrementAndGet();
                            System.out.println("Thread:" + Thread.currentThread().getName() + " count = " + incrementAndGet);
                        }
                    }
            );
        }
        executorService.shutdown();
        Thread.sleep(1000);
        System.out.println("最终结果是：" + atomicInteger.get());
    }
}
