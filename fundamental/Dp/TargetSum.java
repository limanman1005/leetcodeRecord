package Dp;

/**
 * ClassName: TargetSum
 * Description:
 * date: 2020/9/25 0:45
 *
 * @author liyh
 */
public class TargetSum {
}

class Solution494 {
    /**
     * 这个是回溯的思路，这个可用DP求解
     */
    //todo 此题还动态规划的解法。暂时放一个放 0925
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
}