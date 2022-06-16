package mySummary.array;

import java.util.HashMap;

/**
 * ClassName: MaximunSizeSubarraySumEqualsK
 * Description:
 * date: 4/6/2022 下午4:57
 *
 * @author liyh
 */
public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        Solution325 solution325 = new Solution325();
        int[] arr = {1, -1, 5, -2, 3};
        int arrayLen = solution325.maxSubArrayLen(arr, 3);
        System.out.println("arrayLen = " + arrayLen);
    }
}
class Solution325{
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int[] pSum = new int[len + 1];
        for(int i = 1; i <= len; ++i){
            pSum[i] = pSum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        //记得初始化，这个0，0值，不包含任何数组的元素，从下标1的到i的话会用到这个值
        map.put(0, 0);
        for(int i = 1; i <= len; ++i){
            if(!map.containsKey(pSum[i])){
                map.put(pSum[i], i);
            }
            if(map.containsKey(pSum[i] - k)){
                ans = Math.max(ans, i - map.get(pSum[i] - k));
            }
        }
        return ans;
    }

}
