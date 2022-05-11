package mySummary.thread.geek;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentryLockTest
 * Description:
 * date: 10/5/2022 下午10:13
 *
 * @author liyh
 */
public class ReentryLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();
        new Thread(()->{
           try {
               reentrantLock.lock();
               for(int i = 0;  i < 10; ++i){
                   System.out.print("A");
                   conditionB.signal();
                   conditionA.await();
               }
               conditionB.signal();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               reentrantLock.unlock();
           }
        }).start();

        Thread.sleep(100);
        new Thread(() ->{
            try {
                reentrantLock.lock();
                for(int i = 0; i < 10; ++i){
                    System.out.print("B");
                    conditionA.signal();
                    conditionB.await();
                }
//                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

    }
}

