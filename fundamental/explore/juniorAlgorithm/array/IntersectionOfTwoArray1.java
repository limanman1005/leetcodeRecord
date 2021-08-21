package explore.juniorAlgorithm.array;

import java.util.HashSet;

/**
 * ClassName: IntersectionOfTwoArray1
 * Description: 求两个数组的交集
 * date: 2020/5/25 13:10
 *
 * @author liyh
 */
public class IntersectionOfTwoArray1 {
}
class Solution349 {
    /**
     * 这题使用了set辅助，也可以使用双指针，这里就不写了。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        for(int n : nums2){
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int idx = 0;
        for(int num : set1){
            ans[idx++] = num;
        }
        return ans;
    }
}
