package mySummary.stack;

import java.util.LinkedList;

/**
 * ClassName: RainWater
 * Description:
 * date: 2020/8/11 15:40
 *
 * @author liyh
 */
public class RainWater {
    public static void main(String[] args) {
        int[] ans = {2, 1, 0, 1, 2};
        int trap = new Solution42().trap2(ans);

    }
}
class Solution42{

    /**
     * 此解法可过，但是意义不明显，有点难想
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < height.length; ++i){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //只pop了一次，意义着实不明显，有点难以理解
                int calIndex = stack.pop();
                System.out.println("calIndex = " + calIndex);
                if(stack.isEmpty()){
                    break;
                }
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                ans += distance * (min - height[calIndex]);
            }
            stack.push(i);
        }
        return ans;
    }



}
