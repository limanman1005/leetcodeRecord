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
        char[] str = "1a2b".toCharArray();
        List<String> strings = new Solution784().letterCasePermutation("1a2b");
        strings.forEach(System.out::println);
    }
}
class Solution784 {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if(S.length() == 0){
            return ans;
        }
        char[] strChar = S.toCharArray();
        helper(strChar, 0, S.length(), ans);
        for (char ch: strChar){
            System.out.println(ch);
        }
        return ans;
    }

    /**
     * 这个没有回溯。最后那个str变了
     * @param str
     * @param cur
     * @param end
     * @param ans
     */
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
        dfs3(S.toCharArray(), 0, ans, new StringBuilder());
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
    public void dfs2(char[] str, int cur, List<String> ans, StringBuilder sb){
        if(cur == str.length){
            ans.add(sb.toString());
            return;
        }
        if(Character.isDigit(str[cur])){
            sb.append(str[cur]);
            dfs2(str, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else {
            sb.append(str[cur]);
            dfs2(str, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append((char)(str[cur] ^ 32));
            dfs2(str, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public void dfs3(char[] str, int cur, List<String> ans, StringBuilder sb){
        if(cur == str.length){
            ans.add(sb.toString());
            return;
        }
        sb.append(str[cur]);
        dfs3(str, cur + 1, ans, sb);
        sb.deleteCharAt(sb.length() - 1);
        if(Character.isLetter(str[cur])){
            sb.append((char)(str[cur] ^ 32));
            dfs3(str, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
