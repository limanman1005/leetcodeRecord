package middleAlgorithm.TreeAndGraph;

/**
 * ClassName: IslandNum
 * Description:
 * date: 2020/7/6 19:03
 *
 * @author liyh
 */
public class IslandNum {
}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length  <= 0){
            return -1;
        }
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return ;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}