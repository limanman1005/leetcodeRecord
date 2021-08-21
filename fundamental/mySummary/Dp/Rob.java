package mySummary.Dp;

/**
 * ClassName: Rob
 * Description: 这个真的是简单dp了。
 * 关键是如何分析出为什么有最优子结构，等等什么的。
 * 小状态，如何转换。一道题说明不了什么，等下在总结。
 * date: 2020/5/29 11:39
 *
 * @author liyh
 */
public class Rob {
}
class Solution198 {
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
