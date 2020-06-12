package juniorAlgorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoNumSum
 * Description: 两数之和，lc第一题。给一个数组和一个特定的数，在数组里面找一下有没有两个数之和和给定的数相等的。
 * 首先暴力法，然后hashmap法两次遍历法，一次遍历法， 排序后二分查找法。
 * date: 2020/6/11 11:35
 *
 * @author liyh
 */
public class TwoNumSum {
}

class Solution1 {
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

