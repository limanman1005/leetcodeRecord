package chapter4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: RotateMatrix
 * Description:
 * date: 2020/4/16 10:57
 *
 * @author liyh
 */
public class RotateMatrix {


    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3},
//                          {4, 5, 6},
//                          {7, 8, 9},
//                        {10, 11, 12}};
//        List<Integer> integers = spiralOrder(matrix);
//        int[][] clone = matrix.clone();
//        List<Integer> spiralOrder2 = spiralOrder2(clone);
//        integers.forEach(System.out::print);
//        System.out.println();
//        System.out.println("=============================================");
//        spiralOrder2.forEach(System.out::print);
        int[][] ints = generateMatrix(3);

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0){
            return ans;
        }
        int R = matrix.length, C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for(int i = 0; i < R*C; i++){
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if(0 <= cr && cr < R && 0 <= cc && cc < C && !visited[cr][cc]){
                r = cr;
                c = cc;
            }else{
                di = (di + 1)%4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    public static List<Integer> spiralOrder2(int[][] matrix){
        ArrayList<Integer> ans = new ArrayList<>();
        if(matrix.length == 0){
            return ans;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length -1;
        while (r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; c++){
                ans.add(matrix[r1][c]);
            }
            for(int r = r1 + 1; r <= r2; r++){
                ans.add(matrix[r][c2]);
            }
            if(r1 < r2 && c1 < c2){
                for(int c = c2 -1; c > c1; c--){
                    ans.add(matrix[r2][c]);
                }
                for(int r = r2; r > r1; r--){
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ans;
    }

    public static void rotateMatrix(int[][] matrix){

    }

    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++){
                mat[t][i] = num++;
            }
            t++;
            for(int i = t; i <= b; i++){
                mat[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--){
                mat[b][i] = num++;
            }
            b--;
            for(int i = b; i >= t; i--){
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }

    /**
     * 这个是李雷雷的一个解法，大风车解法，规律有点难推导。但是找规律的方法应该是一样的。
     * 还有一个简单的写法，就是先对角线反转，然后或者以中间行反转或者中间列反转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0; i < N/2; ++i){
            for(int j = i; j < N - i - 1; j++){
                int temp  = matrix[i][j];
                matrix[i][j] = matrix[N-j-1][i];
                matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
                matrix[N-i-1][N-j-1] = matrix[j][N-i-1];
                matrix[j][N-i-1] = temp;
            }
        }
    }

    /**
     * 矩阵置零的那道题。这个不是原地算法。原地那个感觉不靠谱。
     * @param matrix
     */
    public static void set0(int[][] matrix){
        int row  = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; ++j){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }



}
