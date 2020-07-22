package explore.recursion;

/**
 * ClassName: FibFunction
 * Description:
 * date: 2020/5/12 16:01
 *
 * @author liyh
 */
public class FibFunction {
    public static void main(String[] args) {
        System.out.println(new Solution509().fib(3));
    }
}

class Solution509 {
    private int[] dp = new int[32];
    public int fib(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            dp[N] = 1;
            return 1;
        }
        if(dp[N] != 0){
            return dp[N];
        }
        return dp[N] = fib(N - 1) + fib(N - 2);
    }
}
