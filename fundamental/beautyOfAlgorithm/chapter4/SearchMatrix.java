package beautyOfAlgorithm.chapter4;

/**
 * ClassName: SearchMatrix1
 * Description: 这个题的矩阵不是严格递增的两种解法
 * date: 2020/4/17 21:18
 *
 * @author liyh
 */
public class SearchMatrix {

    /**
     * 这个解法最简单。选一个右上角的开始判断。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0;
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


    /**
     * 这个方法有一点慢，不过好理解啊
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for(int i = 0; i < rowLength; ++i){
            if(matrix[i][0] > target){
                break;
            }
            if(matrix[i][colLength-1] < target){
                continue;
            }
            //这个判断很重要，因为还有可能搜索下一行。
            if(binarySearch(matrix[0], target)){
                return true;
            }
        }
        return false;
    }

    /**
     * 二分的东西真的是基础，等下复习吧。
     * @param arr
     * @param target
     * @return
     */
    public static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        searchMatrix2(arr, 5);
    }
}
//此类存上矩阵的每行之间也是严格递增的解法
class searchMatrix2{
    /**
     * 思路就是从第一行开始对每一行进行二分查找。
     * @param matrix
     * @param target
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
     * 这个上个解法的递归写法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        if(matrix[0].length == 0){
            return false;
        }
        return find(matrix, 0, matrix[0].length-1, target);
    }
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
        else return find(matrix, row + 1, col, target);
    }



}
