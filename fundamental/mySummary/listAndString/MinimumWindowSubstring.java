package mySummary.listAndString;

/**
 * ClassName: MinimumWindowSubstring
 * Description: 滑动窗口的题，其实记一个固定的模板就OK了。
 * date: 15/6/2022 下午8:29
 *
 * @author liyh
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minSubString = solution76.minWindow(s, t);
        System.out.println(minSubString);
    }
}
class Solution76 {
    public String minWindow(String s, String t) {
        int[] count = new int[26];
        for(int i = 0; i < t.length(); ++i){
            count[t.charAt(i) - 'A']++;
        }
        int left = 0;
        int right = 0;
        int startIdx = 0;
        int minLen = s.length() + 1;
        for( ;left < s.length(); ++left){
            while(!isMatch(count, t) && right < s.length()){
                count[s.charAt(right) - 'A']--;
                right++;
            }
            if(isMatch(count, t)){
                minLen = Math.min(minLen, right - left);
                if(minLen == right - left){
                    startIdx = left;
                }
            }
            count[s.charAt(left) - 'A']++;
        }
        if(minLen == s.length() + 1){
            return "";
        }
        else{
            return s.substring(startIdx, startIdx + minLen);
        }
    }

    private boolean isMatch(int[] count, String s){
        for(int i = 0; i < s.length(); ++i){
            if(count[s.charAt(i) - 'A'] > 0){
                return false;
            }
        }
        return true;
    }
}
