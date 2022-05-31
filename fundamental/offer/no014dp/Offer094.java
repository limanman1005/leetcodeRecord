package offer.no014dp;

/**
 * ClassName: Offer094
 * Description: 最少回文分割
 * date: 18/5/2022 上午12:40
 *
 * @author liyh
 */
public class Offer094 {
}

/**
 * 这个也是状态定义倒是不难想，但是也挺难写的。
 */
class SolutionOffer094And132{

    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        return dp[s.length() - 1];
    }


}
