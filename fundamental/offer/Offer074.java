package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Offer074
 * Description:
 * date: 6/5/2022 下午4:43
 *
 * @author liyh
 */
public class Offer074 {
}
class SolutionOffer074And56{
    /**
     * 合并区间，在其他的题中也挺常见的
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while(i < intervals.length){
            int[] tmp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while(j < intervals.length && intervals[j][0] <= tmp[1]){
                tmp[1] = Math.max(tmp[1], intervals[j][1]);
                j++;
            }
            merged.add(tmp);
            i = j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}
