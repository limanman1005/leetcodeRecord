package mySummary.designpattern;

enum Singleton5{
    //单例的用法
    INSTANCE;
    private int attr;

    public void fun(){
        System.out.println("enum实现单例");
        return ;
    }
    //可以加上一个属性或者函数
}

/**
 * 懒汉式
 */
class Singleton1{
    //1.使用一个静态类变量。
    private static Singleton1 instance = null;
    //2.构造函数私有化
    private Singleton1(){
    }
    /**
     * 对外暴露一个接口
     * @return
     */
    public static Singleton1 getInstance(){
        //单重检查是否为null
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉双重检查版
 */
class Singleton2{
    //加了volatile关键字，告诉线程需要在主内存里面取值，不要再本地内存里面进行操作。
    private volatile static Singleton2 instance;

    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        if(instance == null){
            //和1比就是多了这个锁
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉式
 */
class Singleton3{
    private Singleton3(){
    }
    private static Singleton3 instance = new Singleton3();
    public static Singleton3 getInstance(){
        return instance;
    }
}
class Singleton4{
    //内部类在使用的时候才加载，不使用不加载，如此方使用这个进行加载
    private static class SingletonHolder{
        private static Singleton4 instance = new Singleton4();
    }
    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        return SingletonHolder.instance;
    }
}

/**
 * ClassName: SingletonPattern
 * Description:
 * date: 2020/9/22 10:52
 *
 * @author liyh
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton5.INSTANCE.fun();
        System.out.println(Singleton5.INSTANCE == Singleton5.INSTANCE);
    }
}
