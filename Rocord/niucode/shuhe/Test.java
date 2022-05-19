package niucode.shuhe;

/**
 * ClassName: Test
 * Description:
 * date: 2021/10/26 20:42
 *
 * @author liyh
 */
public class Test {

    public static void main(String[] args) {
        Son son = new Son();

    }

    public String returnTest(){
        try {
            return "1";
        }
        finally {
            return "2";
        }
    }
}

class FatherTest{
    protected static int num = 0;

    static {
        System.out.println("Father 静态代码块");
    }

    {
        System.out.println("Father 代码块");
    }

    public FatherTest(){
        System.out.println("F构造函数");
    }
}

class Son extends FatherTest{

    static {
        System.out.println("son静态代码块");
    }

    {
        System.out.println("son代码块");
    }

    public Son(){
        super();
        System.out.println("Son构造函数");
    }
}
