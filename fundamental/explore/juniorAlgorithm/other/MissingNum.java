package explore.juniorAlgorithm.other;

/**
 * ClassName: MissingNum
 * Description: 给一个数组，数组的大小是n，里面的数字的范围是0到n，找到0到n中缺失的一个数
 * date: 2020/6/25 15:44
 * 排序和hash就不说了。
 * @author liyh
 */
public class MissingNum {
}

class Solution268 {
    /**
     * 使用位运算，自己与自己异或运算等于0。利用这个性质进行两次异或运算得到答案
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        for(int i = 0; i <= nums.length; ++i){
            ans ^= i;
        }
        return ans;
    }


    /**
     * 位运算还可以写成这个样子
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        //这个初始一定要是这个东西
        int missing = nums.length;
        //这个从形式上乘上了0到len和数组里面的数字
        for(int i = 0; i < nums.length; ++i){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
