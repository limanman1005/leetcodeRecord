package MayPratise;

/**
 * ClassName: ValidPalindrome2
 * Description: 给一个字符串，判断是不是回文串，可以删除任意一个字母看下是不是回文串
 * 这里加下提醒，对于回文子串一般都使用双指针法。
 * date: 2020/5/19 9:31
 *
 * @author liyh
 */
public class ValidPalindrome2 {
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
                for(int i = low, j = high - 1; i < j; i++, j--){
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if(c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
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
}


