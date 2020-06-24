package juniorAlgorithm.sortandsearch;

/**
 * ClassName: MergeTwoSortedArray
 * Description: 给两个排好序的数组。把这两个数组合并成同一个
 * 合并两个链表的算法在list包里面
 * date: 2020/6/19 17:36
 * @author liyh
 */
public class MergeTwoSortedArray {
}
class Solution88 {
    /**
     * 使用三指针法从后向前即可。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p3] = nums1[p1];
                p1--;
            }
            else{
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }
        //如果是nums2没有走到头，那么需要把nums2的数据移到nums1上面
        while(p2 >= 0){
            nums1[p3--] = nums2[p2--];
        }
    }
}



