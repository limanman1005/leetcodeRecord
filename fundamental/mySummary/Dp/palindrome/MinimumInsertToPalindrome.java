package mySummary.Dp.palindrome;

/**
 * ClassName: MinumInsertToPalindrome
 * Description:
 * date: 29/5/2022 下午9:00
 *
 * @author liyh
 */
public class MinimumInsertToPalindrome {
}
class Solution1312 {
    /**
     * 区间DP算法
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        int len = s.length();
        //这里没有进行初始化是因为所有的值都为0
        int[][] dp = new int[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    //i + 1的边界条件也直接过滤了
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
