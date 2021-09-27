package mySummary.Dp.lcs;

/**
 * ClassName: MaxLengthOfRepeatedSubArray
 * Description: 给两个数组，两个数组找到两个数组里面的相同子数组的最大长度
 * e.g.
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 此题还有滑动窗口和二分查找+hash方法。暂时跳过
 * 此题和LCS还是有区别的，数字必须连续
 * date: 2020/7/1 9:41
 *
 * @author liyh
 */
public class MaxLengthOfRepeatedSubArray {
}

class Solution718 {
    /**
     * 暴力解法是枚举每一个a和b开始的位置，然后再进行比较时间复杂度为O(n3)
     * 动态规划解法。从后向前。这个时间复杂度不是最优的。
     * 如果a[i]和b[j]相等。那么a[i :]和b[j: ]的最长公共前缀是a[i + 1 : ]和b[i + 1 : ]
     * 的最长公共前缀加一。否则为0.
     * 使用dp[i][j]表示a[i:]和b[j:]的最长公共前缀。进行状态转移即可。
     * 此题是从后向前的状态定义。
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; --j){
                dp[i][j] = (A[i] == B[j]? dp[i + 1][j + 1] + 1 : 0);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 使用了哨兵技巧的一种写法
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int ans = 0;
        for(int i = 0; i < len1; ++i){
            for(int j = 0; j < len2; ++j){
                if(nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else{
                    dp[i + 1][j + 1] = 0;
                }
                ans = Math.max(dp[i + 1][j + 1], ans);
            }
        }
        return ans;
    }


    /**
     * 使用了哨兵技巧的另一种写法
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int ans = 0;
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }


}
