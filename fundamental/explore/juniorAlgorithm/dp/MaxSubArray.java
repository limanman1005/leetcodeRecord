package explore.juniorAlgorithm.dp;

/**
 * ClassName: MaxSubArray
 * Description: 给一个数组里面，求出数组里面包含的子数组的中和最大的。
 * 暴力法有点超时了。
 * 还是动规法有点意思，以后也可以多想想分治法
 * date: 2020/6/19 17:49
 *
 * @author liyh
 */
public class MaxSubArray {
    public static void main(String[] args) {
        String s = "123";
        StringBuilder sb  = new StringBuilder("123");
        sb.insert(1, '.');
        System.out.println(sb);
    }

}

class Solution53 {
    /**
     * 动态规划法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < len; ++i){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //注意了答案不是最后一个
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
