package juniorAlgorithm.string;

/**
 * ClassName: ReverseString
 * Description: 反转字符串，给定一个字符数组反转字符串。
 * 这个和反转数组变成了一道题，不过这里给出递归解法。
 * date: 2020/6/13 12:30
 *
 * @author liyh
 */
public class ReverseString {
}
class Solution344 {

    /**
     * 这个就是个反转数组的解法，这里是循环解法
     * @param s
     */
    public void reverseString(char[] s) {
        if(s == null || s.length == 1){
            return ;
        }
        int len = s.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }


    /**
     * 这个是递归解法
     * @param s
     */
    public void reverseString2(char[] s){
        helper(s, 0, s.length);
    }

    private void helper(char[] s, int left, int right) {
        if(left >= right){
            return;
        }
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        helper(s, left + 1, right - 1);
    }


}