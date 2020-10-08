package thread;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentrantLock
 * Description:
 * date: 2020/10/6 17:45
 *
 * @author liyh
 */
public class ReentrantLockTest {
    private java.util.concurrent.locks.ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private volatile int num = 1;

    public void print1(){
        lock.lock();
        try {
            while(num < 10){
                System.out.println(Thread.currentThread() + "" + num);
                num++;
                condition2.signal();
                condition1.await();
            }
        }
        catch (Exception e){

        }
        finally {
            lock.unlock();
        }
    }

    public void print2(){
        lock.lock();
        try {
            while(num < 10){
                System.out.println(Thread.currentThread() + "" + num);
                num++;
                condition2.await();
                condition1.signal();

            }
        }
        catch (Exception e){

        }
        finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        new Thread(() -> reentrantLockTest.print1(), "thread1").start();
        new Thread(() -> reentrantLockTest.print2(), "thread2").start();
    }
}

