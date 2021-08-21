package explore.middleAlgorithm.SortAndSearch;

/**
 * ClassName: FindPeakElement
 * Description: 给一个数组，找到数组中的峰值。即大于左右相邻的值。
 * date: 2020/7/15 16:21
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * @author liyh
 */
public class FindPeakElement {
}
class Solution162 {
    /**
     * 这个是线性扫描法，这个是把各种情况都全部分析了的。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * 二分法。因为左右都有负无穷。
     * 而相邻的元素肯定有大小之分，这样的话，沿着大的走，肯定会找到一个数值的
     * 这个二分不再一个排好序的数组上进行，也不是明显有的在一个数据范围内找，有点意思的。
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
