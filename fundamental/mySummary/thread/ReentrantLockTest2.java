package mySummary.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentrantLockTest2
 * Description:
 * date: 2021/10/10 1:06
 *
 * @author liyh
 */
public class ReentrantLockTest2 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        new Thread(() ->{
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionB.signal();
                    //这里使用await，太坑了，找bug1小时。
                    conditionA.await();
                }
//                conditionB.signal();
            }catch (InterruptedException e){
                System.out.println(e);
            }
            finally {
                reentrantLock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionA.signal();
                    conditionB.await();
                }
//                conditionA.signal();
            }catch (InterruptedException e){
                System.out.println(e);
            }
            finally {
                reentrantLock.unlock();
            }
        }, "B").start();
    }
}
