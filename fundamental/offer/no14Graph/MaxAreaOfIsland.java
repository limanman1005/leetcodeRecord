package offer.no14Graph;

import java.util.LinkedList;

/**
 * ClassName: MaxAreaOfIsland
 * Description:
 * date: 27/4/2022 下午10:57
 *
 * @author liyh
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        SolutionOffer105 solutionOffer105 = new SolutionOffer105();
        int[][] gird = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int i = solutionOffer105.maxAreaOfIsland(gird);
        System.out.println(i);
    }
}

class SolutionOffer105{
    /**
     * 广度优先搜索，没什么好说的了
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }


    private int getArea(int[][] grid, boolean[][] visited, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.pollFirst();
//            area++;
            for(int[] dir: dirs){
                int nx = pos[0] + dir[0];
                int ny = pos[1] + dir[1];
                if(inArea(grid, nx, ny) && grid[nx][ny] == 1 && !visited[nx][ny]){
                    area++;
                    visited[nx][ny] = true;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
        return area;
    }

    private boolean inArea(int[][] grid, int x, int y){
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            return true;
        }
        else{
            return false;
        }
    }

}
