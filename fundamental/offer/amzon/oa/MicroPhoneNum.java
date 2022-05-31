package offer.amzon.oa;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * ClassName: MicroNum
 * Description:
 * date: 28/5/2022 上午10:16
 *
 * @author liyh
 */
public class MicroPhoneNum {
    public static void main(String[] args) {
//        int[] arr = {100, 80, 60, 40, 30};
        int[] arr = {3, 3, 3, 3};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2)->{
            return i2 - i1;
        });
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }
        for(int i = 0; i < 1; i++){
            Integer curMax = maxHeap.poll();
            if(curMax % 2 == 0){
                maxHeap.offer(curMax / 2);
                maxHeap.offer(curMax / 2);
            }
            else{
                maxHeap.offer(curMax / 2);
                maxHeap.offer(curMax / 2 + 1);
            }
        }
        System.out.println(maxHeap.poll());
    }
}
