package dailyPractice.MayPratise;

/**
 * ClassName: ValidPalindrome2
 * Description: 给一个字符串，判断是不是回文串，可以删除任意一个字母看下是不是回文串
 * 这里加下提醒，对于回文子串一般都使用双指针法。
 * 此题的循环和迭代写法都要看看
 * date: 2020/5/19 9:31
 *
 * @author liyh
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {
        Solution680 solution680 = new Solution680();
        boolean ans = solution680.validPalindrome4("abc");
        System.out.println(ans);
    }
}
class Solution680 {
    /**
     * 这个解法的思路不难理解。首先使用双指针发从两边判断。
     * 如果碰到low或者high有一位不是的话，两边依次跳过这个不是的字符然后接着判断。
     * 最后返回结果就好了。
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while(low < high){
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if(c1 == c2){
                low++;
                high--;
            }
            else{
                boolean flag1 = true, flag2 = true;
                //删除左边的试试。
                for(int i = low, j = high - 1; i < j; i++, j--){
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if(c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                //删除右边的试试
                for(int i = low + 1, j = high; i < j; ++i, --j){
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if(c3 != c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }


    private int count = 0;

    /**
     * 这题的递归解法。可以应对删除几个的情况
     * @param s
     * @return
     */
    public boolean validPalindrome3(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                if(count == 0){
                    count++;
                    return validPalindrome3(s.substring(i, j)) || validPalindrome3(s.substring(i + 1, j + 1));
                }
                return false;
            }
        }
        return true;
    }



    public boolean validPalindromeByMe(String s) {
        if(s == null){
            return false;
        }
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] strs = s.toCharArray();
        while(left < right){
            if(strs[left] == strs[right]){
                left++;
                right--;
            }
            else{
                boolean leftFlag = true;
                boolean rightFlag = true;
                for(int i = left + 1, j = right; i < j; ++i, --j){
                    //这里记得是i和j
                    if(strs[left] != strs[right]){
                        leftFlag = false;
                        break;
                    }
                }
                for(int i = left, j = right - 1; i < j; ++i, --j){
                    //这里记得是i和j
                    if(strs[left] != strs[right]){
                        rightFlag = false;
                        break;
                    }
                }
                return leftFlag || rightFlag;
            }
        }
        return true;
    }




    public boolean validPalindrome4(String s) {
        return helper(s, 0);
    }
    public boolean helper(String s, int count){
        if(count > 1){
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return helper(s.substring(i, j), count+1) || helper(s.substring(i + 1, j + 1), count+1);
            }
        }
        return true;
    }
}


