package septemper;

import java.lang.management.ManagementFactory;

/**
 * ClassName: KthInTwoSortedArray
 * Description:
 * date: 2020/9/1 14:01
 *
 * @author liyh
 */
public class KthInTwoSortedArray {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int i = solution04.sampleKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, 3);
        double medianSortedArrays = solution04.getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, 3);
        System.out.println(i);
        System.out.println(medianSortedArrays);
    }
}
class Solution04 {
    /**
     * 这个方法是getkth的思路。每次把一个数组过掉不可能的一半。直到找到答案。
     *
     * @param nums1
     * @param i
     * @param i1
     * @param nums2
     * @param i2
     * @param i3
     * @param i4
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int i, int i1, int[] nums2, int i2, int i3, int i4) {
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
    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
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



    public int sampleKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int curLen1 = end1 - start1 + 1;
        int curLen2 = end2 - start2 + 1;
        if(curLen1 > curLen2){
            return sampleKth(nums2, start2, end2, nums1, start1, end2, k);
        }
        if(curLen1 == 0){
            return nums2[start2 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(curLen1, k / 2) - 1;
        int j = start2 + Math.min(curLen2, k / 2) - 1;

        if(nums1[i] < nums2[j]){
            return sampleKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
        else{
            return sampleKth(nums1, start1, end1, nums2, j + 1, end2, k -(j - start2 + 1));
        }
    }























}
