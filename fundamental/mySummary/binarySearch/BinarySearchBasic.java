package mySummary.binarySearch;

/**
 * ClassName: BinarySearchBasic
 * Description: 根据leetcode加加的讲义总结的题
 * date: 2021/9/24 17:00
 *
 * @author liyh
 */
public class BinarySearchBasic {
}
class SolutionBinarySearch{

    /**
     * 查找元素是否在数组中的问题，数组中数字唯一。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            //排除左区间
            if(nums[mid] > target){
                left = mid + 1;
            }
            //排除右区间
            else if(nums[mid] < target){
                right = mid - 1;
            }
            //找到了直接返回
            else{
                return mid;
            }
        }
        return -1;
    }


    /**
     * 找到一个数组中最左边符合条件的值
     * @param nums
     * @param target
     * @return
     */
    public int findLowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        //写等号可能会出现死循环的
        while(left < right){
            int mid = (left + right) >>> 1;
            //这里碰到符合条件的不能直接返回，需要再向左搜索
            if(target == nums[mid]){
                right = mid;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        //还有一个元素没有找，判断下符合不符合条件
        return nums[left] == target? left: -1;
    }

    /**
     * 找数组中符合条件的最右边的位置
     * @param nums
     * @param target
     * @return
     */
    public int findUpperBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            //因为计算机向下取整，所以这里必须向上取整才不会陷入死循环。
            int mid = (right + left + 1) >>> 1;
            //碰到符合条件的不能直接返回需要继续向右搜索才可以
            if(target == nums[mid]){
                left = mid;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        //最后一个元素判断一下
        return nums[left] == target? left: -1;
    }
}
