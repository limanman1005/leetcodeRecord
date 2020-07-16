package middleAlgorithm.SortAndSearch;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * ClassName: TopKFrequentElement
 * Description:最经典的就是堆排序。桶排序暂略吧
 * date: 2020/7/15 13:31
 *
 * @author liyh
 */
public class TopKFrequentElement {
}
class Solution347 {
    /**
     * 使用堆的解法。
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        //使用hashmap记录数值和频率的对应关系
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        //使用小顶堆来存上最大的频率最大的几个数。这样小顶堆的最小的值就是最小的Kth值了。
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        //遍历key将数放进堆中
        for(Integer key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        //返回一个数组
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i){
            ans[i] = pq.remove();
        }
        return ans;
    }
}
