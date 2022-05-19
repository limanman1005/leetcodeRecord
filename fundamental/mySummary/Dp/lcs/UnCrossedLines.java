package mySummary.Dp.lcs;

/**
 * ClassName: LC1035
 * Description: 最长公共子序列的换皮题，想要想要线不相交就是求公共子序列
 * date: 2021/9/14 12:30
 *
 * @author liyh
 */
public class UnCrossedLines {
}
class Solution1035{
    //最长上升子序列换皮题，简单轻松
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
