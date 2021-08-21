package dailyPractice.JulyPractice;

/**
 * ClassName: JulyPractice.UniquePath2
 * Description: 给一个二维数组代表着一个地图，0代表可以走，1代表不可以走。
 * 给出走到右下角可能的走法。典型的动态规划。
 * dp[i][j]只取决于dp[i - 1][j]和dp[i][j - 1]
 * date: 2020/7/6 10:24
 *
 * @author liyh
 */
public class UniquePath2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int i = new Solution63().uniquePathsWithObstacles2(arr);
        System.out.println(i);

    }
}
class Solution63 {
    /**
     * 动态规划，滚动数组版
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        //这里起点肯定应该是1。（加这个判断有点多余）
        //其实也不多余，如果起点是障碍，那么所有的都将为0
        dp[0] = (obstacleGrid[0][0] == 0? 1: 0);
        //填充数组。
        for(int i =0; i < obstacleGrid.length; ++i){
            for(int j = 0; j < dp.length; ++j){
                //如果这个位置不能走（值为1）
                if(obstacleGrid[i][j] == 1){
                    //那么当前的位置上为0
                    dp[j] = 0;
                    continue;
                }
                //否则加上上一个
                if(j - 1 >= 0 && obstacleGrid[i][j - 1] == 0){
                    //本身存的是上一个值
                    dp[j] += dp[j -1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 二维数组法
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        //边界条件也可以调整到双层循环里
        for(int i = 1; i < m; ++i){
            dp[i][0] = ((obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1)? 1 : 0);
        }
        for(int i = 1; i < n; ++i){
            dp[0][i] = ((obstacleGrid[0][i] ==0 && dp[0][i - 1] == 1)? 1 : 0);
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 二维数组，在双层循环里面，通过条件终结计算值。
     * 并且破环原数组之后理论上空间复杂度O(1)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        for(int i=0;i<n;i++){
            for(int  j=0;j<m;j++){
                if(i==0&&j==0){
                    obstacleGrid[i][j]=(obstacleGrid[i][j]==0?1:0);
                }
                else if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else{
                    obstacleGrid[i][j]=(i>0?obstacleGrid[i-1][j]:0)+(j>0?obstacleGrid[i][j-1]:0);
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
}
