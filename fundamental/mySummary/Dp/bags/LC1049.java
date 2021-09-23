package mySummary.Dp.bags;

/**
 * ClassName: LC1049
 * Description:
 * date: 2021/9/23 16:27
 *
 * @author liyh
 */
public class LC1049 {
}
class Solution1049 {
    /**
     * 此题分割子集和差不多，找到一个背包大小为总重量一半的背包，能装下多大的容量。
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        if(stones == null || stones.length == 0){
            return -1;
        }
        int len = stones.length;
        int sum = 0;
        for(int weight : stones){
            sum += weight;
        }
        int target = sum/2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < len; ++i){
            for(int j = target; j >= stones[i]; --j){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //答案就是另一堆石子的重量减去当下计算容量的重量
        return (sum - dp[target]) - dp[target];
    }
}
