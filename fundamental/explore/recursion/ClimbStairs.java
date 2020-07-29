package explore.recursion;

/**
 * ClassName: ClimbStairs
 * Description: 爬楼梯那道题
 * 这道题还应该记住快速幂的算法，和公式法。
 * date: 2020/5/13 9:43
 *
 * @author liyh
 */
public class ClimbStairs {
    public static void main(String[] args) {
    }
}
class Solution70 {
    private int[] dp = new int[32];
    public int climbStairs(int n) {
        if(n == 0 || n == 1){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] =  climbStairs(n - 1) + climbStairs(n - 2);
    }

    //这里预留点其他算法的例子


    /**
     * 增加一个记忆化递归的方法，自顶向下，不断分解。
     * 然后写一下当前状态是如何转化到下一个状态的
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    private int helper(int n, int[] memo){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}
