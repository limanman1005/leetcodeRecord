package mySummary.array;

/**
 * ClassName: ContainerWithMostWater
 * Description:
 * date: 19/5/2022 下午3:43
 *
 * @author liyh
 */
public class ContainerWithMostWater {
}
class Solution11{

    /**
     * 可以确定是从两边到中间进行遍历肯定不会错过最优解的。然后根据当前算的高度挪下标就好了
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right){
            int curHeight = Math.min(height[left], height[right]);
            int width = right - left;
            ans = Math.max(ans, width * curHeight);
            if(curHeight == height[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }

}
