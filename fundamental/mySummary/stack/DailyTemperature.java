package mySummary.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: DailyTemperature
 * Description: 使用单调栈的一题
 * date: 2020/7/29 16:11
 * 纯应用单调栈，适合入门
 * @author liyh
 */
public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
    }
}
class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < len; ++i){
            int temp = T[i];
            //找下一个更大的元素，需要维护一个最小栈
            while(!stack.isEmpty() && temp > T[stack.peek()]){
                //出栈计算
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
