package dailyPractice.MayPratise;

import java.lang.reflect.Array;
import java.util.*;

/**
 * ClassName: LargestRectangle
 * Description: 给一系列矩形找到这些矩形围成的最大面积
 * date: 2020/6/2 18:26
 * 此题使用单调栈。
 * @author liyh
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] arr = {2,1,5,6,2,3};
        int ans = solution84.largestRectangleArea2(arr);
        System.out.println(ans);
    }
}
class Solution84 {


    public int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        //此题使用了哨兵技巧，避免了边界出栈的讨论,所以while循环里面不能添加等号
        int[] sentinel = new int[len + 2];
        for(int i = 1; i < len + 1; ++i){
            sentinel[i] = heights[i - 1];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < len + 2; ++i){
            //栈不空且当前要加入的元素比栈顶要小
            //意味着找到了比栈顶元素要小的最右边的元素了
            //所以出栈计算可以组成的最大矩形（栈里面存有当前计算高度的左边第一个比它小的数的下，加上右边第一个比它小的下标可以得到宽度）
            //使用了哨兵技巧，比较的时候不能加等号
            while(!stack.isEmpty() && sentinel[i] < sentinel[stack.peekLast()]){
                int calIndex = stack.pollLast();
                int height = sentinel[calIndex];
                //宽度就是当前要加入的下标
                int width = i - stack.peekLast() - 1;
                ans = Math.max(ans, height * width);
            }
            stack.addLast(i);
        }
        return ans;
    }
}
