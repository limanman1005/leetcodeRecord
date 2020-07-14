package JulyPractice;

/**
 * ClassName: StockWithCooldown
 * Description: 含冷冻期的股票问题，典型的动态规划
 * date: 2020/7/10 9:38
 * 股票问题还有其他的题
 * 例如，121，122，123，188，309，714，剑指offer63
 * @author liyh
 */
public class StockWithCooldown {
}
class Solution309 {
    /**
     * 动态规划解法
     * 使用数组来表示自己前i天能得到的最大收益
     * 然后增加一位来表示当前那天的状态。是持有，卖出，还是处于冷冻期。
     * 根据不同的状态来
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //使用二维数组，第一维表示第i天的能获得的最大利润
        //第二维表示当前股票所处的状态，这里使用0代表持有，1代表不持有但是处于冷冻期，2代表不持有也不处于冷冻期。
        int[][] dp = new int[n][3];
        //初始化第0天的各种状态，这持有状态
        //剩下的不持有的两个状态都是0，就不一一写出了。第0天不存在冷冻期，这里我依旧默认为0？
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; ++i){
            //第i天的持有状态是第i - 1天的持有状态，i-1天的非持有且不处于冷冻期的状态 - 第i天的股票（买入股票的钱）
            //两个值的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //第i天的不持有且处于冷冻期的状态是第i - 1的持有状态加上卖股票的钱。
            dp[i][1] = dp[i - 1][0] + prices[i];
            //第i天的不持有且不处于冷冻期的状态是第i - 1天不持有但是处于冷冻期的状态（i-2天卖出了， i - 1天没有操作）
            //和第i - 1天的不持有且不处于冷冻期的最大值（i - 1天的没有操作）。
            //这个状态只能由这两个状态转换而来。
            //这个处于冷冻期的dp[i - 1][1]初始状态是0，这个和初始状态的不处于冷冻期的一样，不会影响最后结果
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //这里返回第n - 1天不持有股票的两个值中的较大值。
        return Math.max(dp[n - 1][1], dp[n- 1][2]);
    }
}