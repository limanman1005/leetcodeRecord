package explore.juniorAlgorithm.dp;

import java.util.concurrent.ConcurrentHashMap;

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

    Integer[] memo;

    /**
     * 自己写的一个记忆化递归
     * @param nums 数组
     * @return 答案
     */
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        memo = new Integer[nums.length];
        int ans = dp(nums, nums.length - 1);
        return ans;
    }
    private int dp(int[] nums, int k){
        if(k == 0){
            return nums[0];
        }
        if(k == 1){
            return Math.max(nums[0], nums[1]);
        }
        if(memo[k] != null){
            return memo[k];
        }
        memo[k] = Math.max(dp(nums, k - 1), dp(nums, k - 2) + nums[k]);
        return memo[k];
    }
}
