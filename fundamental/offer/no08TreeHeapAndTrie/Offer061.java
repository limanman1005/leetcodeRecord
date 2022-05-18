package offer.no08TreeHeapAndTrie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ClassName: Offer061
 * Description:
 * date: 4/5/2022 上午11:30
 * 此题非常有意思，可以最小堆或者最大堆解。
 * 反复练习可以掌握使用最小堆和最大堆的核心本质。记住是一个挺不错的题。
 * @author liyh
 */
public class Offer061 {
    public static void main(String[] args) {
        SolutionOffer061And373 solutionOffer061And373 = new SolutionOffer061And373();
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> lists = solutionOffer061And373.kSmallestPairs(nums1, nums2, 10);
        System.out.println("111");
    }
}
class SolutionOffer061And373 {
    //对于各种情况的讨论，循环终止之后会面临什么情况还是要多留意
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (list1, list2) -> list1.get(0) + list1.get(1) - list2.get(0) - list2.get(1)
        );
        List<List<Integer>> ans = new ArrayList<>();
        a: for(int i = 0; i < nums1.length; ++i){
            for(int j = 0; j < k && j < nums2.length; ++j){
                List<Integer> numPair = new ArrayList<>();
                numPair.add(nums1[i]);
                numPair.add(nums2[j]);
                minHeap.offer(numPair);
            }
            ans.add(minHeap.poll());
            if(ans.size() == k){
                break;
            }
        }
        if(ans.size() < k){
            while(!minHeap.isEmpty()){
                ans.add(minHeap.poll());
                if(ans.size() == k){
                    break;
                }
            }
        }
        return ans;
    }
}
