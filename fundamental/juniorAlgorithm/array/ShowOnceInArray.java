package juniorAlgorithm.array;

/**
 * ClassName: ShowOnceInArray
 * Description:数组里面的只有一个数字出现了一次，剩下的都出现了两次
 * date: 2020/5/25 11:29
 *
 * @author liyh
 */
public class ShowOnceInArray {
}
class Solution136 {
    /**
     * 这个就是个技巧题，利用了异或运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; ++i){
            ans ^= nums[i];
        }
        return ans;
    }
}
