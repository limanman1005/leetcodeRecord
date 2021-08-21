package dailyPractice.MayPratise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Lc3
 * Description: 一个字符串的最长无重复子串
 * date: 2020/5/2 10:53
 *
 * @author liyh
 */
public class Lc3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
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
        //i代表右边的边界。
        for(int i = 0; i < s.length(); ++i){
            //如果窗口里面已经有这个元素了，可能需要更新下left。
            if(map.containsKey(s.charAt(i))){
                //移动左边的边界。abba这个例子证明了map里面的数值可能比当前left还要小，说明这个char已经在left外边了，这时候不需要移动left。
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
        //因为是先判断后自增的，所以从0开始是右开的区间， -1开始是右闭区间。
        //最后算区间的元素方法不一样。
        //区间的元素也可用set.size();
        int right = -1;
//        int right = 0;
        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            //使用右开区间的话，这里也要改一点。
            while(right + 1 < n && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
//            ans = Math.max(ans, right - i);
        }
        return ans;
    }
}
