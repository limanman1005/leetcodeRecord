package mySummary.Dp.lis;

import java.util.Arrays;

/**
 * ClassName: LC354
 * Description: 俄罗斯信封套娃问题，本质上和最长上升子序列一样
 * date: 2021/9/14 10:32
 *
 * @author liyh
 */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] test = {{1, 3}, {3, 5}, {2, 3}};

        Arrays.sort(test, (a,b)-> a[0] > b[0] ? 1: -1);

        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
    }
}

class Solution354 {
    /**
     * LIS的动态规划题，更换状态定义可以利用二分法。
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return -1;
        }
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        //这样排序的方法要留意。
        Arrays.sort(envelopes, (o1, o2)->{
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        int ans = 1;
        for(int i = 1; i < len; ++i){
            for(int j = i - 1; j >= 0; --j){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
