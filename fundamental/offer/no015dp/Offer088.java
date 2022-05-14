package offer.no015dp;

/**
 * ClassName: Offer088
 * Description:
 * date: 9/5/2022 上午10:45
 *
 * @author liyh
 */
public class Offer088 {
}
class SolutionOffer088{
    //简单dp
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; ++i){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
