package explore.microsoft.arrayAndString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: LargestRectangle
 * Description:
 * date: 2020/7/29 14:30
 *
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
    public int largestRectangleArea(int[] heights) {
        if(heights == null){
            return -1;
        }
        int len = heights.length;
        int[] sentryHeight = new int[len + 2];
        for(int i = 1; i <= len; ++i){
            sentryHeight[i] = heights[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for(int i = 0; i < sentryHeight.length ; ++i){
            while(!stack.isEmpty() && sentryHeight[stack.peek()] > sentryHeight[i]){
                int curIndex = stack.poll();
                ans = Math.max(ans, sentryHeight[curIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return ans;
    }
}
