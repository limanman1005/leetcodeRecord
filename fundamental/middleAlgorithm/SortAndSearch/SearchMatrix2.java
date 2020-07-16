package middleAlgorithm.SortAndSearch;

/**
 * ClassName: SearchMatrix2
 * Description: 在二维矩阵中搜索给定的目标值
 * 矩阵有规律，矩阵从上到下升序，从左到右升序。
 * 例如
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * date: 2020/7/16 18:24
 *
 * @author liyh
 */
public class SearchMatrix2 {
}
class Solution240 {
    /**
     * 这个是其中一种解法。从右上角开始可以找到减小范围
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i  = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] > target){
                j--;
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
