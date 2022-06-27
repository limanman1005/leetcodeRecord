package mySummary.Dp;

import java.util.Arrays;

/**
 * ClassName: DecodeWays
 * Description:
 * date: 2021/10/4 23:41
 *
 * @author liyh
 */
public class DecodeWays {
    public static void main(String[] args) {
        int digits = Integer.MAX_VALUE;
        System.out.println(1 << 30);
        StringBuilder sb = new StringBuilder();
        while(digits != 0){
            sb.append(digits  & 1);
            digits = digits >>> 1;
        }
        System.out.println(sb.reverse().toString());
    }
}


class Solution91{
    private int[] memo;

    /**
     * 边界条件有点丑的一个示例
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '0'? 0: 1;
        if(dp[0] == 0){
            return 0;
        }
        if(s.length() == 1){
            return dp[0];
        }
        if(s.charAt(1) > '0' && s.charAt(1) <= '9'){
            dp[1] = dp[0];
        }
        if(twoNumInRange(s.charAt(0), s.charAt(1))){
            dp[1]++;
        }
        for(int i = 2; i < len; ++i){
            int num1 = s.charAt(i) - '0';
            if(num1 > 0){
                dp[i] = dp[i - 1];
            }
            int num2 = (s.charAt(i - 1) - '0') * 10 + num1;
            if(num2 >= 10 && num2 <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }

    private boolean twoNumInRange(char c1, char c2){
        int num = (c1 - '0') * 10 + c2 - '0';
        if(num >= 10 && num <= 26){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 用了记忆化搜索的一个方法
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        memo = new int[len];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }
    private int dfs(String s, int idx){
        if(idx >= s.length()){
            return 1;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }
        int count = 0;
        if(s.charAt(idx) > '0' && s.charAt(idx) <= '9'){
            count += dfs(s, idx + 1);
        }
        if(idx + 2 <= s.length()){
            int numOfTwoPosition = Integer.parseInt(s.substring(idx, idx + 2));
            if(numOfTwoPosition >= 10 && numOfTwoPosition <= 26){
                count += dfs(s, idx + 2);
            }
        }
        memo[idx] = count;
        return count;
    }
}


