package explore.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: IslandNum
 * Description: 还有一个深搜的解法
 * date: 2020/8/6 16:07
 *
 * @author liyh
 */
public class IslandNum {
}

class Solution200 {
    /**
     * BFS解法
     * 伪代码如下
     * 首先判断下应不应该入队，
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int ans = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for(int i = 0; i < rowNum; ++i){
            for(int j = 0; j < colNum; ++j){
                if(grid[i][j] == '1'){
                    ans++;
                    Queue<Integer> queue = new LinkedList<>();
                    //这个技巧要注意，使用挺方便的
                    queue.offer(i * colNum + j);
                    grid[i][j] = '0';
                    while(!queue.isEmpty()){
                        int cur = queue.poll();
                        int curX = cur/colNum;
                        int curY = cur%colNum;
                        for(int k = 0; k < 4; ++k){
                            int nx = curX + dx[k];
                            int ny = curY + dy[k];
                            if(inArea(nx, ny, grid) && grid[nx][ny] == '1'){
                                queue.offer(nx * colNum + ny);
                                grid[nx][ny] = '0';
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    private boolean inArea(int x, int y, char[][] grid){
        if(x >= 0 && x <grid.length && y >=0 && y <grid[0].length){
            return true;
        }
        else{
            return false;
        }
    }
}
