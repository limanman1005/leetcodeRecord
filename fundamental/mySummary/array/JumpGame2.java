package mySummary.array;

import java.util.Arrays;

/**
 * ClassName: JumpGame2
 * Description:
 * date: 22/6/2022 上午1:30
 *
 * @author liyh
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int test = (1 << 31) - 3;
        System.out.println("test = " + test);
    }
}
class Solution45{
    /**
     * 使用最长上升子序列的思路还是蛮好解的。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; ++i){
            dp[i] = 100000;
            for(int j = 0; j < i; ++j){
                if(i - j <= nums[j]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }



    private int[] memo;

    /**
     * 使用记忆化递归的思路求解,这个是向前跳的思路。
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int len = nums.length;
        memo = new int[len];
        Arrays.fill(memo, -1);
        return helper(nums, len - 1);
    }

    private int helper(int[] nums, int idx){
        if(idx <= 0){
            return 0;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }
        int ans = 100000;
        //计算一下
        for(int i = 0; i < idx; ++i){
            if(nums[i] >= idx - i){
                ans = Math.min(ans, 1 + helper(nums, i));
            }
        }
        memo[idx] = ans;
        return ans;
    }
}
