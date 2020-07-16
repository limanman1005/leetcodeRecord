package middleAlgorithm.SortAndSearch;

import java.util.Arrays;

/**
 * ClassName: MergeIntervals
 * Description: 合并区间，给一些数组表示的区间，把有区间合并的可能的区间合并掉
 * 思路就是先排序使得开始的区间始终小于结束的区间。然后剩下的情况就十分的好写了。
 * date: 2020/7/16 11:03
 *
 * @author liyh
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] ints = Arrays.copyOf(arr, 2);
        System.out.println(Arrays.toString(ints));
    }

}
class Solution56 {
    /**
     * 先排序，后合并。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //首先按照区间的开头排下序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] ans = new int[intervals.length][2];
        int idx = -1;
        //遍历每一个区间
        for(int[] interval: intervals){
            //跳过第一个区间直接放入ans里面
            //或者判断下如果当前的区间开头比上一个区间的节位要大，那么答案的区间个数就要加1了
            if(idx == -1 || interval[0] > ans[idx][1]){
                ans[++idx] = interval;
            }
            //否则，则可以合并到上一个区间里。
            else{
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            }
        }
        //copy一份结果
        return Arrays.copyOf(ans, idx + 1);
    }
}

