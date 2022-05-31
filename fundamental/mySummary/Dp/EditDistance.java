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
        String word1 = "sea";
        String word2 = "eat";
//        solution72.minDistance2("", "");
        System.out.println(solution72.minDistance2(word1, word2));
        System.out.println(solution72.minDistance3(word1, word2));
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
        return dp[len1][len2];
    }

    public int minDistance3(String word1, String word2) {
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
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int insert = dp[i - 1][j]  + 1;
                    int delete = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    int min = Math.min(insert, Math.min(delete, replace));
                    dp[i][j] = min;
                }
            }
        }
        return dp[len1][len2];
    }


    /**
     * 这题有点意思的，不用哨兵技巧，边界条件有点难以初始化啊
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance4(String word1, String word2) {
        if(word1 == null || word2 == null){
            return 0;
        }
        if(word1.length() == 0 && word2.length() == 0){
            return 0;
        }
        else if(word1.length() == 0){
            return word2.length();
        }
        else if(word2.length() == 0){
            return word1.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        dp[0][0] = (word1.charAt(0) == word2.charAt(0)? 0: 1);
        //这个的确就是边界情况比较的难搞，直接用哨兵还是蛮省心的
        for(int i = 1; i < len1; ++i){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            }
            else{
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for(int i = 1; i < len2; ++i){
            if(word1.charAt(0) == word2.charAt(i)){
                dp[0][i] = i;
            }
            else{
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for(int i = 1; i < len1; ++i){
            for(int j = 1; j < len2; ++j){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    int min = Math.min(insert, Math.min(delete, replace));
                    dp[i][j] = min;
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
