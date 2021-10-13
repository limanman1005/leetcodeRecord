package mySummary.designpattern;

import java.util.Optional;

/**
 * ClassName: SimpleFactory
 * Description:
 * date: 2021/10/13 0:13
 *
 * @author liyh
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("+");
        operation.setNumberA(1);
        operation.setNumberB(2);
        double result = operation.getResult();
        System.out.println(result);
    }
}

class OperationFactory{


    public static Operation createOperation(String operate){
        Operation operation = null;
        switch (operate){
            case "+":{
                operation = new OperationAdd();
                break;
            }
            case "-":{
                operation = new OperationSubject();
                break;
            }
        }
        return operation;
    }


}
abstract class Operation{
    private double numberA = 0;
    private double numberB = 0;

    public abstract double getResult();


    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}

class OperationAdd extends Operation{

    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}

class OperationSubject extends Operation{

    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}
