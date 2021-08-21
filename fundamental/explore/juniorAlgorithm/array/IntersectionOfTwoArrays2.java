package explore.juniorAlgorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: IntersectionOfTwoArrays2
 * Description: 给两个数组，求出两个数组的交集，交集里面可以有重复元素
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * date: 2020/5/25 13:52
 *
 * @author liyh
 */
public class IntersectionOfTwoArrays2 {
}
class Solution350 {
    /**
     * 此处先排序后使用双指针法。对于已经拍过序的数组特别适合。
     * 这个有点像三指针了吧。同侧出发。
     * 这个真的特别的骚。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                ++i;
            }
            else if(nums1[i] > nums2[j]){
                ++j;
            }
            else{
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * 这里使用了hash表的解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        // if(nums1.length > nums2.length){
        //     return intersect(nums2, nums1);
        // }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for(int num : nums2){
            int cnt = map.getOrDefault(num, 0);
            if(cnt > 0){
                nums1[k++] = num;
                map.put(num, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
