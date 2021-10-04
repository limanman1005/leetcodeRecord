package mySummary.Dp;

/**
 * ClassName: DecodeWays
 * Description:
 * date: 2021/10/4 23:41
 *
 * @author liyh
 */
public class DecodeWays {
}
class Solution{
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; ++i){
            if(check(i - 1, i, s)){
                dp[i] = dp[i - 1] + 1;
            }
            else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }

    public boolean check(int pre, int cur, String s){
        int sum = 0;
        sum += s.charAt(pre) - '0';
        if(sum == 0){
            return false;
        }
        sum = sum*10 + s.charAt(cur) - '0';
        if(sum < 27 && sum %10 != 0){
            return true;
        }
        else{
            return false;
        }
    }
}
