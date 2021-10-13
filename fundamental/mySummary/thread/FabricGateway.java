package mySummary.thread;

/**
 * ClassName: FabricGateway
 * Description:
 * date: 2021/10/11 11:16
 *
 * @author liyh
 */
public class FabricGateway implements Runnable{

    private int a = 1;


    public void dowork(){
        System.out.println("do work");
    }

    @Override
    public void run() {
        System.out.println("do work");
        System.out.println(a);
    }
}
