package mySummary.thread.geek;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: OrderPrint
 * Description:
 * date: 11/5/2022 上午10:25
 *
 * @author liyh
 */
public class OrderPrint {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        new Thread(() ->{
            try {
                semaphoreA.acquire();
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreB.release();
        }).start();
        new Thread(() ->{
            try {
                semaphoreB.acquire();
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreA.release();
        }).start();
    }
}
