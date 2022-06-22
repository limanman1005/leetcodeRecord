package mySummary.array;

/**
 * ClassName: JumpGame2
 * Description:
 * date: 22/6/2022 上午1:30
 *
 * @author liyh
 */
public class JumpGame2 {
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
}
