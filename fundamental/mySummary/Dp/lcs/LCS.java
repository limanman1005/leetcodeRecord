package mySummary.Dp.lcs;

/**
 * ClassName: LCS
 * Description:
 * date: 2020/8/21 11:06
 *
 * @author liyh
 */
public class LCS {
    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        int i = solution1143.longestCommonSubsequence("abcde", "ace");
        System.out.println("i = " + i);
        String lcsString = solution1143.getLCSString("abcde", "abcde");

        System.out.println(lcsString);
    }
}
class Solution1143 {
    /**
     * 这个边界条件的处理有各种不同的方法,见718
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
        //注意这里也是使用了哨兵的，下标范围是0-len之间的len + 1个位置
        //初始化直接是dp[0][j]和dp[i][0] = 0,这里没有显式初始化罢了
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


    public int[][] geDpArr(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return null;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        //注意这里也是使用了哨兵的，下标范围是0-len之间的len + 1个位置
        //初始化直接是dp[0][j]和dp[i][0] = 0,这里没有显式初始化罢了
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
        return dp;
    }


    public String getLCSString(String text1, String text2){
        int[][] dp = geDpArr(text1, text2);
        int i = text1.length(), j = text2.length();
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i][j] == dp[i - 1][j]){
                i--;
            }
            else if(dp[i][j] == dp[i][j - 1]){
                j--;
            }
        }
        return sb.reverse().toString();
    }

    private Integer[][] memo;
    public int longestCommonSubsequence2(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        memo = new Integer[text1.length()][text2.length()];
        int ans = dfs(text1, text2, text1.length(), text2.length());
        return ans;
    }
    private int dfs(String text1, String text2, int len1, int len2){
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        if(memo[len1 - 1][len2 - 1] != null){
            return memo[len1 - 1][len2 - 1];
        }
        if(text1.charAt(len1 - 1) == text2.charAt(len2 - 1)){
            memo[len1 - 1][len2 - 1] = dfs(text1, text2, len1 - 1, len2 - 1) + 1;
        }
        else{
            memo[len1 - 1][len2 - 1] = Math.max(dfs(text1, text2, len1 - 1, len2), dfs(text1, text2, len1, len2 - 1));
        }
        return memo[len1 - 1][len2 - 1];
    }



}
