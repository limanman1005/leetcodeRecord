package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Lc784
 * Description: 字母大小写
 * date: 2020/5/6 11:52
 *
 * @author liyh
 */
public class Lc784 {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if(S.length() == 0){
            return ans;
        }
        char[] strChar = S.toCharArray();
        helper(strChar, 0, S.length(), ans);
        return ans;
    }
    public void helper(char[] str, int cur, int end, List<String> ans){
        if(cur == end){
            ans.add(new String(str));
            return;
        }
        helper(str, cur + 1, end, ans);
        if(Character.isLetter(str[cur])){
            str[cur] = (char) (str[cur] ^ 32);
            helper(str, cur + 1, end, ans);
        }
    }


    public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<>();
        if(S.isEmpty()){
            return ans;
        }
        dfs(S, 0, ans, new StringBuilder());
        return ans;
    }
    public void dfs(String s, int cur, List<String> ans, StringBuilder sb){
        if(s.length() == cur){
            ans.add(sb.toString());
            return;
        }
        if(Character.isDigit(s.charAt(cur))){
            sb.append(s.charAt(cur));
            dfs(s, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            sb.append(s.charAt(cur));
            dfs(s, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append((char)(s.charAt(cur) ^ 32));
            dfs(s, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
