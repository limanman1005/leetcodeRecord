package explore.microsoft.arrayAndString;

/**
 * ClassName: ReverseString
 * Description:
 * date: 2020/7/29 11:34
 *
 * @author liyh
 */
public class ReverseString {
}
class Solution344 {
    /**
     * 递归解法
     * @param s
     */
    public void reverseString(char[] s){
        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int left, int right){
        if(left >= right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        helper(s, ++left, --right);
    }
}
