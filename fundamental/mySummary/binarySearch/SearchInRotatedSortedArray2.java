package mySummary.binarySearch;

/**
 * ClassName: SearchInRotatedSortedArray2
 * Description:
 * date: 2021/10/6 16:10
 *
 * @author liyh
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        Solution81 solution81 = new Solution81();
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        boolean ans = solution81.search2(arr, 2);
        System.out.println(ans);
    }
}

class Solution81{

    /**
     * 判断有重复数字的旋转数组上存在不存在指定的值。
     * 面试题1003需要返回其下标
     * 此方法写的还是非常的清晰的
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //这里搜索闭区间
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target){
                return true;
            }
            //nums[mid]大于nums[left]，说明[left, mid]区间升序。
            else if(nums[left] < nums[mid]){
                //如果target在有序的左边，则舍弃右边，否则舍弃左边
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            //如果num[mid]小于nums[right]，说明[mid, right]区间升序
            else if(nums[mid] < nums[right]){
                //如果target在[mid, right]区间内，那么舍去mid的左边，否则舍去mid的右边
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            //这一步是有重复数字的关键，如果判断不出，那么意味着首尾有重复的数字，跳过这些数字即可
            else{
                while(left <= right && nums[mid] == nums[left]){
                    left++;
                }
                while(left <= right && nums[mid] == nums[right]){
                    right--;
                }
            }
        }
        return false;
    }


    public boolean search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target){
                return true;
            }
            while(left < mid && nums[left] == nums[mid]){
                left++;
            }
            //这里=号很重要，有可能出现left=mid，且nums[left] == nums[mid]，需要舍弃右边的
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

class Solution10_03{

}
