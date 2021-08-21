package explore.juniorAlgorithm.other;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: ValidParentheses
 * Description: 给一组括号组合，判断下是不是合法的东西
 * date: 2020/6/25 15:03
 *
 * @author liyh
 */
public class ValidParentheses {
}
class Solution20 {
    /**
     * 思路就是如果碰到左括号就存下右括号。
     * 如果遇到右括号，就弹出一个看类型一样不一样。如果不一样直接返回false。
     * 最后需要在判断下栈空不空。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '['){
                stack.push(']');
            }
            else if(c == '('){
                stack.push(')');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
