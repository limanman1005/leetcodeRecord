package MayPratise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: LargestRectangle
 * Description: 给一系列矩形找到这些矩形围成的最大面积
 * date: 2020/6/2 18:26
 * 此题使用单调栈。
 * 这题的暴力解法，也可做一做。
 * @author liyh
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] arr = {2, 1, 2};
        System.out.println(solution84.largestRectangleArea(arr));
    }
}
class Solution84 {
    /**
     * 单调栈，单调栈的特性决定了它可以存上左边边界的信息
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int test = 0;
        //栈里存的下标信息（！！！注意）
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> testStack = new ArrayDeque<>();
        //这个是前后加两个哨兵，无需特判
        int[] myheight = new int[heights.length + 2];
        //copy数组
        for(int i = 1; i < heights.length + 1; ++i){
            myheight[i] = heights[i - 1];
        }
        for(int i = 0; i < myheight.length; ++i){
            //对于栈不空并且栈顶部大于当前矩阵的高，那么出栈。
            //这个条件意味着找到了右边的一个边界，把栈中所有小于此边界的矩阵都可以求出最大面积了
            while(!stack.isEmpty() && myheight[stack.peek()] > myheight[i]){
                int cur = stack.pop();
                int show = testStack.pop();
                //这里计算面积
                ans = Math.max(ans, (i - stack.peek() - 1) * myheight[cur]);
                //最终还是搞明白了，使用了cur就相当于截到这里了，应该要找到后面的
//                test = Math.max(test, (i - cur) * myheight[cur]);
            }
            stack.push(i);
            testStack.push(myheight[i]);
        }
        return ans;
    }
}