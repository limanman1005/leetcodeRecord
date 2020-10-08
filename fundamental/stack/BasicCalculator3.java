package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: BasicCalculator3
 * Description: 简单计算器的第三题
 * date: 2020/10/9 0:26
 *
 * @author liyh
 */
public class BasicCalculator3 {
    public static void main(String[] args) {
        Solution772 solution772 = new Solution772();
        solution772.calculate("-1 * 2");
    }
}
class Solution772 {
    private static HashMap<String,Integer> opMap = new HashMap<>();
    static {
        opMap.put("+",1);
        opMap.put("-",1);
        opMap.put("*",2);
        opMap.put("/",2);
        opMap.put("(",0);
        opMap.put(")",0);
    }
    public int calculate(String s) {
        if (s.length()<=1){
            return Long.valueOf(s).intValue();
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        //处理负数
        for(int i = 0;i<stringBuffer.length();i++) {
            if(( stringBuffer.charAt(i) == '-' || stringBuffer.charAt(i) == '+' ) && (i==0 || stringBuffer.charAt(i-1) == '(')){
                stringBuffer.insert(i, "0");
                i--;
            }
        }

        List<String> reversePolish = reversePolish(stringBuffer.toString());
        Stack<Long> stack = new Stack<>();
        for (int i = 0;i<reversePolish.size();i++){
            String n = reversePolish.get(i);
            if (opMap.containsKey(n)){
                if ("+".equals(n)){
                    stack.push(stack.pop()+stack.pop());
                }else if ("-".equals(n)){
                    long b = stack.pop();
                    long a = stack.pop();
                    stack.push(a-b);
                }else if ("*".equals(n)){
                    long b = stack.pop();
                    long a = stack.pop();
                    stack.push(a*b);
                }else if ("/".equals(n)){
                    long b = stack.pop();
                    long a = stack.pop();
                    stack.push(a/b);
                }
            }else {
                stack.push(Long.valueOf(n));
            }

        }

        return stack.pop().intValue();
    }

    private List<String> reversePolish(String s) {
        Stack<Character> opStack = new Stack<>();
        List<String> str = new LinkedList<>();
        boolean bigger = false;
        for (int i = 0; i< s.length();i++){
            Character c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (!opMap.containsKey(String.valueOf(c))){
                if (!bigger) {
                    str.add(String.valueOf(c));
                    bigger = true;
                }else {
                    str.set(str.size()-1,str.get(str.size()-1)+String.valueOf(c));
                }
            }else {
                bigger = false;
                if (c == '('){
                    opStack.push(c);
                }else if(c==')'){
                    Character o = opStack.pop();
                    while (o != '('){
                        str.add(String.valueOf(o));
                        o = opStack.pop();
                    }
                }else{
                    if (opStack.isEmpty()){
                        opStack.push(c);
                        continue;
                    }
                    Character o = opStack.peek();
                    while (opMap.get(String.valueOf(o))>=opMap.get(String.valueOf(c))){
                        str.add(String.valueOf(opStack.pop()));
                        if (opStack.isEmpty()){
                            break;
                        }
                        o = opStack.peek();
                    }
                    opStack.push(c);
                }
            }
        }
        while (!opStack.isEmpty()){
            str.add(String.valueOf(opStack.pop()));
        }
        return str;
    }
}

