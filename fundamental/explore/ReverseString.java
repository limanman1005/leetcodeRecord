package explore;

import java.util.Arrays;

/**
 * ClassName: ReverseString
 * Description: 使用char[]数组反转字符串的递归解法。
 * date: 2020/5/12 9:09
 *  这个字符串的问题，暂时放后吧。
 * @author liyh
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'c'};
        new Solution1().reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution1 {
    /**
     * 这个使用这个
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
