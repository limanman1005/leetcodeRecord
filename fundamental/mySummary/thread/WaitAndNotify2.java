package mySummary.thread;

/**
 * ClassName: WaitAndNotify2
 * Description:
 * date: 2021/10/21 14:54
 *
 * @author liyh
 */
public class WaitAndNotify2 {

    private static Object lock = new Object();


    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

    }
}
