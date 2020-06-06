package JunePractice;

import java.util.Arrays;

/**
 * ClassName: ProductOfArrayExceptSelf
 * Description: 给一个数组，求出每一个数组中数字除了自己的其他数字乘积
 * 不要都乘起来再除，
 * 还有使用O（1）的方法
 * date: 2020/6/4 11:14
 *
 * @author liyh
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        int[] ints1 = new Solution238().productExceptSelf(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
class Solution238 {
    /**
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int len = nums.length;
        int[] lSum = new int[len];
        int[] rSum = new int[len];
        lSum[0] = 1;
        rSum[len - 1] = 1;
        int i = 1;
        int j = len - 2;
        while(i < len && j >= 0){
            //这里记得要和不是和nums[i]相乘
            lSum[i] = lSum[i - 1] * nums[i - 1];
            rSum[j] = rSum[j + 1] * nums[j + 1];
            i++;
            j--;
        }
        int[] ans = new int[len];
        for(int k = 0; k < len; ++k){
            ans[k] = lSum[k] * rSum[k];
        }
        return ans;
    }

    /**
     * 使用了常数空间的解法（答案的空间不算）
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            //细节这里要乘nums[i - 1]得到左边的乘积
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //从1开始使用一个tmp来保存右边的乘积来对答案数组进行下一步的操作。
        int tmp = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            ans[i] *= tmp;
            //这里细节使用了nums[i]
            tmp *= nums[i];
        }
        //最后返回ans即可
        return ans;
    }
}

