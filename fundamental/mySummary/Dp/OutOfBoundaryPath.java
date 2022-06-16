package mySummary.Dp;

/**
 * ClassName: LC576
 * Description:
 * date: 2021/8/19 0:15
 *
 * @author liyh
 */
public class OutOfBoundaryPath {
    public static void main(String[] args) {
        Solution576 solution576 = new Solution576();

        int paths = solution576.findPaths(1, 3, 3, 0, 1);
        System.out.println("paths = " + paths);
    }
}
class Solution576 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int MOD = 1000000007;
    private int[][][] memo;

    /**
     * 这个状态定义我是没想到的，每次都移动，直到出界了才返回一次。
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                for(int k = 1; k <= maxMove; ++k){
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int maxMove, int startRow, int startColumn){
        if(outOfArea(startRow, startColumn, m, n)){
            return 1;
        }
        if(maxMove == 0){
            return 0;
        }
        if(memo[startRow][startColumn][maxMove] != -1){
            return memo[startRow][startColumn][maxMove];
        }
        if(startRow - maxMove >= 0 && startRow + maxMove < m && startColumn- maxMove >= 0 && startColumn + maxMove < n){
            return 0;
        }
        int sum = 0;
        for(int[] dir : dirs){
            sum = (sum + dfs(m, n, maxMove - 1, startRow + dir[0], startColumn + dir[1])) %MOD;
        }
        memo[startRow][startColumn][maxMove] = sum;
        return sum;
    }

    private boolean outOfArea(int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 有一点点奇怪的dp解法
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        //初始化直接在循环里面进行了。
        for(int k = 1; k <= maxMove; ++k){
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(i == 0){
                        dp[i][j][k]++;
                    }
                    if(j == 0){
                        dp[i][j][k]++;
                    }
                    if(i == m - 1){
                        dp[i][j][k]++;
                    }
                    if(j == n - 1){
                        dp[i][j][k]++;
                    }
                    //这里的意思是四个方向试探下，当前的位置是由周围的四个位置k - 1的move次数移动得来的。
                    for(int[] dir: dirs){
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n){
                            dp[i][j][k] = (dp[i][j][k] + dp[nextI][nextJ][k - 1]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
