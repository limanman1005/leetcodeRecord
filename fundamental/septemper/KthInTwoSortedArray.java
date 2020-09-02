package septemper;

/**
 * ClassName: KthInTwoSortedArray
 * Description:
 * date: 2020/9/1 14:01
 *
 * @author liyh
 */
public class KthInTwoSortedArray {
}
class Solution4 {
    /**
     * 这个方法是getkth的思路。每次把一个数组过掉不可能的一半。直到找到答案。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //如果两个数组的长度和是偶数，那么需要算两个数求中间值
        //如果是奇数，两个数是一样的
        int oddSituation = (n + m + 1) / 2;
        int evenSituation = (n + m + 2) /2;
        //偶数和奇数都算一遍
        int ans = getKth(nums1, 0, n - 1, nums2, 0, m - 1, oddSituation) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, evenSituation);
        return ans / 2.0;
    }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        //边界情况
        if(len1 == 0){
            return nums2[start2 + k - 1];
        }
        //边界情况
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        //计算舍弃掉k/2元素后两个数组的信息
        int i  = start1 + Math.min(len1 , k / 2) - 1;
        int j = start2 + Math.min(len2, k /2) - 1;
        if(nums1[i] > nums2[j]){
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else{
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1+ 1));
        }
    }
}