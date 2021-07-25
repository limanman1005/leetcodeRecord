package septemper;

/**
 * ClassName: Debug
 * Description:
 * date: 2021/7/22 16:06
 *
 * @author liyh
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,};
        int[] nums2 = {2, 3};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int oddKth = (len1 + len2 + 1) / 2;
        int evenKth = (len1 + len2 + 2) / 2;
        int odd = getKth0725(nums1, 0, len1 - 1, nums2, 0, len2 - 1, oddKth);
        int even = getKth0725(nums1, 0, len1 - 1, nums2, 0, len2 - 1, evenKth);
        double ans = (odd + even) / 2.0;
        return ans ;
    }

    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int kth){
        int curlen1 = end1 - start1 + 1;
        int curlen2 = end2 - start2 + 1;
        if(curlen1 > curlen2){
            return getKth(nums2, start2, end2, nums1, start1, end1, kth);
        }
        if(curlen1 == 0){
            return nums2[start2 + kth - 1];
        }
        if(kth == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(curlen1, kth / 2) - 1;
        int j = start2 + Math.min(curlen2, kth / 2) - 1;
        if(nums1[i] < nums2[j]){
            return getKth(nums1, i + 1, end1, nums2, start2, end2, kth - (i - start1 + 1));
        }
        else{
            return getKth(nums1, start1, end1, nums2, j + 1, end2, kth - (j - start2 + 1));
        }
    }

    public int getKth2(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int kth){
        int curLen1 = end1 - start1 + 1;
        int curLen2 = end2 - start2 + 1;
        if(curLen1 > curLen2){
            return getKth2(nums2, start2, end2, nums1, start1, end1, kth);
        }
        if(curLen1 == 0){
            return nums2[start2 + kth - 1];
        }
        if(kth == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(curLen1, kth / 2) - 1;
        int j = start2 + Math.min(curLen2, kth / 2) - 1;
        if(nums1[i] < nums2[j]){
            return getKth2(nums1, i + 1, end1, nums2, start2, end2, kth - (i - start1 + 1));
        }
        else{
            return getKth2(nums1, start1, end1, nums2, j + 1, end2, kth- (j - start2 + 1));
        }
    }



    public int getKth3(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int kth){
        int curLen1 = end1 - start1 + 1;
        int curLen2 = end2 - start2 + 1;
        if(curLen1 > curLen2){
            return getKth3(nums2, start2, end2, nums1, start1, end1, kth);
        }
        if(curLen1 == 0){
            return nums2[start2 + kth - 1];
        }
        if(kth == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(curLen1, kth / 2) - 1;
        int j = start2 + Math.min(curLen2, kth / 2) - 1;
        if(nums1[i] < nums2[j]){
            return getKth3(nums1, i + 1, end1, nums2, start2, end2, kth - (i - start1  + 1));
        }
        else{
            return getKth3(nums1, start1, end1, nums2, j + 1, end2, kth - (j - start2 + 1));
        }
    }


    public int getKth0725(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int kth){
        int curLen1 = end1 - start1 + 1;
        int curLen2 = end2 - start2 + 1;
        if(curLen1 > curLen2){
            return getKth0725(nums2, start2, end2, nums1, start1, end1, kth);
        }
        if(curLen1 == 0){
            return nums2[start2 + kth - 1];
        }
        if(kth == 1){
            Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(curLen1, kth / 2) - 1;
        int j = start2 + Math.min(curLen2, kth / 2) - 1;
        if(nums1[i] < nums2[j]){
            return getKth0725(nums1, i + 1, end1, nums2, start2, end2, kth- (i - start1 + 1));
        }
        else{
            return getKth0725(nums1, start1, end1, nums2, j + 1, end2, kth- (j - start2 + 1));
        }
    }













}
