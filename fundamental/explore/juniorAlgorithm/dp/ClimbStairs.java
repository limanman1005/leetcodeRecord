package explore.juniorAlgorithm.dp;

/**
 * ClassName: ClimbStairs
 * Description: 爬楼梯经典dp，此题将阶数改为参数m，就是一个完全背包的问题
 * 每次可以走1至m，凑成阶梯的总数有多少种排列数
 * date: 2020/6/19 17:46
 *
 * @author liyh
 */
public class ClimbStairs {
}
class Solution70 {
    /**
     * 简单的dp
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
