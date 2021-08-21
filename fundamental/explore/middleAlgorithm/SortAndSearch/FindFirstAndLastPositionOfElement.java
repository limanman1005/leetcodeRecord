package explore.middleAlgorithm.SortAndSearch;

/**
 * ClassName: FindFirstAndLastPositionOfElement
 * Description: 此题题号在34，在二分查找那章已经做过了。
 * date: 2020/7/15 17:17
 *
 * @author liyh
 */
public class FindFirstAndLastPositionOfElement {
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if(nums == null || nums.length  == 0){
            return ans;
        }
        ans[0] = findLowerBound(nums, target);
        if(ans[0] == -1){
            return ans;
        }
        ans[1] = findUpperBound(nums, target);
        return ans;
    }
    private int findLowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                right = mid;
            }
        }
        return target == nums[left]? left : -1;
    }
    private int findUpperBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left +right + 1) >>> 1;
            if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                //只要这个存在就必须在取mid的时候偏左一点，以便可以结束循环
                left = mid;
            }
        }
        return target == nums[left]? left : -1;
    }
}
