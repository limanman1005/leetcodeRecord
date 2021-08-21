package dailyPractice.JulyPractice;

/**
 * ClassName: MinimumPathSum
 * Description: 给一个二维的数组，求出从左上角到右下角的经过的路径最小和
 * date: 2020/7/23 10:21
 *
 * @author liyh
 */
public class MinimumPathSum {
    //todo 此题还有找出路径的进阶版，有时间学习一下
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] path = new int[m + n][2];
        path[m + n - 1] = new int[]{m - 1, n- 1};
    }
}
class Solution64 {
    /**
     * 记忆化递归的解法，从大的向小的推，然后处理一下边界条件即可
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int[][] memo = new int[m + 1][n + 1];
        return helper(m, n, grid, memo);
    }

    /**
     * 每一个helper都返回的是到达当前位置的最小的路径和。
     * @param m
     * @param n
     * @param grid
     * @param memo
     * @return
     */
    private int helper(int m, int n, int[][] grid, int[][] memo){
        //边界条件
        if(m == 0 && n == 0){
            return grid[0][0];
        }
        //边界条件
        if(m == 0){
            memo[m][n]  = grid[m][n] + helper(m, n - 1, grid, memo);
            return memo[m][n];
        }
        //边界条件
        if(n == 0){
            memo[m][n] = grid[m][n] + helper(m - 1, n, grid, memo);
            return memo[m][n];
        }
        //利用记忆化的结果
        if(memo[m][n] != 0){
            return memo[m][n];
        }
        //当前状态是如何转换到下一个状态的
        //向左或者向下进行转移选择最小的和当前的值加上去即可
        memo[m][n] = grid[m][n] + Math.min(helper(m - 1, n, grid, memo), helper(m, n - 1, grid, memo));
        return memo[m][n];
    }


    /**
     * 补一个动态规划
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //边界条件要单独挑出来
        for(int i = 1; i < n; ++i){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //边界条件要单独挑出来
        for(int i = 1; i < m; ++i){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
