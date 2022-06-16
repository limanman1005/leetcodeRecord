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
        int[] ans = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new Solution42().trap3(ans);

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

    /**
     * 这种解法比较的省心
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            int curRain = Math.min(left_max[i], right_max[i]) - height[i];
            System.out.println("curRain = " + curRain);
            ans += curRain;
        }
        return ans;
    }


    /**
     * 这个思路就是当我们使用两个指针同时计算的时候
     * 我们不需要同时知道左右的最大值。我们从左向右计算的时候左边的最大值是可信的，再加上如果此时他比右边的某个值小
     * 那么我们可以确信的是当前位置可以计算的值取决于左边的最大值。
     *
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        //两个指针直接计算1到len - 2的位置就可以了
        int left = 1;
        int right = height.length - 2;
        //记录当下的左边最大值和右边的最大值
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        //一个循环计算出所有的值
        while(left <= right){
            if(height[left - 1] < height[right + 1]){
                leftMax = Math.max(height[left - 1], leftMax);
                ans += (leftMax > height[left]? leftMax - height[left]: 0);
                left++;
            }
            else{
                rightMax = Math.max(height[right + 1], rightMax);
                ans += (rightMax > height[right]? rightMax - height[right]: 0);
                right--;
            }
        }
        return ans;
    }
}
