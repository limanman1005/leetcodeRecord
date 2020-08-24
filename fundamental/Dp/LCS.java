package Dp;

/**
 * ClassName: LCS
 * Description:
 * date: 2020/8/21 11:06
 *
 * @author liyh
 */
public class LCS {
}
class Solution1143 {
    /**
     * 这个边界条件的处理有各种不同的方法
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; ++i){
            for(int j = 0; j < len2; ++j){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}