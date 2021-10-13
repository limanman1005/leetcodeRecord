package mySummary.designpattern;

/**
 * ClassName: StrategyPattern
 * Description:
 * date: 2021/10/13 0:41
 *
 * @author liyh
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context("1");
        context.ContextInterface();
    }
}
abstract class Strategy{

    public abstract void algorithmInterface();
}

class StrategyA extends Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("实现了算法A");
    }
}

class StragegyB extends Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("实现了算法B");
    }
}

class Context{

    Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 这个是策略模式和工厂模式的结合，将生成的对象逻辑放到context里面完成。
     * 客户端将不需要在认识factory，耦合更低
     *
     * @param type
     */
    public Context(String type){
        switch (type){
            case "1":{
                this.strategy = new StrategyA();
                break;
            }
            case "2":{
                this.strategy = new StragegyB();
                break;
            }
        }
    }


    public void ContextInterface(){
        strategy.algorithmInterface();
    }

}
