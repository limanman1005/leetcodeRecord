package explore.queueAndStack;

import java.util.LinkedList;

/**
 * ClassName: EvaluateReversePolish
 * Description:
 * date: 2020/8/11 10:25
 *
 * @author liyh
 */
public class EvaluateReversePolish {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = solution150.evalRPN(arr);
        System.out.println(i);
    }
}
class Solution150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        int len = tokens.length;
        LinkedList<Integer> stack = new LinkedList<>();
        //执行后最表达式很简单，碰到数字就进栈，碰到运算符就出栈两个元素进行运算。
        //执行顺序是后面的操作前面的。
        for(String token : tokens){
            if(isDigit(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                int result = exec(val1, val2, token);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    private boolean isDigit(String token){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            return false;
        }
        else{
            return true;
        }

    }
    private int exec(int val1, int val2, String opration){
        int result = 0;
        switch(opration){
            case "+": result = val1 + val2; break;
            case "-": result = val2 - val1; break;
            case "*": result = val1 * val2; break;
            case "/": result = val2 / val1; break;
        }
        return result;
    }
}
