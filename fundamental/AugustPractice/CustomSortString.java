package AugustPractice;

/**
 * ClassName: CustomSortString
 * Description:
 * date: 2020/9/9 11:47
 *
 * @author liyh
 */
public class CustomSortString {
    public static void main(String[] args) {
        Solution791 solution791 = new Solution791();
        System.out.println(solution791.customSortString("cbafg", "abcd"));
    }
}
class Solution791 {
    public String customSortString(String S, String T) {
        if(S.length() == 0 || T.length() == 0){
            return T;
        }
        int lenS = S.length();
        int lenT = T.length();
        int[] memo = new int[26];
        for(int i = 0; i < lenS; ++i){
            memo[S.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lenS; ++i){
            int num = memo[S.charAt(i) - 'a'];
            //少做了一个contains的操作
            for(int j = 0; j < num; ++j){
                sb.append(S.charAt(i));
            }
        }
        for(int i = 0; i < lenT; ++i){
            if(memo[T.charAt(i) - 'a'] == 0){
                sb.append(T.charAt(i));
            }
        }
        return sb.toString();
    }
}
