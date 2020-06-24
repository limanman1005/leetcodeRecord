package JunePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Description: 给一个数组找到三个数相加等于特定数的和。
 * 步步优化的思路是值得学习的。怎么样保证不重复的。
 * 首先三重循环的暴力解法是最容易想到的，去重的话需要多写一个排序之后再加上判断，只使用重复元素中最左边的元素
 * 最后加上双指针减少时间复杂度。就得到了最后的优化思路了。
 * 值得注意的是当自己的时间复杂度超过O（n2）的时候就应该考虑能不能使用排序来优化了。
 * 最后值得一说的是还有进阶的4数之和，可以等下练习
 * date: 2020/6/12 9:57
 * @author liyh
 */
public class ThreeSum {
}
class Solution15 {
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; ++i){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]){
                        L++;
                    }
                    while(L < R && nums[R] == nums[R - 1]){
                        R--;
                    }
                    L++;
                    R--;
                }
                else if(sum < 0){
                    L++;
                }
                else if(sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }
}