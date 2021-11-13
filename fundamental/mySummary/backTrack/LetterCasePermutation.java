package mySummary.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Lc784
 * Description: 字母大小写
 * date: 2020/5/6 11:52
 *
 * @author liyh
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(Lc784.class.getName());
//        logger.warning("123");
        char[] str = "1a2b".toCharArray();
        List<String> strings = new Solution784().letterCasePermutation2("1a2b");
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
     * 这个当然是回溯，有状态树就算。
     * 这个是str里面的字符表示一个状态。然后判断状态需不需要改变。递归条件
     * @param str
     * @param cur
     * @param end
     * @param ans
     */
    public void helper(char[] str, int cur, int end, List<String> ans){
        //到达结束状态，把当前的结果保存下来
        if(cur == end){
            ans.add(new String(str));
            return;
        }
        //这个是当前字符不变往下一个状态
        helper(str, cur + 1, end, ans);
        //这个是判断下是不是字母。如果是字母改变下大小写后进入下一个状态
        if(Character.isLetter(str[cur])){
            str[cur] = (char) (str[cur] ^ 32);
            helper(str, cur + 1, end, ans);
            //不加这一行算是歪打正着，逻辑有点问题，但是答案对了，加上了才是完整的回溯算法逻辑。
            str[cur] = (char) (str[cur] ^ 32);
        }
    }


    /**
     * 另一种思路的回溯。使用一个stringBuilder来保存当前的状态。
     * 遇到一个字符首先append进去。删掉这个状态，然后判断下需不需要需不需要改变状态，再来一次。
     * 如果需要的话继续append进去。否则这一层结束。
     * @param S
     * @return
     */
    public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<>();
        if(S.isEmpty()){
            return ans;
        }
        char[] str = S.toCharArray();
        dfs3(str, 0, ans, new StringBuilder());
        for(char ch : str){
            System.out.println(ch);
        }
        return ans;
    }

    /**
     * 这个回溯用的是
     * @param s
     * @param cur
     * @param ans
     * @param sb
     */
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

    /**
     * 这样使用stringBuilder好像更舒服一点
     * @param str
     * @param cur
     * @param ans
     * @param sb
     */
    public void dfs3(char[] str, int cur, List<String> ans, StringBuilder sb){
        if(cur == str.length){
            ans.add(sb.toString());
            return;
        }
        //第一次进来不管是什么直接append进去。然后进入下一个状态。等这个状态结束之后恢复第一次进来前的状态
        //然后判断下当前这个字符是不是字母，如果是的话，我们我们改变下大小写，重新append进去，然后进入下一个状态。
        //最后仍要恢复第一次进来的状态以免影响上层调用。
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
