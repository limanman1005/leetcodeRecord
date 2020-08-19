package Dp;

/**
 * ClassName: LowestTicketPrice
 * Description:
 * date: 2020/5/6 11:09
 *
 * @author liyh
 */
public class LowestTicketPrice {
}

class Solution983 {
    /**
     * dp算法的思维方式没有掌握，暂时留个坑，以后再说
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int n = days[len-1];
        int[] dp = new int[n+1];
        int a, b, c;
        for(int i = 0; i < len; ++i){
            dp[days[i]] = -1;
        }
        for(int i = 1; i <= n; ++i){
            if(dp[i] == 0){
                dp[i] = dp[i-1];
            }
            else{
                a = dp[i-1] + costs[0];
                if(i-7 >= 0){
                    b = dp[i-7] + costs[1];
                }
                else{
                    b = costs[1];
                }
                if(i-30 >= 0){
                    c = dp[i-30] + costs[2];
                }
                else{
                    c = costs[2];
                }
                dp[i] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[n];
    }
}
