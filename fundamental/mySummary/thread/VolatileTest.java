package mySummary.thread;

/**
 * ClassName: VolatileTest
 * Description:
 * date: 2021/10/10 1:01
 *
 * @author liyh
 */
public class VolatileTest {

    private static volatile int signal = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(100);
        new Thread(new ThreadB()).start();
    }

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            while (signal < 100){
                if(signal % 2 == 0){
                    System.out.println("ThreadA:  " + signal);
                    synchronized (this){
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            while(signal < 100){
                if(signal % 2 == 1){
                    System.out.println("ThreadB:  " + signal);
                    synchronized (this){
                        signal++;
                    }
                }
            }
        }
    }
}
