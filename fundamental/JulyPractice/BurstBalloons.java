package JulyPractice;

import java.util.Arrays;

/**
 * ClassName: BurstBalloons
 * Description: 戳气球，每一个气球上有一个数字。
 * 戳一个气球之后可以得到气球本身上的数字和左右两边气球上的数字的乘积。
 * 求气球全部戳破之后可以得到的最大硬币数，
 * 如何证明这个题符合动态规划的条件，不过想想，也是无影响的
 * date: 2020/7/20 10:26
 *
 * @author liyh
 */
public class BurstBalloons {
}

class Solution312 {
    public int[][] rec;
    public int[] val;

    /**
     * 记忆化递归解法
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        //这里是开区间，所以注意边界条件
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }


    /**
     * 这里动态规划的顺序要注意
     * @param nums
     * @return
     */
    public int maxCoins2(int[] nums){
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for(int i = 1; i <= n; ++i){
            val[i] = nums[i - 1];
        }
        for(int i = n - 1; i >= 0; --i){
            for(int j = i + 2; j <= n + 1; j++){
                for(int k = i + 1; k < j; ++k){
                    int sum = val[i] * val[j] * val[k];
                    //k比i要大，所以i需要从大到小。
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(sum, rec[i][j]);
                }
            }
        }
        return rec[0][n + 1];
    }
}
