package Dp;


import java.util.Arrays;

/**
 * ClassName: LIS
 * Description:
 * date: 2020/9/20 18:26
 *
 * @author liyh
 */
public class LIS {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] ints = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int i = solution300.lengthOfLIS(ints);
        System.out.println(i);
    }
}

class Solution300 {
    private Integer[] memo;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        memo = new Integer[len];
        for(int i = len - 1; i >=0; --i){
            helper(nums, i);
        }
        int ans = 1;
        for(int i = 0; i < len; ++i){
            if(memo[i] != null){
                ans = Math.max(ans, memo[i]);
            }
        }
        return ans;
    }
    private int helper(int[] nums, int cur){
        if(cur == 0){
            memo[0] = 1;
            return 1;
        }
        if(memo[cur] != null){
            return memo[cur];
        }
        int curAns = 1;
        for(int i = cur - 1; i >=0; --i){
            if(nums[i] < nums[cur]){
                int tmp = helper(nums, i);
                curAns = Math.max(curAns, tmp + 1);
            }
        }
        memo[cur] = curAns;
        return curAns;
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < nums.length; ++i){
            for(int j = i - 1; j >=0; --j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

