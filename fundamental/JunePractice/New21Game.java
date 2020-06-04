package JunePractice;

/**
 * ClassName: New21Game
 * Description: 一道因为是独立概率，所以可用动态规划的求概率的一道题，
 * 此题也可以放到动态规划，那一部分。
 *
 * date: 2020/6/3 9:26
 *
 * @author liyh
 */
public class New21Game {
}

class Solution837 {
    /**
     * 这个题，其他的还好懂，就是那个dp[k - 1]的求法没有看懂
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        if(K == 0){
            return 1.0;
        }
        double[] dp = new double[K + W + 1];
        for(int i = K; i <= N && i < K + W; ++i){
            dp[i] = 1;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for(int i = K - 2; i >= 0; --i){
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
