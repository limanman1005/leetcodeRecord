package JunePractice;

/**
 * ClassName: SprialMatrix
 * Description:
 * date: 2020/6/5 9:19
 *
 * @author liyh
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution54.spiralOrder(matrix);
    }
}

class Solution54 {
    /**
     * 这个是模拟的思路。使用一个标记的二维数组和巧妙地求余运算来模拟一个指针在矩阵中的螺旋选取的概念。
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] ans = new int[rowLen * colLen];
        boolean[][] visited = new boolean[rowLen][colLen];
        //这个两个数组代表的是走向的顺序。
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0, col = 0, di = 0;
        for(int i = 0; i < rowLen * colLen; ++i){
            ans[i] = matrix[row][col];
            visited[row][col] = true;
            int cr = row + dr[di];
            int cc = col + dc[di];
            if(cr >= 0 && cr <rowLen && cc >= 0 && cc <colLen && !visited[cr][cc]){
                row = cr;
                col = cc;
            }
            else{
                //这几个数的运用是重点，di是判断下当前的走向。（是从上到下，还是从下到上等等）
                di = (di + 1)%4;
                row += dr[di];
                col += dc[di];
            }
        }
        return ans;
    }

    /**
     * 模拟的第二种写法。使用上下左右四个变量。
     * 每次都读上下左右的一行。然后判断下溢出没，如果溢出了，就说明读完了。
     * 还有一个答案比较的奇怪，思路好像不完整。暂时不列了
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] ans = new int[(r + 1) * (b + 1)];
        int idx = 0;
        while(true){
            for(int i = l; i <= r; ++i){
                ans[idx++] = matrix[t][i];
            }
            if(++t > b){
                break;
            }
            for(int i = t; i <= b; ++i){
                ans[idx++] = matrix[i][r];
            }
            if(l > --r){
                break;
            }
            for(int i = r; i >= l; i--){
                ans[idx++] = matrix[b][i];
            }
            if(--b < t){
                break;
            }
            for(int i = b; i >= t; --i){
                ans[idx++] = matrix[i][l];
            }
            if(++l > r){
                break;
            }
        }
        return ans;
    }
}