package explore.middleAlgorithm.ArrayAndString;

/**
 * ClassName: LongestPalindromicSubstring
 * Description: 给定一个字符串，找到这个字符串的最长回文子串
 * date: 2020/7/3 10:18
 * 还有一个更为优秀的Manacher算法O（n），暂时先跳过
 * @author liyh
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        String ans = solution05.sampleDP("babad");
        System.out.println(ans);
        String ans2 = solution05.longestPalindrome4("babad");
        System.out.println(ans2);
        String ans3 = solution05.longestPalindrome_3("babad");
        System.out.println(ans3);
        String ans4 = solution05.longestPalindrome5("cbbd");

    }
}
class Solution05 {
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




    public String longestPalindrome_3(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0 ; i < len; ++i){
            dp[i][i] = true;
        }
        int maxLen = 1;
        //这个数值可以随便的变。
        int start = 0;
        //打表的填充顺序需要注意。需要从动态转移方程中找到方向。
        //dp[i][j] = (s[i] == s[j]) && (dp[i + 1][j - 1])  （这里需要注意的是 i < j, j > i 无意义。i == j 是边界）
        //有了i + 1才能推出i，所以i从最后一行（len - 1）开始
        //j是i + 1层的j所以无论从len-1出发还是i + 1都行。
        for(int i = len - 1; i >= 0; --i){
            for(int j = len - 1; j > i; --j){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 2){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    // dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j] == true){
                    int curLen = j - i + 1;
                    if(curLen > maxLen){
                        maxLen  = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
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



    public String sampleDP(String s){
        if(s == null || s.length() == 1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for(int i = len - 1; i >= 0; --i){
            for(int j = i; j < len; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 2){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j] == true){
                    if(maxLen < (j - i + 1)){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public String longestPalindrome4(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for(int i = len - 1; i >= 0; --i){
            for(int j = i; j < len; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 2){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j] == true){
                    int curLen = j - i + 1;
                    if(curLen > maxLen){
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }



    public String longestPalindrome5(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        for(int i = len - 1; i >= 0; --i){
            for(int j = i; j < len; ++j){
                //写在外边是错误的，必须配合这个使用。
                if(j - i < 1){
                    dp[i][j] = true;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j] == true){
                    int curLen = j - i + 1;
                    if(maxLen < curLen){
                        maxLen  = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

