package chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: MatrixBfs
 * Description:
 * date: 2020/4/17 10:52
 *
 * @author liyh
 */
public class MatrixBfs {


    /**
     * 这个解法看的甜姨的解法，真的好懂。
     * 此题还有其他解法，暂时不写了。
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int i = 0; i < 4; ++i){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                //bfs思想天然保证最短的距离
                //这个判断判定是否超界和是否更新过。
                if(nx>=0 && nx <m && ny>=0 && ny<n && matrix[nx][ny] == -1){
                    matrix[nx][ny] = matrix[point[0]][point[1]] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return matrix;
    }
}
