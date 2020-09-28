package JulyPractice;

/**
 * ClassName: MagicIndex
 * Description: 给一个数组找到下标和数组里面的值相对应的最小值
 * date: 2020/7/31 11:41
 *
 * @author liyh
 */
public class MagicIndex {
    public static void main(String[] args) {
        Solution08_03 solution08_03 = new Solution08_03();
        int[] arr = {1, 1, 1};
        System.out.println(solution08_03.findMagicIndex(arr));
    }
}

class Solution08_03 {
    public int findMagicIndex(int[] nums) {
        //todo 还有一些其他的解法，等着分析一波吧。
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) >>> 1;
        int leftAnswer = helper(nums, left, mid - 1);
        if(leftAnswer  != -1){
            return leftAnswer;
        }
        else if(nums[mid] == mid){
            return mid;
        }
        return helper(nums, mid + 1, right);
    }
}
