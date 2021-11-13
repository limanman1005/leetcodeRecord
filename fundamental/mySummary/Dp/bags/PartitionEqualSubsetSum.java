package mySummary.Dp.bags;

/**
 * ClassName: LC416
 * Description: 此题为494的基础题，这个题也可以转化为一个01背包问题。
 * date: 2021/8/6 23:00
 *
 * @author liyh
 */
public class PartitionEqualSubsetSum {
}
class Solution416 {
    /**
     * dp方法将一个数组中找两个相等的子集，转化为一个求一个子集和为数组和的一半的问题。
     * 利用01背包的思路即可解答。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //如果和不为偶数，那么不可能存在两个子集相等。
        if(sum % 2 != 0){
            return false;
        }
        //子集的一半
        int goalSum = sum / 2;
        boolean[][] dp = new boolean[len + 1][goalSum + 1];
        //初始化条件不要错，这里本质上利用了哨兵的思想，简化了对边界问题的探讨。
        //0代表不考虑其他任何物品，当基本条件不好考虑的时候可以使用这个技巧。
        dp[0][0] = true;
        //通过状态转移方程进行转换即可
        for(int i = 1; i <= len; ++i){
            for(int j = 1; j <= goalSum; ++j){
                int curNum = nums[i - 1];
                if(curNum <= j){
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - curNum]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][goalSum];
    }


    /**
     * 使用了01背包压缩空间的解法
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int goalSum = sum / 2;
        int[] dp = new int[goalSum + 1];
        for(int i = 0; i < len; ++i){
            //此处边界条件应记得
            for(int j = goalSum; j >= nums[i]; --j){
                dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
            }
        }
        return dp[goalSum] == goalSum;
    }
}
