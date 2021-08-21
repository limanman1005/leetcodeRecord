package mySummary.binarySearch;

/**
 * ClassName: Lc33
 * Description: 搜索旋转数组
 * date: 2020/4/20 14:48
 *
 * @author liyh
 */
@Deprecated
public class Lc33 {
}
class Solution33 {

    /**
     * 这个按照liweiwei的解法但是写出来，并且理解了。其实其他写解法也可以看一看。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if(nums[mid] < nums[right]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                if(nums[left] <= target && target <= nums[mid - 1]){
                    right  = mid - 1;
                }
                else{
                    left = mid;
                }
            }
        }
        return nums[left] == target? left: -1;
    }


    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            //左边有序
            if(nums[left] <= nums[mid]){
                //左边有序并且在左边
                if(target < nums[mid] && target >= nums[left]){
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
        return -1;
    }
}
