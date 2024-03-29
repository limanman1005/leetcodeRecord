package explore.queueAndStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: WallAndDoor
 * Description: 多源BFS
 * date: 2020/8/6 15:34
 *
 * @author liyh
 */
public class WallAndDoor {
    public static void main(String[] args) {
        Solution286 solution286 = new Solution286();
        int[][] rooms = {{2147483647,-1,0,2147483647},
                         {2147483647,2147483647,2147483647,-1},
                         {2147483647,-1,2147483647,-1},
                         {0,-1,2147483647,2147483647}};
        solution286.wallsAndGates2(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.printf(rooms[i][j] + ",");
            }
            System.out.println();
        };
    }
}
class Solution286 {
    /**
     * 多源BFS。
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0){
            return ;
        }
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < m; ++row){
            for(int col = 0; col < n; ++col){
                if(rooms[row][col] == 0){
                    queue.add(new int[]{row, col});
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < 4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //在这区域内，并且当前门向前走一步小于之前的。就更新（其实可以直接判空不空，结果是一样的。因为队列是每一个门都走一步）
                if(nx >=0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] > rooms[x][y] + 1){
                    rooms[nx][ny] = rooms[x][y] + 1;
                    //这里要记得把新的加进去
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }


    public void wallsAndGates2(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        boolean[][] visited;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(rooms[i][j] == 0){
                    visited = new boolean[rows][cols];
                    queue.addLast(new int[]{i, j});
                    int curMinDistance = 0;
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        curMinDistance++;
                        for(int n = 0; n < size; ++n){
                            int[] curPos = queue.pollFirst();
                            for(int k = 0; k < 4; ++k){
                                int nx = curPos[0] + dx[k];
                                int ny = curPos[1] + dy[k];
                                if(isInArea(nx, ny, rooms) && !visited[nx][ny] && rooms[nx][ny] != -1 && rooms[nx][ny] != 0){
                                    rooms[nx][ny] = Math.min(rooms[nx][ny], curMinDistance);
                                    queue.addLast(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ;
    }

    private boolean isInArea(int nx, int ny, int[][] rooms){
        if(nx >= 0 && nx < rooms.length && ny >= 0 && ny < rooms[0].length){
            return true;
        }
        return false;
    }
}
