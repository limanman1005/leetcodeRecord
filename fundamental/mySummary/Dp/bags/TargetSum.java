package mySummary.Dp.bags;

import java.sql.PseudoColumnUsage;

/**
 * ClassName: TargetSum
 * Description: 此题可以转化为求一个数组中的子集和等于某个数的方案数
 * date: 2020/9/25 0:45
 *
 * @author liyh
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] arr = {1, 1, 1, 1, 1};
        solution494.findTargetSumWays3(arr, 3);
    }
}

class Solution494 {
    /**
     * 这个是回溯的思路，这个可用DP求解
     */
    private int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        dfs(nums, 0, 0, S);
        return ans;
    }
    private void dfs(int[] nums, int depth, int curSum, int target){
        if(depth == nums.length){
            if(curSum == target){
                ans++;
            }
            return ;
        }
        curSum += nums[depth];
        dfs(nums, depth + 1, curSum, target);
        curSum = curSum - 2 * nums[depth];
        dfs(nums, depth + 1, curSum, target);
    }


    /**
     * dp方法求解。其中一个思路这里需要使用一个公式将问题转化称为01背包的问题
     * 在本题中就是转化成为了在数组选取一个子集其和为goalSum的01背包问题
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum  = 0;
        for(int num : nums){
            sum += num;
        }
        //根据求和公式，goalSum必须是一个非负偶数，如果不满足条件则说明不存在
        if(sum - target < 0 || (sum -target) % 2 != 0){
            return 0;
        }
        //这里算的是-号的总大小
        int goalSum = (sum -target) / 2;
        int len = nums.length;
        //dp[i][j]代表前i个数相加和成为j的个数。
        //故状态转移方程为dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]，这里nums[i]是做了数组下标转换的。逻辑上应为k = i - 1
        int[][] dp = new int[len + 1][goalSum + 1];
        //这里是初始化边界条件，dp[0][j]，所有的第一行数据
        dp[0][0] = 1;
        for(int i = 1; i <= len; ++i){
            for(int j = 0; j <= goalSum; ++j){
                //这里是数组下标之间的关系转换
                int curNum = nums[i - 1];
                if(j >= curNum){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - curNum];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][goalSum];
    }


    /**
     * 一维数组版，这里的容量和上面的解法不同。求一个PSum。
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays3(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum  = 0;
        for(int num : nums){
            sum += num;
        }
        //这里防止PSum为负数，直接返回
        if((sum + target) % 2 != 0 || sum + target < 0){
            return 0;
        }
        int PSum = (sum + target)/2;
        int[] dp = new int[PSum + 1];
        //求组合数时记得初始化
        dp[0] = 1;
        for(int i = 0; i < nums.length; ++i){
            for(int j = PSum; j >= nums[i]; --j){
                //状态转移为加法
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[PSum];
    }

}
