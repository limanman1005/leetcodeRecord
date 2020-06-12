package juniorAlgorithm.array;

/**
 * ClassName: MoveZeroes
 * Description: 给一个数组，然后把特定得元素移到后面，并且不改变相对得位置。
 * 使用双指针法，这次得双指针法从同一侧出发
 * date: 2020/6/11 11:21
 *
 * @author liyh
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes2(new int[]{1, 2, 0, 3});
    }
}
class Solution283 {
    /**
     * 同侧双指针法。可保留相对位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return ;
        }
        int left = 0;
        int right = 0;
        int len = nums.length;
        while(right < len){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while(left < len){
            nums[left++] = 0;
        }
        return ;

    }

    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return ;
        }
        int left = 0;
        int right = 0;
        int len = nums.length;
        while(right < len){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
                right++;
            }
            else{
                right++;
            }
        }
        while(left < len){
            nums[left++] = 1;
        }
        return ;
    }
}
