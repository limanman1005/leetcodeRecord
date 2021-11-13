package mySummary.Dp.bags;

import java.util.Arrays;

/**
 * ClassName: LC279
 * Description:
 * date: 2021/8/22 16:09
 * 给一个正整数n，使用完全平方数拼凑出n，要求使用的完全平方数的数量最少。
 * 此题和硬币兑换（322）一模一样，求使用的硬币最少
 * n的范围为0-10e4
 * @author liyh
 */
public class PerfectSquares {
}
class Solution279{

    /**
     * 此方法没有一个数组直接可以拿到填充的数字大小，我们自己直接算出一个边界作为循环结束条件。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //这里别忘了求的是最小的值，数组初始化为0需要变一变了。
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        //
        for(int i = 1; i * i <= n; ++i){
            for(int j = 0; j <= n; ++j){
                if(j >= i * i){
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
                }
            }
        }
        return dp[n];
    }
}
