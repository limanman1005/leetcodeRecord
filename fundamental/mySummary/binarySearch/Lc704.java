package mySummary.binarySearch;

/**
 * ClassName: Lc704
 * Description: 标准的二分查找
 * date: 2020/4/20 11:50
 *
 * @author liyh
 */
public class Lc704 {


    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int i = solution704.search3(arr, 9);
        System.out.println(i);
    }

}

class Solution704{
    public int search3(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] > target){
                left = mid + 1;
            }
            else if(nums[mid] < target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


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
        //减治区间做的
        while(left < right){
            int mid = (left + right) >>> 1;
            //相等直接返回
            if(target == nums[mid]){
                return mid;
            }
            //大于搜索右边空间
            else if(target > nums[mid]){
                left = mid + 1;
            }
            //小于搜索左边空间
            else{
                right = mid -1;
            }
        }
        //退出的时候还有一个元素没有判断
        return left;
//        return nums[left] == target? left: -1;
    }

    /**
     * 使用了<=符号的区间，搜索整个空间
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        //这个条件会遍历所有的空间
        while(left <= right){
            //取中间数的时候，由于左右都会加一或者减一，一定不会出现死循环，mid的选取方式任意
            int mid = (left + right) >>> 1;
            //在右边
            if(target > nums[mid]){
                left = mid + 1;
            }
            //在左边
            else if(target < nums[mid]){
                right = mid - 1;
            }
            //找到了直接返回
            else{
                return mid;
            }
        }
        //如果返回left代表在左边有多少个元素
        return left;
    }
}
