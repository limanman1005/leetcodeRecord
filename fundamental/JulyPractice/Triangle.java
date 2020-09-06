package JulyPractice;

import java.util.List;

/**
 * ClassName: Triangle
 * Description: 给一个下三角矩阵，找到从顶点到底点中最小路径和。
 * 这是到经典的动态规划的题目了。
 * 从顶到底，有点复杂，暂时不看了。
 * date: 2020/7/14 10:14
 *
 * @author liyh
 */
public class Triangle {
}
class Solution120 {

    /**
     * dfs解法
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }
    private int dfs(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size()){
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }


    Integer[][] dp;

    /**
     * 加上了memo的dp
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return dfs2(triangle, 0, 0);
    }
    private int dfs2(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size()){
            return 0;
        }
        //这里使用null，避免了填充数组的情况
        if(dp[i][j] != null){
            return dp[i][j];
        }
        return dp[i][j] = Math.min(dfs2(triangle, i + 1, j), dfs2(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 从底向上的dp
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 空间优化后的dp
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >=0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}