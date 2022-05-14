package offer.no08TreeHeapAndTrie;

import java.util.PriorityQueue;

/**
 * ClassName: Offer059
 * Description:
 * date: 4/5/2022 上午9:47
 *
 * @author liyh
 */
public class Offer059 {
}
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(minHeap.size() < size){
            minHeap.offer(val);
        }
        else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
