package dailyPractice.JunePractice;

import java.util.Arrays;

/**
 * ClassName: MinimumSizeSubarraySum
 * Description: 给一个数组和一个目标值。找到数组里面的子数组的长度最小的那个长度
 * date: 2020/6/29 14:52
 *
 * @author liyh
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2,  4, 5, 6, 7, 8};
        int i = Arrays.binarySearch(arr, 9);
        System.out.println("i = " + i);
    }
}
class Solution209 {
    /**
     * 暴力解法，枚举每一个子数组
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 使用了前缀和和二分查找的方法时间复杂度降为O(nlog(n))
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        //由于都是正数，前缀和肯定是递增的。可以使用二分查找
        for(int i = 1; i <= n; ++i){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 1; i <= n; ++i){
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            //这个需要调试一下试试看
            if(bound < 0){
                bound = -bound - 1;
            }
            if(bound <= n){
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 双指针写法
     * 两个指针同侧出发，首先end加大于sum记录下长度，然后start向后移，直到sum < target。
     * end再移，重复直到end走到了数组末尾
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while(end < n){
            sum += nums[end];
            while(sum >= s){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE? 0: ans;
    }
}
