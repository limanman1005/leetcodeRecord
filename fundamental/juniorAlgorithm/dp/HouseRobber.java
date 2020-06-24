package juniorAlgorithm.dp;

/**
 * ClassName: HouseRobber
 * Description: 打家劫舍，计算一个数组上不相邻位置上的数字的最大和
 * date: 2020/6/19 18:11
 *
 * @author liyh
 */
public class HouseRobber {
}

class Solution198 {
    /**
     * 典型的动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; ++i){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}