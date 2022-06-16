package mySummary.Dp.stock;

import java.util.ArrayList;

/**
 * ClassName: Stock1
 * Description: 买卖股票的第一题。给一个数组是股票的第i天价格。
 * 只买卖一次能获取的最大利润
 * date: 2020/6/10 10:38
 *
 * @author liyh
 */
public class Stock1 {
    public static void main(String[] args) {
        System.out.println(-4 >> 1);
        System.out.println(-4 >>> 1);
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(- 4 >>> 1));
        ArrayList<Object> objects = new ArrayList<>();
    }
}
class Solution121 {
    /**
     * 首先这个dp法，dp[i]代表前i天的最大利润。然后维护一个前i天最小的价格。
     * 官方的一次遍历和这个本质上是一样的。只不过使用了常数量级的空间，这个暂搁吧
     * 假定的判断一下如果这天买这个股票的减去之间的利润和前一天获得的利润那个大，就是当前应该做的选择
     * 如何看出的是dp？
     * 因为规模小的比较好推断，大规模问题由小问题组成。甚至每一个状态都只和前一个状态有关。只要额外维护一个minprice即可得到转换方程
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int minPrice = prices[0];
        int[] dp = new int[n];
        for(int i = 1; i < n; ++i){
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }

    /**
     * 这里dp指的是到当前这一天之前的股票的最低价格
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = prices[0];
        int ans = 0;
        for(int i = 1; i < len; ++i){
            dp[i] = Math.min(dp[i - 1], prices[i]);
            ans = Math.max(ans, prices[i] - dp[i - 1]);
        }
        return ans;
    }
}
