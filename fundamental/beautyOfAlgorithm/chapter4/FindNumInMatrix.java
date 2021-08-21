package beautyOfAlgorithm.chapter4;

/**
 * ClassName: FindNumInMatrix
 * Description:
 * date: 2020/4/16 22:56
 *
 * @author liyh
 */
public class FindNumInMatrix {

    /**
     * 这个是一个矩阵右边的数字比左边的大，上面的数字比下面的数字都小。整体是一个有序的情况下。找一个数
     *matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * @param matrix 矩阵
     * @param target 查找目标
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean found = false;
        if(rows > 0 && cols > 0){
            int row = 0;
            int col = cols - 1;
            while(row < rows && col >= 0){
                if(matrix[row][col] ==target){
                    found = true;
                    break;
                }
                else if(matrix[row][col] > target){
                    --col;
                }
                else{
                    ++row;
                }
            }
        }
        return found;
    }


    /**
     * 这个是上个解法的递归解法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchInMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        if(matrix[0].length == 0){
            return false;
        }
        return find(matrix, 0, matrix[0].length-1, target);
    }

    /**
     *
     * @param matrix
     * @param row
     * @param col
     * @param target
     * @return
     */
    public boolean find(int[][] matrix, int row, int col, int target){
        if(row > matrix.length - 1 || col < 0){
            return false;
        }
        if(matrix[row][col] == target){
            return true;
        }
        if(target < matrix[row][col]){
            return find(matrix, row, col - 1, target);
        }
        else {
            return find(matrix, row + 1, col, target);
        }
    }

}
