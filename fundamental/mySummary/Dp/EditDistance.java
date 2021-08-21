package mySummary.Dp;

/**
 * ClassName: EditDistance
 * Description:
 * date: 2020/9/21 16:39
 *
 * @author liyh
 */
public class EditDistance {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        String word1 = "horse";
        String word2 = "ros";
        solution72.minDistance2("", "");
//        solution72.minDistance(word1, word2);
    }
}
class Solution72 {
    private Integer[][] memo;
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return helper(word1, word2, word1.length(), word2.length());
    }
    private int helper(String word1, String word2, int i, int j){
        if(i == 0 && j == 0){
            return 0;
        }
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            return helper(word1, word2, i - 1, j - 1);
        }
        else{
            int deleted = helper(word1, word2, i - 1, j);
            int insert = helper(word1, word2, i , j - 1);
            int replaced = helper(word1, word2, i - 1, j - 1);
            memo[i][j] = Math.min(Math.min(insert, deleted), replaced) + 1;
            return memo[i][j];
        }
    }


    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j < len2; ++j){
            dp[0][j] = j;
        }
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                int insert = dp[i - 1][j]  + 1;
                int delete = dp[i][j - 1] + 1;
                int replace = dp[i - 1][j - 1] + 1;
                int min = Math.min(insert, Math.min(delete, replace));
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    min = Math.min(dp[i - 1][j - 1], min);
                }
                dp[i][j] = min;
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
