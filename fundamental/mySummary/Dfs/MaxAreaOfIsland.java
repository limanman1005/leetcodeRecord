package mySummary.Dfs;

import java.util.LinkedList;

/**
 * ClassName: LC695
 * Description:
 * date: 2021/9/11 10:18
 *
 * @author liyh
 */
public class MaxAreaOfIsland {
}
class Solution695{

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        if(grid == null || grid[0].length == 0){
            return ans;
        }
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }


    /**
     * 深度优先搜索
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public int dfs(int[][] grid, int i, int j){
        if(!inIsland(grid,i, j) || grid[i][j]  == 0){
            return 0;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        grid[i][j] = 0;
        int ans = 1;
        for(int idx = 0; idx < 4; ++idx){
            ans += dfs(grid, i + dx[idx], j + dy[idx]);
        }
        return ans;
    }

    public boolean inIsland(int[][]grid, int i, int j){
        if(i >= grid.length || i < 0 || j < 0 || j >= grid[0].length){
            return false;
        }
        return true;
    }


    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return ans;
        }
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                int curArea = 0;
                LinkedList<Integer> queueI = new LinkedList<>();
                LinkedList<Integer> queueJ = new LinkedList<>();
                queueI.addLast(i);
                queueJ.addLast(j);
                while(!queueI.isEmpty()){
                    int curI = queueI.pollFirst();
                    int curJ = queueJ.pollFirst();
                    if(!isInIsland(grid, curI, curJ) || grid[curI][curJ] == 0){
                        continue;
                    }
                    ++curArea;
                    grid[curI][curJ] = 0;
                    int[] dx = {0, 0, 1, -1};
                    int[] dy = {1, -1, 0, 0};
                    for(int idx = 0; idx < 4; ++idx){
                        queueI.addLast(curI + dx[idx]);
                        queueJ.addLast(curJ + dy[idx]);
                    }
                }
                ans = Math.max(ans, curArea);
            }
        }
        return ans;
    }


    public boolean isInIsland(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        return true;
    }

}
