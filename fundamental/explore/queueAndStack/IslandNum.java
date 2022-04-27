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
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        Solution200 solution200 = new Solution200();
        int i = solution200.numIslands2(chars);
        System.out.println(i);
    }
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


    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int islandNum = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '0'){
                    continue;
                }
                else{
                    islandNum++;
                    grid[i][j] = '0';
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.addLast(i * col + j);
                    while(!queue.isEmpty()){
                        int cur = queue.pollFirst();
                        for(int k = 0; k < 4; k++){
                            int nx = cur / col + dx[k];
                            int ny = cur % col + dy[k];
                            if(isLand(nx, ny, row, col) && grid[nx][ny] == '1'){
                                queue.addLast(nx * col + ny);
                                grid[nx][ny] = '0';
                            }
                        }
                    }
                }
            }
        }
        return islandNum;
    }


    private boolean isLand(int x, int y, int row, int col){
        if(x >= 0 && x < row && y >= 0 && y < col){
            return true;
        }
        else{
            return false;
        }
    }
}
