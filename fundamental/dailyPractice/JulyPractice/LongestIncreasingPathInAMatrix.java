package dailyPractice.JulyPractice;

/**
 * ClassName: LongestIncreasingPathInAMatrix
 * Description: 未看此题
 * date: 2020/7/27 9:37
 *
 * @author liyh
 */
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution329 solution329 = new Solution329();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int i = solution329.longestIncreasingPath2(matrix);
        System.out.println(i);
    }
}
class Solution329 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }


    public int longestIncreasingPath2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                ans = Math.max(ans, dfs2(matrix, i, j));
            }
        }
        return ans;
    }
    private int dfs2(int[][] matrix, int i, int j){
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int curAns = 1;
        for(int k = 0; k < 4; ++k){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(check(matrix, nx, ny) && matrix[nx][ny] > matrix[i][j]){
                int next = dfs2(matrix, nx, ny);
                curAns = Math.max(curAns, next + 1);
            }
        }
        return curAns;
    }
    private boolean check(int[][] matrix, int i, int j){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(i >= 0 && i < rows && j >=0 && j < cols){
            return true;
        }
        else{
            return false;
        }
    }

}
