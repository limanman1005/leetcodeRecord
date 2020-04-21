package binarySearch;

/**
 * ClassName: Lc35
 * Description: 在一个有序数组里面找到要插入数字的位置。如果存在这个数返回这个数的下标。
 * date: 2020/4/20 11:10
 *
 * @author liyh
 */
public class Lc35 {

    /**
     * 第一种解法。
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
        if(nums[len - 1] < target){
            return len;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            //这里nums[mid]<target的时候一定不是解。
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        //肯定有答案，所以直接返回
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
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Lc35 lc35 = new Lc35();
        int[] arr = new int[]{1, 3, 4, 5};
        int target = 5;
        lc35.searchInsert(arr, target);
    }
}
