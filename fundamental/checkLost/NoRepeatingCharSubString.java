package checkLost;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: NoRepeatingCharSubString
 * Description:
 * date: 2021/7/22 11:01
 *
 * @author liyh
 */
public class NoRepeatingCharSubString {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int abcabcbb = solution03.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
}
class Solution03{

    /**
     * 此题也只有一个双指针的写法，
     * 也比较的好记
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = 0;
        int ans = 0;
        //固定一个左下标，然后不断扩展右下标
        for(int i = 0; i < n; ++i){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(right < n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                ++right;
            }
            //已经重复了才会跳出来，所以这里不用加1
            ans = Math.max(ans, right - i);
        }
        return ans;
    }


    public int sample(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int ans = 0;
        int len = s.length();
        for( ; left < len; ++left){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right < len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
