package JulyPractice;

/**
 * ClassName: InterleavingString
 * Description: 交错字符串，给两个字符串s1和s2看下两个能否构成另一个字符串s3
 * date: 2020/7/20 10:11
 * e.g.
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * @author liyh
 */
public class InterleavingString {
}
class Solution97 {
    /**
     * 动态规划，合并了边界情况的处理。后面还能使用滚动数组进行优化，这里暂时到这了
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if(n + m != t){
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= m; ++j){
                int p = i + j - 1;
                //这里是包括了边界情况
                if(i > 0){
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 给一个边界情况讨论的比较清晰的
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 另一个边界情况比较清晰的
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave3(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int n1 = s1.length(),n2 = s2.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for(int i=1;i<=n1;++i)
        {
            dp[i][0] = dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
        for(int i=1;i<=n2;++i)
        {
            dp[0][i] = dp[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                dp[i][j] = dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i-1+j)||dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i-1+j);
            }
        }
        return dp[n1][n2];
    }



}

