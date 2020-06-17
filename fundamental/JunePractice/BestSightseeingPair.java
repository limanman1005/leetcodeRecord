package JunePractice;

/**
 * ClassName: BestSightseeingPair
 * Description: 给一个数组，找到arr[i] + arr[j] + i - j最大的值
 * date: 2020/6/17 9:46
 *
 * @author liyh
 */
public class BestSightseeingPair {
}


class Solution1014 {
    /**
     * 这道题的思路是在遍历的时候从后向前考虑。即固定j向前考虑i。这样的话
     * arr[j] - j是不变的。要得到最大值必须要维护arr[i] + i的值。
     * 但是我感觉这题的思路不好想啊。
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }


    //贪心  by：bennue
//如果A[j] + j >= A[i] + i (j是i之后第一个满足这个条件的)，那么i只需要处理(i + 1, j)这些位置
//因为j之后的以j为起点处理，得到一定大于等于从i处理，因为A[j] + j + A[k] - k >= A[i] + i + A[k] - k
//而[i,j]之间的都没必要作为起点，因为j是第一个满足条件的，那么中间任意k，A[k] + k < A[i] + i，所以同上一定小于从i开始
//这样通过这个条件，我们可以将数组分成一段一段的，每段只用第一个与后面的进行计算，这样时间复杂度是O(n)
//每一段遍历第二个景点时，同样可以通过条件跳过一些景点

    /**
     * 记录一下答案里面的贪心算法
     * 翻译成我的话就是找到使得arr[i] + i不断增加的那些点，然后以这些点为分界点，将数组分成一段一段的。进行计算
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair2(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i] + i;
            int lastR = i + 1;
            for (int j = i + 1; j < A.length; j++) {
                if (j > lastR && A[j] + j <= A[lastR] + lastR) {
                    //这里判断一下，跳过不比计算的点
                    continue;
                }
                lastR = j;
                max = Math.max(max, tmp + A[j] - j);
                if (A[j] + j >= tmp) {
                    //j符合条件，退出循环，从j继续
                    i = j - 1;
                    break;
                }
            }
        }
        return max;
    }

}

