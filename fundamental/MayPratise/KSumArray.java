package MayPratise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: KSumArray
 * Description: 给一个数组和一个目标值，求出连续和为目标值的子数组个数。
 * date: 2020/5/15 9:44
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * @author liyh
 *
 * 这题提醒我们关于数组的一些东西，实在不行还有暴力枚举法可以使用
 *
 * 这题提醒我们为什么要使用前缀和数组。原本要求的是数组的一系列子数组的和。一般的想法就是把所有这些子数组的和统统求出来判断。这时候时间复杂度最小到O（n2）
 * 但是使用前缀和数组把问题转化为两数相加的问题了。preSum[i] + k == preSum[j + 1]。是否存在一个前缀和使得当前的前缀和和目标值相加的值相等。
 * 这时候使用两数相加时候的空间换时间方法。使用一个map存上这个前缀和出现的次数。（两数之和那道题存的是有没有）
 * 为了避免首先要计算出所有的前缀和。我们把计算出前缀和过程和判断的过程联合起来。首先计算当前下标的前缀和。然后判断下map有没有和它相差k的前缀和。
 * 如果有那么加上次数。如果没有更新当前的前缀和在map里面的次数。
 */
public class KSumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(new Solution560().subarraySum3(arr, 2));
    }
}
class Solution560 {

    /**
     * 纯暴力解法。枚举左右边界。如果和为k，那么答案值加一
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k){
        int len = nums.length;
        int count = 0;
        //这两重循环是在枚举所有的左右边界
        for(int left = 0; left < len; ++left){
            for(int right = left; right < len; ++right){
                int sum = 0;
                //这个循环把左右边界之间的值加起来
                for(int i = left; i <= right; ++i){
                    sum += nums[i];
                }
                //判断下需不需要更新sum里面的值
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 这个是对暴力解的一点优化。
     * 固定一下左边界，然后找右边界。
     * 每次更新sum的时候都要判断下sum是否等于k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k){
        int count = 0;
        int len = nums.length;
        //固定一个边界
        for(int left = 0; left < len; left++){
            int sum = 0;
            //取这个固定left边界之后的所有右边界，这里直接使用累加判断
            for(int right = left; right < len; right++){
                sum += nums[right];
                //相等直接更新答案
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 这个是使用了前缀和的思想，但是暂时还没有优化的思路。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k){
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        //这里初始化前缀和数组。表示求和数组下标[0, i]之间的和。
        //这里使用的细节就是pre[0]代表没有元素所以和为0
        //preSum[len]代表全部的和。
        for(int i = 0; i < len; ++i){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        //有了前缀和之后可以使用preSum[j + 1] - preSum[i]表示原数组[i, j]之前的和
        for(int left = 0; left < len; ++left){
            for(int right = left; right < len; ++right){
                if(preSum[right + 1] - preSum[left] == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 这个就是使用了map优化的一个方法。
     * 具体的思路就是在构造前缀和数组的时候把这个前缀和和这个前缀和出现的次数用一个map存起来。
     * 这样就不用每次都根据左右边界计算下满不满足条件。有点像两数之和的思路（由两个数之和，变换为一个数存在不存在，这时候使用map空间换时间）。
     * map.put(0, 1).代表着自己至少出现过1次。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum4(int[] nums, int k){
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; ++i){
            pre += nums[i];
            if(map.containsKey(pre  - k)){
                count += map.get(pre - k);
            }
            //这里不一定有pre。所以有了一个default的值
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;

    }



    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(128);
        //目标put这个0，1对意味着自己就是，这时候所对应的数目就是1。
        map.put(0, 1);
        int sum =0;
        int ans = 0;
        for(int i = 0; i<n; ++i){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}