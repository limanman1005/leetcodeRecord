package Dp;

import java.util.Arrays;

/**
 * ClassName: LISNum
 * Description: 找到最长上升子序列的个数
 * date: 2020/9/21 9:52
 *
 * @author liyh
 */
public class LISNum {
}
class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len+1];
        int[] com = new int[len+1];
        int maxLen = 1;
        Arrays.fill(lis, 1);
        Arrays.fill(com, 1);
        for(int i = 1; i<=len; ++i){
            for(int j = 1; j<i; ++j){
                if(nums[i-1] > nums[j-1]){
                    if(lis[i] < lis[j] + 1){
                        lis[i] = lis[j] +1;
                        com[i] = com[j];
                    }
                    //关键就在这个com数组里面，如果当前最长的在之前已经有了，那么需要累加上。
                    //com数组里面就是以当前i结尾的最长上升子序列的个数
                    //https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/qiu-zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-qiyue/
                    //上面那篇题解说的很明白
                    else if(lis[i] == lis[j]+1){
                        com[i] += com[j];
                    }
                }
            }
            if(maxLen < lis[i]){
                maxLen = lis[i];
            }
        }
        int count = 0;
        for(int i = 1; i<=len; ++i){
            if(maxLen == lis[i]){
                count += com[i];
            }
        }
        return count;
    }
}
