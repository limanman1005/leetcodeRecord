package mySummary.Dp.bags;

/**
 * ClassName: LC474
 * Description: 0和1，本质上还是选一些数，存一些限制，求价值，个数，长度什么的
 * date: 2021/9/23 17:24
 *
 * @author liyh
 */
public class OneAndZero {
}
class Solution474 {
    /**
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp定义就为数组的长度，初始化为0.
        int[][] dp = new int[m + 1][n + 1];
        for(String str: strs){
            int oneNum = 0;
            int zeroNum = 0;
            for(char ch: str.toCharArray()){
                if(ch == '0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            for(int i = m; i >= zeroNum; --i){
                for(int j = n; j>= oneNum; --j){
                    //主要状态定义的动态转移方程
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

