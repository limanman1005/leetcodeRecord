package offer.no014dp;

/**
 * ClassName: Offer091
 * Description:
 * date: 9/5/2022 上午11:10
 * 粉刷房子
 * @author liyh
 */
public class Offer091 {
}

class SolutionOffer091 {
    /**
     * 这个和股票有点像，都是分分状态讨论
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }
}
