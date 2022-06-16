package offer.no15Graph;

import java.util.LinkedList;

/**
 * ClassName: Offer105
 * Description:
 * date: 3/6/2022 下午6:03
 *
 * @author liyh
 */
public class Offer105 {
    public static void main(String[] args) {
        SolutionOffer105And695 solutionOffer105And695 = new SolutionOffer105And695();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int max = solutionOffer105And695.maxAreaOfIsland(grid);
        System.out.println("max = " + max);


    }
}
class SolutionOffer105And695{
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, getArea(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int getArea(int[][] grid, int i, int j){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{i, j});
        grid[i][j] = 0;
        int curArea = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.pollFirst();
            curArea++;
            grid[pos[0]][pos[1]] = 0;
            for(int k = 0; k < 4; ++k){
                int nx = pos[0] + dx[k];
                int ny = pos[1] + dy[k];
                if(inArea(nx, ny, grid) && grid[nx][ny] == 1){
                    queue.addLast(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }
        return curArea;
    }

    private boolean inArea(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
