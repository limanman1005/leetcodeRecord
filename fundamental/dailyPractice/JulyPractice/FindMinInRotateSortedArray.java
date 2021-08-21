package dailyPractice.JulyPractice;

/**
 * ClassName: FindMinInRotateSortedArray
 * Description: 找到排好序的数组，又旋转过之后的最小值。这个有重复的元素
 * 此题还有重复，lc153题不含重复的
 * date: 2020/7/22 11:08
 *
 * @author liyh
 */
public class FindMinInRotateSortedArray {
}
class Solution154 {
    /**
     * 二分法，找准mid和right的关系。
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (left + right)>>>1;
            //如果mid比right大说明最小值在右半部分
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            //如果mid比right小说明最小值在左半部分
            else if(nums[mid] < nums[right]){
                right = mid;
            }
            //如果相等，则可以排除右边的一个元素
            else{
                right--;
            }
        }
        return nums[left];
    }
}
