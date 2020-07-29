package explore.microsoft.arrayAndString;

/**
 * ClassName: ValidPalindrome
 * Description: lc第125题
 * date: 2020/7/29 11:28
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
            //忽略大小写
            if(Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 正则加上stringbuilder法
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        //这个正则匹配有点意思
        String judge = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rjudge = new StringBuilder(judge).reverse().toString();
        return judge.equals(rjudge);
    }


    /**
     * 本题递归解法
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s) {
        return helper(s, 0, s.length() - 1);
    }
    private boolean helper(String s, int left, int right){
        if(left >= right){
            return true;
        }
        while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left <right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }
        return helper(s, ++left, --right);
    }
}
