package mySummary.thread;

import java.util.concurrent.Semaphore;

/**
 * ClassName: PrintInOrder
 * Description:
 * date: 2021/9/28 0:20
 *
 * @author liyh
 */
public class PrintInOrder {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> System.out.println("first"));
        Thread second = new Thread(() -> System.out.println("second"));
        Thread third = new Thread(() -> System.out.println("thrid"));
        first.start();
    }
}

class Foo{
//    private Semaphore two = new Semaphore(0);
//    private Semaphore three = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        Thread.sleep(2000);
//        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
//        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
//        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
//        three.acquire();
          printThird.run();   //outputs "third". Do not change or remove this line.
//        printThird.run();
    }
}
