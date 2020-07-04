package middleAlgorithm.ArrayAndString;

/**
 * ClassName: LongestPalindromicSubstring
 * Description: 给定一个字符串，找到这个字符串的最长回文子串
 * date: 2020/7/3 10:18
 * 还有一个更为优秀的Manacher算法O（n），暂时先跳过
 * @author liyh
 */
public class LongestPalindromicSubstring {
}
class Solution5 {
    /**
     * 动态规划法。回文串自带状态转移性质。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        //长度为一
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        for(int j = 1; j < len; ++j){
            for(int i = 0; i < j; ++i){
                if(chars[i] == chars[j]){
                    if((j - i) < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 中心扩散法，就是对每一字符，都向两边扩散，记录下长度
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); ++i){
            //分两种情况，中间位置是两个字符或者一个字符
            int lenOdd = expandAroundCenter(s, i, i);
            int lenEven = expandAroundCenter(s, i, i + 1);
            int len = Math.max(lenEven, lenOdd);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}

