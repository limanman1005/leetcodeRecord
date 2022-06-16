package mySummary.array;

import java.util.HashMap;

/**
 * ClassName: ContiguousArray
 * Description:
 * date: 4/6/2022 下午4:41
 *
 * @author liyh
 */
public class ContiguousArray {
}
class Solution525{
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] pSum = new int[len + 1];
        //用了前缀和，且将数组中的0换成了-1
        for(int i = 1; i <= len; ++i){
            pSum[i] = pSum[i - 1] + (nums[i - 1] == 0? -1: 1);
        }
        int ans = 0;
        //记录出现最早的数值的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 2; i <= len; ++i){
            //将pSum的值都加入到map里面，且记录下最早出现的值
            if(!map.containsKey(pSum[i - 2])){
                map.put(pSum[i - 2], i - 2);
            }
            //判断下map里面有没有和当前pSum值相同的，有的话说明这段i到map里存的下标和为0
            //取出和ans比较一下即可
            if(map.containsKey(pSum[i])){
                ans = Math.max(ans, i - map.get(pSum[i]));
            }
        }
        return ans;
    }
}
