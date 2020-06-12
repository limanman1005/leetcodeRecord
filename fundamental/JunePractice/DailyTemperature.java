package JunePractice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: DailyTemperature
 * Description: 每日温度，给一个数组，找到数组后面第一个比当前值大的元素之间的下标
 * 有从前向后的暴力解法
 * 有从后向前的暴力解法
 * 还有一个单调栈的解法
 * date: 2020/6/11 10:01
 *
 * @author liyh
 */
public class DailyTemperature {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        solution739.dailyTemperatures3(new int[]{1 ,2, 3});
    }
}
class Solution739 {
    /**
     * 从前向后遍历的暴力解法
     * @param T 给定的数组
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0){
            return new int[0];
        }
        int len = T.length;
        int[] ans = new int[len];
        //对于每一个给定的数字从前向后找到第一个比它大的数字。
        for(int i = 0; i < len; ++i){
            int curTemp = T[i];
            for(int j = i + 1; j < len; ++j){
                if(T[j] > curTemp){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 从后向前遍历。需要额外开辟一个数组，并且维护它
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        //额外开辟一个数组，保存温度对应的高于这个温度的下标
        int[] next = new int[101];
        //首先全部初始化为MAX
        Arrays.fill(next, Integer.MAX_VALUE);
        //从后向前遍历，每次都找高于这个温度的下标值（这个下标值维护在next数组里面）
        for(int i = len - 1; i >= 0; --i){
            int warmerIndex = Integer.MAX_VALUE;
            //这个循环找高于这个温度的在next数组里面有没有维护
            for(int t = T[i] + 1; t <= 100; ++t){
                if(next[t] < warmerIndex){
                    warmerIndex = next[t];
                }
            }
            //如果找到了通过计算得到天数
            if(warmerIndex < Integer.MAX_VALUE){
                ans[i] = warmerIndex - i;
            }
            //更新维护这个next数组
            next[T[i]] = i;
        }
        return ans;
    }

    /**
     * 单挑栈解法。
     * 从前向后遍历，遇到还不能判定了就先压栈，等到碰到的时候然后出栈记录下。直到栈空
     * @param T
     * @return
     */
    public int[] dailyTemperatures3(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        //使用一个栈，这个栈里面存的是下标
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < len; ++i){
            int temperature = T[i];
            while(!stack.isEmpty() && temperature > T[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
