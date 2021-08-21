package mySummary.Dp;

import java.util.HashMap;

/**
 * ClassName: maxProduct
 * Description: 五月的每日一题。给一个数组，找出这个数组的一个子数组的乘积最大是多少
 * date: 2020/5/18 11:26
 *
 * @author liyh
 */
public class maxProduct {
    public static void main(String[] args) {
//        int[] arr = new int[]{-1, -2, -9, -6};
//        Solution152 solution152 = new Solution152();
//        System.out.println(solution152.maxProduct2(arr));
//        System.out.println("===============================");
//        System.out.println(solution152.maxProduct3(arr));
        String str = "";
        System.out.println(str.length());

    }
}

class Solution152 {
    /**
     * 状态依旧定义为以当前数组值为结尾的最大连续乘积和。
     * 如果不存在负数那么状态转移方程极其好写。一直乘，遇到零特判就是了。
     * 但是由于会存在负数，所以我们需要多维护一个前面乘积最小的结果。
     * 这样的话最大值就有了三个候选人取最大，自己本身，前一个最大值状态的值*当前的值，前一个状态最小的值*当前的值。
     * 当前状态的最小值也有三个候选人取最小，自己本身，前一个最小值状态的值*当前的值，前一个状态最大的值*当前的值。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        maxF[0] = minF[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            maxF[i] = Math.max(Math.max(maxF[i - 1] * nums[i], nums[i]), minF[i - 1] * nums[i]);
            minF[i] = Math.min(Math.min(minF[i - 1] * nums[i], nums[i]), maxF[i - 1] * nums[i]);
        }
        int ans = maxF[0];
        for(int i = 1; i  < nums.length; ++i){
            if(ans < maxF[i]){
                ans = maxF[i];
            }
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; ++i){
            int preMaxF = maxF;
            int preMinF = minF;
            maxF = Math.max(nums[i] * preMaxF, Math.max(nums[i], nums[i] * preMinF));
            minF = Math.min(nums[i] * preMinF, Math.min(nums[i], nums[i] * preMaxF));
            System.out.println("maxF = " + maxF +"    "+ "minF =" + minF);
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public int maxProduct3(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; ++i){
            int preMaxF = maxF;
            int preMinF = minF;
            maxF = Math.max(nums[i], Math.max(preMaxF * nums[i], preMinF * nums[i]));
            minF = Math.min(nums[i], Math.min(preMinF * nums[i], preMaxF * nums[i]));
            System.out.println("maxF = " + maxF + "    "+ "minF = " + minF);
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
