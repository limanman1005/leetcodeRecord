package explore.microsoft.arrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SumOfTwoSum
 * Description: 这个是微软的考题，下面写有编辑推荐，LC第一题
 * date: 2020/7/29 11:23
 *
 * @author liyh
 */
public class SumOfTwoSum {
}

class Solution01 {
    /**
     * 这个是一次遍历map的写法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 这里应有暴力的解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        return null;
    }

    /**
     * 这个排序之后使用二分查找。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        return null;
    }
}
