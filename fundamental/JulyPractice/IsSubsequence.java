package JulyPractice;

/**
 * ClassName: IsSubsequence
 * Description: 判断一个字符串的字母顺序是否再另一个字符串中出现
 * date: 2020/7/27 9:38
 * 双指针法是最容易想到的
 * 还有一个动态规划的方法，对其中一个字符串进行预处理。
 * @author liyh
 */
public class IsSubsequence {
}
class Solution392 {
    /**
     * 双指针法，暗含了贪心。每一次匹配的都是最好的
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null ||(s.length() != 0 && t.length() == 0)){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        int ps = 0, pt = 0;
        int lens = s.length(), lent = t.length();
        while(pt <= lent){
            if(ps == lens){
                return true;
            }
            if(pt == lent){
                return false;
            }
            if(s.charAt(ps) == t.charAt(pt)){
                ps++;
                pt++;
            }
            else{
                pt++;
            }
        }
        return false;
    }
}
