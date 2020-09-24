package thread;

import sun.applet.AppletResourceLoader;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: PrintFooBarAlternately
 * Description:
 * date: 2020/9/24 9:34
 *
 * @author liyh
 */
public class PrintFooBarAlternately {
    private static volatile int v = 0;
    public static void main(String[] args) throws InterruptedException {
        Foobar foobar = new Foobar(3);
        ReentrantLock lock = new ReentrantLock();
        Condition ac = lock.newCondition();
        Condition bc = lock.newCondition();
        //两个信号量进行控制这个事情。
        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 5; ++i) {
                try {
                    a.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "A " + v);
                v++;
                b.release();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 5; ++i) {
                try {
                    b.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B " + v);
                v++;
                a.release();
            }
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
class Foobar{
    private int n;
    public Foobar(int n){
        this.n = n;
    }
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}