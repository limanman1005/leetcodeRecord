package MayPratise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: LargestRectangle
 * Description: 给一系列矩形找到这些矩形围成的最大面积
 * date: 2020/6/2 18:26
 * 此题使用单调栈。
 * 这题的暴力解法，也可做一做。
 * @author liyh
 */
public class LargestRectangle {
}
class Solution84 {
    /**
     * 单调栈，单调栈的特性决定了它可以存上左边边界的信息
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        //栈里存的下标信息
        Deque<Integer> stack = new ArrayDeque<>();
        int[] myheight = new int[heights.length + 2];
        //这个是前后加两个哨兵，无需特判
        for(int i = 1; i < heights.length + 1; ++i){
            myheight[i] = heights[i - 1];
        }
        for(int i = 0; i < myheight.length; ++i){
            //对于栈不空并且栈顶部大于当前矩阵的高，那么出栈。
            while(!stack.isEmpty() && myheight[stack.peek()] > myheight[i]){
                int cur = stack.pop();
                //我这里的话
                ans = Math.max(ans, (i - stack.peek() - 1) * myheight[cur]);
            }
            stack.push(i);
        }
        return ans;
    }
}
