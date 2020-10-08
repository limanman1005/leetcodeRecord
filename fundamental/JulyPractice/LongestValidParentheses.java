package JulyPractice;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: LongestValidParentheses
 * Description: 给一串只含左右括号的字符串，判断下其中有效的括号对的最大长度是多少。
 * date: 2020/7/4 13:31
 * 暴力法
 * 栈法
 * 动态规划法
 * 双指针发
 * @author liyh
 */
public class LongestValidParentheses {
}
class Solution32 {
    /**
     * 这个栈方法
     * 把左括号的下标放进栈里进行保存，碰到右括号匹配之后进行下计算，当前找到的有效长度。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        //设置一个-1是为了避免栈空的时候无法计算长度的情况
        stack.push(-1);
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                //这里是有可能讲-1替换掉的
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
