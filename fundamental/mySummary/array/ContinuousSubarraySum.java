package mySummary.array;

import java.util.HashSet;

/**
 * ClassName: ContinuousSubarraySum
 * Description:
 * date: 4/6/2022 下午4:30
 *
 * @author liyh
 */
public class ContinuousSubarraySum {
}
class Solution523{
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        int[] pSum = new int[len + 1];
        for(int i = 1; i <= len; ++i){
            pSum[i] = pSum[i - 1] + nums[i - 1];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 2; i <= len; ++i){
            set.add(pSum[i - 2] % k);
            if(set.contains(pSum[i] % k)){
                return true;
            }
        }
        return false;
    }
}
