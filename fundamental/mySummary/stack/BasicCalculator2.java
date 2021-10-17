package mySummary.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ClassName: BasicCalculator2
 * Description:
 * date: 2021/10/2 1:08
 *
 * @author liyh
 */
public class BasicCalculator2 {

    public static void main(String[] args) {
        Solution227 solution227 = new Solution227();

        String expression = " 3+5 / 2 ";
        String s = expression.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        System.out.println(chars.length);
//        int calculate = solution227.calculate(expression);
//        System.out.println(calculate);
    }
}
class Solution227{
    private Map<Character, Integer> map = new HashMap<Character, Integer>(){
        {
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 3);
            put('^', 4);
        }
    };


    public int calculate(String s){
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> opsStack = new LinkedList<>();
        //避免边界讨论，第一个数是负数，会方便很多
        numStack.addLast(0);
        for(int i = 0; i < len; ++i){
            //先讨论左右括号，左括号进栈，右括号出栈计算直到碰到左括号为止
            if(chars[i] == '('){
                opsStack.addLast(chars[i]);
            }
            else if(chars[i] == ')'){
                while(!opsStack.isEmpty()){
                    if(opsStack.peekLast() != '('){
                        calc(numStack, opsStack);
                    }
                    else{
                        opsStack.pollLast();
                        break;
                    }
                }
            }
            //接着讨论数字和计算符的情况
            else{
                //如果是数字，使用while循环将数字取出并进栈
                if(Character.isDigit(chars[i])){
                    int curNum = 0;
                    int j = i;
                    while(j < len && Character.isDigit(chars[j])){
                        curNum = curNum * 10 + chars[j] - '0';
                        j++;
                    }
                    numStack.addLast(curNum);
                    i = j - 1;
                }
                else{
                    //如果是运算符，碰到边界情况那么首先要在数字栈中加零处理
                    if(i > 0 && (chars[i - 1] == '(' || chars[i - 1] == '+' || chars[i - 1] == '-')){
                        numStack.addLast(0);
                    }
                    //然后通过一个循环比较运算符的优先级，如果栈内的优先级大于等于当前的就出栈运算符进行计算
                    while(!opsStack.isEmpty() && opsStack.peekLast() != '('){
                        char pre = opsStack.peekLast();
                        if(map.get(pre) >= map.get(chars[i])){
                            calc(numStack, opsStack);
                        }
                        else{
                            break;
                        }
                    }
                    //最后将运算符压栈
                    opsStack.addLast(chars[i]);
                }
            }
        }
        //最后如果运算符的栈不空，接着运算后面的
        while(!opsStack.isEmpty()){
            calc(numStack, opsStack);
        }
        return numStack.peekLast();
    }

    /**
     * 普普通通的计算函数，需要记住的是va2的顺序在前
     * @param numStack
     * @param opsStack
     */
    private void calc(LinkedList<Integer> numStack, LinkedList<Character> opsStack) {
        if(numStack.isEmpty() || numStack.size() < 2 || opsStack.isEmpty()){
            return ;
        }
        int val1 = numStack.pollLast();
        int val2 = numStack.pollLast();
        char op = opsStack.pollLast();
        int ans = 0;
        if(op == '+'){
            ans = val2 + val1;
        }
        else if(op == '-'){
            ans = val2 - val1;
        }
        else if(op == '*'){
            ans = val2 * val1;
        }
        else if(op == '/'){
            ans = val2 / val1;
        }
        else if(op == '^'){
            ans = (int) Math.pow(val2, val1);
        }
        else if(op == '%'){
            ans = val2 % val1;
        }
        numStack.addLast(ans);
    }
}
