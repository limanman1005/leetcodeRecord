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
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = (left + right) >>> 1;
        while(left < right){
            if(nums[mid] == mid){
                right = mid;
            }
            else if(nums[mid] < mid){
                left = mid + 1;
            }
            else{
                right = mid;
            }
            mid = (left + right) >>> 1;
        }
        return left;
    }
}
