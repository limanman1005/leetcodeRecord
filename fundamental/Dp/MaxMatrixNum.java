package Dp;

/**
 * ClassName: MaxMatrixNum
 * Description: 这题和那个边长题基本上是一样的。
 * date: 2020/5/8 15:07
 *
 * @author liyh
 */
public class MaxMatrixNum {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new Solution1277().countSquares(matrix));
    }
}

class Solution1277 {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) {
            return 0;
        }
        int ans = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

    /**
     * 这个dp是我总结了两个解法的写的。逻辑关系更清楚些
     * @param matrix
     * @return
     */
    public int countSquares2(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int rows = matrix.length;
        int colum = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[rows][colum];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < colum; ++j){
                //如果这个位置的矩阵是1进行推断
                if(matrix[i][j] == 1){
                    //这个是边界。在第一行或者第一列矩阵和dp保持一样的值
                    if(i == 0 || j == 0){
                        dp[i][j] = matrix[i][j];
                    }
                    //否则的话使用递推公式
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                //使用一个变量累加上这个值。
                ans += dp[i][j];
            }
        }
        return ans;
    }
}