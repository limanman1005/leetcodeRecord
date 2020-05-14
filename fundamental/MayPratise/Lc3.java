package MayPratise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Lc3
 * Description: 一个字符串的最长子串
 * date: 2020/5/2 10:53
 *
 * @author liyh
 */
public class Lc3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abbac"));
    }
}

class Solution3 {
    /**
     * 这个解法没有体现区间内不包含重复的元素，所以有点难理解。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        //map记录每个字母最后出现的位置。（截止到访问的时候）
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                //这个是保证left不会向左移。比我这个left小意味着当前区间内已经没有这个元素了
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //把这个元素放到这个区间里面去。
            map.put(s.charAt(i), i);
            //判断下需不需要更新最大值。
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 这个第二种使用set的解法，比较的清晰直观。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = -1;
        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(right + 1 < n && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
