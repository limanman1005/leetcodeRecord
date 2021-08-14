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
                    //该条件是不可以省略的，会有其他情况出现，例如lis[i] > lis[j]的情况出现，此时不应做处理的
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
