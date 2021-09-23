package mySummary.Dp.stock;

/**
 * ClassName: LC123
 * Description: 股票问题3最多交易两次的股票问题
 * date: 2021/9/23 10:27
 *
 * @author liyh
 */
public class Stock3 {
}
class Solution123 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        for(int i = 0; i < len; ++i){
            for(int j = 1; j <= 2; ++j){
                //初始化值
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        //至多交易两次
        return dp[len - 1][2][0];
    }
}
