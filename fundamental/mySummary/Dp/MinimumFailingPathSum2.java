package mySummary.Dp;

/**
 * ClassName: LC1689
 * Description:
 * date: 2021/8/17 15:22
 *
 * @author liyh
 */
public class MinimumFailingPathSum2 {
}
class Solution1289 {
    private int MAX = Integer.MAX_VALUE;

    /**
     * 根据前面的经验，这里这个状态定义也比较的容易
     * @param grid
     * @return
     */
    public int minFallingPathSum(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; ++i){
            dp[0][i] = grid[0][i];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                //对于多个求最小值的这里是初始化值
                dp[i][j] = Integer.MAX_VALUE;
                //这里遍历上一行的除了同列的数值得到最小值
                for(int k = 0; k < n; ++k){
                    if(k != j){
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                    }
                }
            }
        }
        //找出最小的值
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }

    /**
     * 此题还可以使用两个变量保存最小值和次小值的做法，可以优化时间复杂度。
     * @param grid
     * @return
     */
    public int minFallingPathSum2(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int i1 = -1, i2 = -1;
        //这种边遍历边找出最小值和次小值的写法要多练练才能记得住。
        for(int i = 0; i < n; ++i){
            dp[0][i] = grid[0][i];
            if(dp[0][i] < (i1 == -1 ? MAX: dp[0][i1])){
                i2 = i1;
                i1 = i;
            }else if(dp[0][i] < (i2 == -1? MAX: dp[0][i2])){
                i2 = i;
            }
        }
        for(int i = 1; i < m; ++i){
            //本行的最小值和次小值
            int tmpi1 = -1, tmpi2 = -1;
            for(int j = 0; j < n; ++j){
                //利用上一行的最小值和次小值计算dp
                dp[i][j] = Integer.MAX_VALUE;
                if(j != i1){
                    dp[i][j] = dp[i - 1][i1] + grid[i][j];
                }
                else{
                    dp[i][j] = dp[i - 1][i2] + grid[i][j];
                }
                //边遍历和边计算本行的最小值和次小值
                if(dp[i][j] < (tmpi1 == -1? MAX : dp[i][tmpi1])){
                    tmpi2 = tmpi1;
                    tmpi1 = j;
                }else if(dp[i][j] < (tmpi2 == -1? MAX : dp[i][tmpi2])){
                    tmpi2 = j;
                }
            }
            //更新为本行最小值和次小值的下标
            i1 = tmpi1;
            i2 = tmpi2;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}
