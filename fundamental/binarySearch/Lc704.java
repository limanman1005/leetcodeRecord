package binarySearch;

/**
 * ClassName: Lc704
 * Description: 标准的二分查找
 * date: 2020/4/20 11:50
 *
 * @author liyh
 */
public class Lc704 {

    /**
     * 标准的二分查找解法，按照减治区间做的。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left] == target? left: -1;
    }
}
