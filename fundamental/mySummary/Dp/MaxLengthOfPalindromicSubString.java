package mySummary.Dp;

import java.util.Arrays;

/**
 * ClassName: MaxLengthOfPalindromicSubString
 * Description: 最长的回文子串
 * date: 2020/5/21 23:09
 * 动态规划法复杂度依然比较的高，是暴力法的优化
 * @author liyh
 */
public class MaxLengthOfPalindromicSubString {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] arr2 = {{1, 2}, {3, 4}};
        int[] copy = Arrays.copyOf(arr, arr.length);
        int[][] copy2 = Arrays.copyOf(arr2, arr2.length);
//        CharSequence charSequence = "124".subSequence(1, 2);

    }
}

class Solution05 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 此为中心扩展法
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }


}
