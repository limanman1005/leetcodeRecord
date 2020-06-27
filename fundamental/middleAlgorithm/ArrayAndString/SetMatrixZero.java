package middleAlgorithm.ArrayAndString;

/**
 * ClassName: SetMatrixZero
 * Description: 给一个矩阵如果这个矩阵的某个元素是0，那么把矩阵的这一行和这一列所有的值都设为0
 * date: 2020/6/27 17:05
 *
 * @author liyh
 */
public class SetMatrixZero {
}
class Solution73 {
    /**
     * 这个原地解法不太靠谱啊，设置了一个不会包括在矩阵里面的数值来做标记。
     * 还有一种就是记录下横纵坐标。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int random = -1000000;
        int R = matrix.length;
        int C = matrix[0].length;
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < C; ++k){
                        if(matrix[i][k] != 0){
                            matrix[i][k] = random;
                        }
                    }
                    for(int k = 0; k < R; ++k){
                        if(matrix[k][j] != 0){
                            matrix[k][j] = random;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                if(matrix[i][j] == random){
                    matrix[i][j] = 0;
                }
            }
        }
        return ;
    }
}