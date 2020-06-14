package juniorAlgorithm.string;

/**
 * ClassName: ValidPalindrome
 * Description: 给一个字符串，只考虑数字和字母，判断下是不是回文子串。
 * 还有一道可删除一个字符看下还是不是回文子串。见lc680
 * date: 2020/6/13 17:06
 *
 * @author liyh
 */
public class ValidPalindrome {
}
class Solution125 {
    /**
     * 这个就是跳过不判断的字符。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] str = s.toCharArray();
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(str[left])){
                left++;
            }
            while(left <right && !Character.isLetterOrDigit(str[right])){
                right--;
            }
            if(Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}