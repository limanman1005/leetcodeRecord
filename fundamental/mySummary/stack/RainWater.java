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
     * 这个解法不知道哪里有问题
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int left = 0;
        int right = len - 1;
        int sum = 0;
        for(int i = 1; i < len - 1; ++i){
            if(leftMax <= rightMax){
                if(leftMax > height[left]){
                    //需要计算的是left和right而不是i下标
                    int curRain = leftMax - height[left];
//                    System.out.println("i " + i);
                    System.out.println(curRain);
                    sum += leftMax - height[left];
                }
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }
            else{
                if(rightMax > height[right]){
//                    System.out.println("i = " + i);
                    int curRain = rightMax - height[right];
                    System.out.println(curRain);
                    sum += rightMax - height[right];
                }
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return sum;
    }



}
