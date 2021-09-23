package mySummary.Dp.bags;

/**
 * ClassName: LC518
 * Description:零钱兑换，完全背包问题
 * date: 2021/9/23 17:45
 *
 * @author liyh
 */
public class LC518 {
}
class Solution {
    /**
     * 此题代码较少，但需要注意的时本题要求的时组成的组合数，不是排列数
     * 内外循环不可变，必须要外层硬币，内层总数
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; ++i){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
