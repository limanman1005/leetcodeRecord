package mySummary.Dp.lis;

import java.util.Arrays;

/**
 * ClassName: LC646
 * Description: 此题也可以转化为最长上升子序列，且和LC435几乎一样
 * date: 2021/9/14 10:17
 *
 * @author liyh
 */
public class MaximumLengthOfPairChain {
}
class Solution646 {
    /**
     * 此题和435基本一致。也不需要多一步转换。
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs[0].length == 0){
            return -1;
        }
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (o1, o2) ->{
            return o1[0] - o2[0];
        });
        int ans = 1;
        for(int i = 1; i < len; ++i){
            for(int j = i - 1; j >= 0; --j){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
