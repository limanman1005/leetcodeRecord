package mySummary.Dp.stock;

/**
 * ClassName: LC714
 * Description: 股票交易包括手续费
 * date: 2021/9/23 10:38
 *
 * @author liyh
 */
public class LC714 {
}
class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; ++i){
            //就这里和之前stock2不一样
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
