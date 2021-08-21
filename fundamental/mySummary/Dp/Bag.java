package mySummary.Dp;

/**
 * ClassName: Bag
 * Description:
 * date: 2020/10/5 10:14
 *
 * @author liyh
 */
public class Bag {
    public static void main(String[] args) {
        Solution08_11 solution08_11 = new Solution08_11();
        int i = solution08_11.wayToChange(100);
        System.out.println(i);
    }
}
class Solution08_11{
    //求总数
    public int wayToChange(int n){
        int[] coins = {25, 10, 5, 1};
//        Arrays.sort(coins);
        int[][] dp = new int[5][n + 1];
        for(int i = 1; i <= 4; ++i){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= 4; ++i){
            for(int j = 1; j <= n; ++j){
                if(j - coins[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                }
                else{
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }
}
