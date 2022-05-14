package offer.no04List;

import java.util.LinkedList;

/**
 * ClassName: Offer039
 * Description:
 * date: 1/5/2022 上午10:52
 *
 * @author liyh
 */
public class Offer039 {

    public static void main(String[] args) {
        Solution039And84 solution039And84 = new Solution039And84();
        int[] arr = {2, 1, 2};
        int maxArea = solution039And84.largestRectangleArea(arr);
        System.out.println("maxArea = " + maxArea);
    }
}

class Solution039And84{
    /**
     * 还有一个分治算法，可以试一下。
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        //必须提前做加个-1，定住最左边的坐标。
        stack.addLast(-1);
        for(int i = 0; i < len; ++i){
            while(stack.peekLast() != -1 && heights[i] < heights[stack.peekLast()]){
                int curHeightIdx = stack.pollLast();
                int width = i - stack.peekLast() - 1;
                ans = Math.max(ans, heights[curHeightIdx] * width);
            }
            stack.addLast(i);
        }
        while(stack.peekLast() != -1){
            int heiIdx = stack.pollLast();
            //因为剩下了说明，右边没有比它更小的了，直接使用len的值即可。
            int width = heights.length - stack.peekLast() - 1;
            ans = Math.max(ans, width * heights[heiIdx]);
        }
        return ans;
    }
}
