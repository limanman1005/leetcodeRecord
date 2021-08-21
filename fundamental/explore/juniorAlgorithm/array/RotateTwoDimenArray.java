package explore.juniorAlgorithm.array;

/**
 * ClassName: RotateTwoDimenArray
 * Description: 就是旋转二维矩阵 特定的 N*N的矩阵
 * 一般三种方法，一种是转置加反转可以得到任意角度的。
 * 另一种就是找到数组下标反转后的规律问题。
 * 还有一种按层旋转的理解
 * date: 2020/6/11 17:06
 *
 * @author liyh
 */
public class RotateTwoDimenArray {
}

class Solution48 {
    /**
     * 这个是两次反转法
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1){
            return ;
        }
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            //注意第二层循环的细节
            for(int j = i; j < n; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < n; ++i){
            //注意第二层循环的细节
            for(int j = 0; j < n/2; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n -1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
        return ;
    }

    /**
     * 下标的关系不好找啊。
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; ++i){
            for(int j = i; j < n - i - 1; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    /**
     * 这个特殊的有点秀
     * @param matrix
     */
    public void rotate3(int[][] matrix) {
        int tmp = -1;
        for(int start = 0, end = matrix[0].length - 1; start < end; start++, end--){
            for(int s = start, e = end; s < end; s++, e--){
                tmp = matrix[start][s];
                matrix[start][s] = matrix[e][start];
                matrix[e][start] = matrix[end][e];
                matrix[end][e] = matrix[s][end];
                matrix[s][end] = tmp;
            }
        }
    }
}




