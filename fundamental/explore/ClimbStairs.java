package explore;

/**
 * ClassName: ClimbStairs
 * Description: 爬楼梯那道题
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
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
