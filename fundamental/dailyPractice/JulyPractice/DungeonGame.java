package dailyPractice.JulyPractice;

/**
 * ClassName: DungeonGame
 * Description:
 * date: 2020/7/12 22:50
 *
 * @author liyh
 */
public class DungeonGame {
    public static void main(String[] args) {
        Solution147 solution147 = new Solution147();
        int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int i = solution147.calculateMinimumHP(ints);
    }
}
class Solution147 {
    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, dungeon.length, dungeon[0].length, 0, 0);
    }
    private int dfs(int[][] dungeon, int m, int n, int i, int j){
        if(i == m - 1 && j == n - 1){
            return Math.max(1 - dungeon[i][j], 1);
        }
        if(i == m - 1){
            return Math.max(dfs(dungeon, m, n, i, j + 1) - dungeon[i][j], 1);
        }
        if(i == n - 1){
            return Math.max(dfs(dungeon, m, n, i + 1, j) - dungeon[i][j], 1);
        }
        return Math.max(Math.min(dfs(dungeon, m, n, i + 1, j), dfs(dungeon, m, n, i, j + 1)) - dungeon[i][j], 1);
    }
}
