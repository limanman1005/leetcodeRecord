package offer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * ClassName: Offer060
 * Description:
 * date: 4/5/2022 上午9:56
 *
 * @author liyh
 */
public class Offer060 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        int[] nums = {1, 2, 3, 4, 1, 1, 1,2, 2, 3};
        for(int num : nums){
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());


    }
}
class SolutionOffer060{
    /**
     * 记得利用map的Entry就可以了
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        for(int num : nums){
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer, Integer> entry : numToCount.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }
            else{
                if(entry.getValue() > minHeap.peek().getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i){
            //最小堆第一个是频率排在k的，最后poll的才是第一个，这里做下反转。
            ans[k - i - 1] = minHeap.poll().getKey();
        }
        return ans;
    }
}
