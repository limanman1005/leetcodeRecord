package mySummary.binarySearch;

/**
 * ClassName: Lc89
 * Description: 在旋转数组里面找值，这个有重复元素。
 * 重复元素造成的问题就是不能判断哪边有序，这时候把左边界往上加就是了
 * date: 2020/4/21 23:32
 *
 * @author liyh
 */
public class Lc89 {
}

class Solution89{
    public boolean search1(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return true;
            }
            //这个就是解决办法，有重复的数字的时候，把这个重复数字跳开。这样才能判断左边有序还是右边有序
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }
            //左边有序
            if(nums[left] < nums[mid]){
                //左边有序并且在左边
                if(nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }
                //左边有序在右边
                else{
                    left = mid + 1;
                }
            }
            //右边有序
            else{
                //右边有序在右边
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                //右边有序在左边
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
