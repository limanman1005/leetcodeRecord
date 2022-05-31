package mySummary.Dp.palindrome;

/**
 * ClassName: LongestPalindrome
 * Description:
 * date: 29/5/2022 下午9:02
 *
 * @author liyh
 */
public class LongestPalindrome {
}
class Solution516{
    /**
     * 求一个字串的最长回文子序列。
     * 状态转移方程不难想，初始化也不复杂。
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; ++i){
            dp[i][i] = 1;
        }
        for(int i = len - 1; i >= 0; --i){
            for(int j = i + 1; j < len; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
