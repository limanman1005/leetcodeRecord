package JulyPractice;

/**
 * ClassName: IntegerBreak
 * Description: 把一个整数拆分成至少两个数，使得这些数的乘积最大
 * 拆分一个，还能照着再次拆分。小的结果在大的规模分解的时候也可以使用，明显的动态规划。
 * 小的规模dp[0]和dp[1]都为0，然后剩下的推导公式就是一个一个枚举可分解的情况，从1开始推到i-1的一个变量j
 * 乘上当前剩下的 (i - j) 和 dp里面存的 j * dp[i - j]比较。遍历所有j的情况找到一个最大值就是dp[i]
 * date: 2020/7/30 9:33
 * @author liyh
 */
public class IntegerBreak {
}
class Solution343 {
    /**
     * 典型的动态规划
     * 还可以通过具体分析来仅有降低复杂度。将第二层循环给干掉，只判断有限的几个值。
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; ++i){
            int curMax = 0;
            for(int j = 1; j < i; ++j){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


    private Integer[] memo;

    /**
     * 补充一个记忆化递归
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        if(n == 2){
            return 1;
        }
        memo = new Integer[n + 1];
        return helper(n);
    }
    private int helper(int n){
        if(n == 2){
            return 1;
        }
        if(memo[n] != null){
            return memo[n];
        }
        int ans = -1;
        for(int i = 1; i < n; ++i){
            ans = Math.max(ans, Math.max(i * (n - i) , i * helper(n - i)));
        }
        memo[n] = ans;
        return ans;
    }



}