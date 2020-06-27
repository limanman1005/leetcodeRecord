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
     * 解法很优雅。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        //处理一下边界条件
        if(nums == null || len < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; ++i){
            //这个是本题等于0的特殊判断
            if(nums[i] > 0){
                break;
            }
            //重复的数字去掉
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //找到左右边界
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                //找到一组值，继续向后搜索
                if(sum == 0){
                    //加入到答案里面
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //继续去重之后向左移
                    while(L < R && nums[L] == nums[L + 1]){
                        L++;
                    }
                    //去重之后向右移
                    while(L < R && nums[R] == nums[R - 1]){
                        R--;
                    }
                    //改变边界
                    L++;
                    R--;
                }
                //整个和比较的小。左边界移
                else if(sum < 0){
                    L++;
                }
                //整个和比较的打。右边界移
                else if(sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }
}