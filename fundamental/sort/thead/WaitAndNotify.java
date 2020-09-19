package sort.thead;

/**
 * ClassName: WaitAndNotify
 * Description:
 * date: 2020/9/18 21:22
 *
 * @author liyh
 */
public class WaitAndNotify {

    private static Object lock = new Object();

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 5; ++i){
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
        }
    }
    static class ThreadB implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 5; ++i){
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
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }
}
