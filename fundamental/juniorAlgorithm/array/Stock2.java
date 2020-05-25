package juniorAlgorithm.array;

/**
 * ClassName: Stock2
 * Description:买卖股票的第二题
 * date: 2020/5/25 10:52
 *
 * @author liyh
 */
public class Stock2 {
    public static void main(String[] args) {
        int[] ints = new int[0];
        System.out.println(ints.length);
    }
}
class Solution {
    /**
     * 由于我们每一天的股票价钱都已知了，我们遇到这一天上涨的直接买就好了。连续涨我们就连续买，
     * 并且直接把利润加到ans里面就好。
     * 很直观
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 1; i < len; ++i){
            int curProfit = prices[i] - prices[i - 1];
            //如果遇到上涨的情况就假想我们已经买了
            if(curProfit > 0){
                ans += curProfit;
            }
        }
        return ans;
    }
}
