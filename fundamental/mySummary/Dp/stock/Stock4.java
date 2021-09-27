package mySummary.Dp.stock;

/**
 * ClassName: LC188
 * Description: 股票问题4，可以交易k次和3的问题本质上是一样的
 * 交易K次的还有使用二位数组的解法，将交易k次压缩到几个状态中去
 * date: 2021/9/23 10:33
 *
 * @author liyh
 */
public class Stock4 {
}
class Solution188 {
    /**
     * 使用三位数组的解法
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        for(int i = 0; i < len; ++i){
            for(int j = 1; j <= k; ++j){
                //此处是初始化
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }


    /**
     * 这样进行初始化比较的清楚
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        for(int i = 0; i <= k; ++i){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for(int i = 1; i < len; ++i){
            for(int j = 1; j <= k; ++j){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}
