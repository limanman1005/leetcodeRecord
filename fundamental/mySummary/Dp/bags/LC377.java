package mySummary.Dp.bags;

/**
 * ClassName: LC377
 * Description:组合总和4，数组里面的数随便用，求可以组成target数的排列数
 * date: 2021/9/24 0:32
 *
 * @author liyh
 */
public class LC377 {
}
class Solution377 {
    /**
     * nums里面的数随便用，求可以组成target的所有排列数
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //此题要求排列数，需要先遍历容量再遍历数的大小
        for(int i = 0; i <= target; ++i){
            for(int j = 0; j < len; ++j){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
