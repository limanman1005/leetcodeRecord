package binarySearch;



/** * ClassName: Lc35
 * Description: 在一个有序数组里面找到要插入数字的位置。如果存在这个数返回这个数的下标。
 * date: 2020/4/20 11:10
 *
 * @author liyh
 */
public class Lc35 {

    /**
     * 第一种解法。
     * 这里是减治做法
     * 关键是怎么减小区间
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        //首先应该想到解空间是多大。
        //这里是特判。把len这个位置给排除了
        if(nums[len - 1] < target){
            return len;
        }
        int left = 0;
        int right = len - 1;
        //这里使用减治法
        while(left < right){
            int mid = (left + right) >>> 1;
            //这里nums[mid]<target的时候左边要舍弃掉
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        //这个返回一定是比原数大的一个位置。
        return left;
    }


    /**
     * 第二种解法，把len也作为了搜索的区域。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int left = 0;
        //因为在等于len的时候不用检查，所以这里可以把len纳入范围当中。
        int right = len;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Lc35 lc35 = new Lc35();
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 7;
        System.out.println(lc35.searchInsert2(arr, target));
    }
}
