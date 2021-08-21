package mySummary.Dp;

/**
 * ClassName: LC62
 * Description:
 * date: 2021/8/16 22:35
 *
 * @author liyh
 */
public class LC62 {
}
class Solution62 {
    /**
     * 简单DP，注意边界条件的处理即可
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                //注意边界条件的处理即可
                if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if(j == 0 && i != 0){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if(i != 0 && j != 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
