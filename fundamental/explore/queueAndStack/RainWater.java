package explore.queueAndStack;

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
        int[] ans = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new Solution42().trap2(ans);
    }
}
class Solution42{

    /**
     * 动规解法。
     * 记录下左右柱子的最大值然后计算
     * 甜姨还有一个双指针法，暂时放在后面记录吧
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        for(int i = 1; i < len; ++i){
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }
        for(int i = len - 2; i >= 0; --i){
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }
        int ans = 0;
        for(int i = 1; i < len - 1; ++i){
            ans += (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return ans;
    }


    public int trap2(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < height.length; ++i){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int calIndex = stack.pop();
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