package mySummary.Dp.lis;

import java.util.Arrays;

/**
 * ClassName: LC435
 * Description: 此题可转化为最长上升子序列的题。
 * 如何想到转化的，就是上升的时候有规律。
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * date: 2021/9/14 10:15
 *
 * @author liyh
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int[][] arr = {{1,2}, {2, 3}};
        int i = solution435.eraseOverlapIntervals(arr);
        System.out.println(i);
    }
}

class Solution435 {
    /**
     * 这个解法超时了，但是思路是对的。++上面的排序之后提前结束了循环。好像能够。
     * 更有的算法是贪心。
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return -1;
        }
        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        //按照数组的第一个元素进行升序排序。
        Arrays.sort(intervals, (o1, o2)-> o1[0] - o2[0]);
        int k = 1;
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                if(intervals[i][0] >= intervals[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    k = Math.max(dp[i], k);
                    //事先进行了排序，因此倒着找一定会最先找到最大的。
                    //现在的测试用例不倒着会超时
                    break;
                }
            }
        }
        return len - k;
    }
}
