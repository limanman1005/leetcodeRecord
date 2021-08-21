package explore.middleAlgorithm.SortAndSearch;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: KthLargestElementInArray
 * Description: 本题在六月的每日一题中做过，题号215
 * date: 2020/7/15 14:10
 *
 * @author liyh
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] arr ={3, 2, 1, 5, 6, 4};
        Solution215 solution215 = new Solution215();
        int kthLargest = solution215.findKthLargest(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
class Solution215 {
    private Random random = new Random(System.currentTimeMillis());

    /**
     * 再次写一份划分的怎么写。注意划分的思路
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(k <= 0 || k > nums.length){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums,  left, right);
        while(index != k - 1){
            if(index < k - 1){
                left = index + 1;
            }
            else if(index > k - 1){
                right = index - 1;
            }
            else{
                break;
            }
            index = partition(nums, left, right);
        }
        return nums[index];
    }

    private int partition(int[] nums, int left, int right){
        int mid = (left + right) >>> 1;
        swap(nums, left, mid);
        int pivot = nums[left];
        int lp = left + 1;
        int rp = right;
        while(lp <= rp){
            while(lp <= rp && nums[lp] >= pivot){
                lp++;
            }
            while(lp <= rp && nums[rp] < pivot){
                rp--;
            }
            if(lp < rp){
                swap(nums, lp, rp);
            }
        }
        //这里必须和rp交换
        swap(nums, left, rp);
        return rp;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
