package explore.queueAndStack;

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


}