package JunePractice;

import java.util.Arrays;

/**
 * ClassName: ClosestThreeNumSum
 * Description: 给定一个数，找到一个数组里面三个数的和最接近给定的数。
 * 这道题和三数之和（solution15）思路基本一致。使用排序加双指针的算法
 * date: 2020/6/24 11:14
 *
 * @author liyh
 */
public class ClosestThreeNumSum {
}

class Solution16 {
    /**
     * 排序加双指针的标准思路
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //假定一个答案
        int ans = nums[0] + nums[1] + nums[2];
        //然后开始枚举
        for(int i = 0; i < nums.length; ++i){
            //确定首尾边界
            int start = i + 1;
            int end = nums.length - 1;
            //根据排序的信息找到一个最接近的三数之和
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                //判断下当前是否比目前记录的更加接近target
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target){
                    end--;
                }
                else if(sum < target){
                    start++;
                }
                else{
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * 这里提供一个优化的写法
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        for(int i = 0; i < n; ++i){
            //这个就是第一个数重复的时候就可以跳过啊
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //确定首位边界
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if(sum > target){
                    int k0 = k - 1;
                    //这个也是跳过重复的数字
                    while(j < k0 && nums[k0] == nums[k]){
                        --k0;
                    }
                    k = k0;
                }
                else{
                    int j0 = j + 1;
                    //跳过重复的数字
                    while(j0 < k && nums[j0] == nums[j]){
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
