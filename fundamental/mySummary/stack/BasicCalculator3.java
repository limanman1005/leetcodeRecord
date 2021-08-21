package mySummary.stack;

import java.util.*;

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
        String expression = "1 * 2 + 1 * (3 - 2) / 1";
        int a = solution772.calculate(expression);
        System.out.println(a);
//        new ConcurrentHashMap<>()
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
            if((stringBuffer.charAt(i) == '-' || stringBuffer.charAt(i) == '+' ) && (i==0 || stringBuffer.charAt(i-1) == '(')){
                stringBuffer.insert(i, "0");
                //这个去掉也没有关系
//                i--;
            }
        }

        List<String> reversePolish = reversePolish2(stringBuffer.toString());
        List<String> strings = reversePolish2(stringBuffer.toString());
        System.out.println(strings);
        System.out.println(reversePolish);
        LinkedList<Long> stack = new LinkedList<>();
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

//    private List<String> reversePolish(String s) {
//        Stack<Character> opStack = new Stack<>();
//        List<String> str = new LinkedList<>();
//        boolean bigger = false;
//        for (int i = 0; i< s.length();i++){
//            Character c = s.charAt(i);
//            if (c == ' '){
//                continue;
//            }
//            if (!opMap.containsKey(String.valueOf(c))){
//                if (!bigger) {
//                    str.add(String.valueOf(c));
//                    bigger = true;
//                }else {
//                    str.set(str.size()-1,str.get(str.size()-1)+ c);
//                }
//            }else {
//                bigger = false;
//                if (c == '('){
//                    opStack.push(c);
//                }else if(c==')'){
//                    Character o = opStack.pop();
//                    while (o != '('){
//                        str.add(String.valueOf(o));
//                        o = opStack.pop();
//                    }
//                }else{
//                    if (opStack.isEmpty()){
//                        opStack.push(c);
//                        continue;
//                    }
//                    Character o = opStack.peek();
//                    while (opMap.get(String.valueOf(o))>=opMap.get(String.valueOf(c))){
//                        str.add(String.valueOf(opStack.pop()));
//                        if (opStack.isEmpty()){
//                            break;
//                        }
//                        o = opStack.peek();
//                    }
//                    opStack.push(c);
//                }
//            }
//        }
//        while (!opStack.isEmpty()){
//            str.add(String.valueOf(opStack.pop()));
//        }
//        return str;
//    }

    /**
     * 自己仿着上面写的，终于没有问题了。
     * @param expresion
     * @return
     */
    public List<String> reversePolish2(String expresion){
        //操作栈
        LinkedList<Character> opStack = new LinkedList<>();
        //答案数组
        ArrayList<String> reversePolish = new ArrayList<>();
        //转成charArray便于操作
        char[] expressChars = expresion.toCharArray();
        for(int i = 0; i < expressChars.length; ++i){
            //跳过空格
            if(expressChars[i] == ' '){
                continue;
            }
            //处理数字
            if(Character.isDigit(expressChars[i])){
                StringBuilder num = new StringBuilder();
                while(i < expresion.length() && Character.isDigit(expressChars[i])){
                    num.append(expressChars[i]);
                    ++i;
                }
                i--;
                reversePolish.add(num.toString());
            }
            else{
                //处理括号的情况
                if(expressChars[i] == '('){
                    opStack.addFirst(expressChars[i]);
                }
                else if(expressChars[i] == ')'){
                    while(opStack.peekFirst() != '('){
                        reversePolish.add(String.valueOf(opStack.pollFirst()));
                    }
                    //处理掉最后一个'('
                    opStack.pollFirst();
                }
                else{
                    //处理时 + , - , * , /时候的情况
                    if(opStack.isEmpty()){
                        opStack.addFirst(expressChars[i]);
                        continue;
                    }
                    Character opInStack = opStack.peekFirst();
                    //根据优先级进行操纵，如果比栈中的优先级小于等于，栈中的元素出栈
                    while(opMap.get(String.valueOf(opInStack)) >= opMap.get(String.valueOf(expressChars[i]))){
                        reversePolish.add(String.valueOf(opStack.pollFirst()));
                        if(opStack.isEmpty()){
                            break;
                        }
                        opInStack = opStack.peekFirst();
                    }
                    opStack.addFirst(expressChars[i]);
                }
            }
        }
        //处理最后的未出栈的情况
        while(!opStack.isEmpty()){
            reversePolish.add(String.valueOf(opStack.pollFirst()));
        }
        return reversePolish;
    }
}
