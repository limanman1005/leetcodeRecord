package dailyPractice.JulyPractice;

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
     * * @param A
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
}
