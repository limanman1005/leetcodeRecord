package dailyPractice.JulyPractice;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName: SplitArrayLargestSum
 * Description:  分隔数组的最大值
 * date: 2020/7/27 9:36
 * 未看此题
 * @author liyh
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        for(int i = 0; i < 3; ++i){
            Arrays.fill(arr[i], 1);
        }
    }
}
class Solution410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
