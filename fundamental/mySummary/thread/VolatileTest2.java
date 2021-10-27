package mySummary.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: VolatileTest2
 * Description:
 * date: 2021/10/21 16:04
 *
 * @author liyh
 */
public class VolatileTest2 {

    private static volatile int signal = 0;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() ->{
            while(signal < 10){
                if(signal % 2 == 0){
                    System.out.println(signal);
                    try {
                        reentrantLock.lock();
                        signal++;
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }).start();

        new Thread(() ->{
            while (signal < 10){
                if(signal % 2 == 1){
                    System.out.println(signal);
                    try {
                        reentrantLock.lock();
                        signal++;
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }).start();

    }


}
