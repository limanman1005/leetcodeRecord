package JunePractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LongestConsecutiveSequence
 * Description: 给一个非排序数组，找出这个数组中最长的连续数字的个数
 * 两种解法，一种是利用hashset，另一种是排序过后适用动规
 * date: 2020/6/6 11:41
 *
 * @author liyh
 */
public class LongestConsecutiveSequence {
}
class Solution128 {
    /**
     * 这个是hashset解法，从暴力解法中一步一步优化而来
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //首先将所有的数字都放到set里面。
        //为以后在常数时间内判断某个数是否存在
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        //将set里面的数组一个一个取出
        for(int num : set){
            //这个很关键，避免了无效的遍历。因为从num - 1开始的肯定要比从num开始的长
            if(!set.contains(num - 1)){
                int curLen = 1;
                int curNum = num;
                //这个遍历找出从num开始的连续子序列的长度
                while(set.contains(curNum + 1)){
                    curNum++;
                    curLen++;
                }
                ans = Math.max(curLen, ans);
            }
        }
        return ans;
    }


    /**
     * 这个是动规的解法。排序之后就符合之前做过的在排序数组中找到最长的子序列了。
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        int lenofNum = nums.length;
        if(lenofNum < 2){
            return lenofNum;
        }
        Arrays.sort(nums);
        int[] uniqueNums = Arrays.stream(nums).distinct().toArray();
        int lenOfUNum = uniqueNums.length;
        int[] dp = new int[lenOfUNum];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i<lenOfUNum; ++i){
            if(uniqueNums[i-1] + 1 == uniqueNums[i]){
                dp[i] = dp[i-1] + 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }


}
