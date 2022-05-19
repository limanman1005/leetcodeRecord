package niucode.Zoom.one;

import java.util.HashSet;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/23 9:59
 *
 * @author liyh
 */
public class Main {
}

class SolutionZoom01{

    public int lengthOfLongestSubstring (String s) {
        // write code here
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int left = 0, right = 0;
        int ans = 0;
        for(; left < len ; ++left){
            if(left != 0){
                set.remove(s.charAt(left));
            }
            while (right < len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                ++right;
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

}
