package AugustPractice;

/**
 * ClassName: dungeonGame
 * Description:
 * date: 2020/9/6 19:14
 *
 * @author liyh
 */
public class DungeonGame {
}
class Solution174 {
    /**
     * dfs暴力搜索法。
     * 每一个当前位置来说，需要的最少血量是下方或者右方的最小值 - 当前dungeon的值（当前值为负，则说明到这个各自需要增加血量
     * ，如果为正说明到达该位置的最小血量可以减小，但是不能小于1） 和 1比较的较大值
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int ans = dfs(dungeon, dungeon.length, dungeon[0].length, 0, 0);
        return ans;
    }
    private int dfs(int[][] dungeon, int m, int n , int i, int j){
        if(i == m - 1 && j == n - 1){
            return Math.max(1 - dungeon[m - 1][n - 1], 1);
        }
        if(i == m - 1){
            return Math.max(dfs(dungeon, m, n, i, j + 1) - dungeon[i][j], 1);
        }
        if(j == n - 1){
            return Math.max(dfs(dungeon, m, n, i + 1, j) - dungeon[i][j], 1);
        }
        return Math.max(Math.min(dfs(dungeon, m, n, i + 1, j), dfs(dungeon, m, n, i , j + 1)) - dungeon[i][j], 1);
    }
}
