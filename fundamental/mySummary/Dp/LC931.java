package mySummary.Dp;

/**
 * ClassName: LC931
 * Description:
 * date: 2021/8/17 11:13
 *
 * @author liyh
 */
public class LC931 {
}

class Solution931 {
    /**
     * 此题和120基本一致，将起点的从状态定义中去掉，即可得到一个比较好的状态定义方法
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return -1;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; ++i){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    continue;
                }
                if(j == n - 1){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            ans = Math.min(dp[m - 1][i], ans);
        }
        return ans;
    }
}


