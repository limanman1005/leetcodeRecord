package explore.juniorAlgorithm.array;

/**
 * ClassName: RotateArray
 * Description: 旋转一维数组
 * date: 2020/5/25 11:14
 *
 * @author liyh
 */
public class RotateArray {
}
class Solution189 {
    public void rotate(int[] nums, int k) {
        if(nums ==  null || nums.length == 0 || nums.length == 1){
            return ;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0,  len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

