package mySummary.Dp;

/**
 * ClassName: MaxSide
 * Description: 找到一个图形中藏着的最大正方形的面积
 * date: 2020/5/8 10:48
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 * @author liyh
 */
public class MaxSide {
}

class Solution221 {
    /**
     * 暴力解法
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        //判断每一个字符
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j){
                //如果这个字符是1，则一行一列的增加。
                //然后判断增加的这一行一列是不是全为一
                if(matrix[i][j] == '1'){
                    //如果这一行是1了。和1比较下是为了处理只有1的特殊情况。
                    maxSide = Math.max(maxSide, 1);
                    //然后算一下这个正方形在矩阵的约束下最多能扩展到多大。
                    int curMaxSide = Math.min(rows - i, columns - j);
                    //在这个最大可扩展范围内扩展
                    for(int k = 1; k < curMaxSide; k++){
                        //这个是判断对角线
                        if(matrix[i + k][j + k] == '0'){
                            break;
                        }
                        boolean flag = true;
                        //这个是判断行和列。使用一个flag做个标记。以判断在循环中是因为什么条件终止了。
                        for(int m = 0; m < k; m++){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //如果新增的一行一列对角线都是1，则判断下能不能更新下最大值。
                        //否则跳出循环，进行下一个点的选取
                        if(flag){
                            maxSide = Math.max(maxSide, k + 1);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        //找到边长就是面积了
        return maxSide * maxSide;
    }


    /**
     * 动规解法。这里把求最优的问题划分成了以这个位置结尾的正方形的边长大小。想到小的怎么转换。
     * 这个转换的方程还是记住就好了。数学证明不直观，至少暂时这样记住吧
     * 从小规模推到大规模，最后在这个中间找到答案。
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int maxSide = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int[][] dp = new int[rows][colums];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < colums; ++j){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}
