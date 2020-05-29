package MayPratise;

import java.util.LinkedList;

/**
 * ClassName: DecodeString
 * Description: 对字符串进行解码，这个详细解读暂时留到后面吧。
 * date: 2020/5/28 9:12
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * @author liyh
 */
public class DecodeString {
    public static void main(String[] args) {
    }
}
class Solution394 {
    /**
     * 这个是递归解法
     * @param s
     * @return
     */
    public String decodeString(String s){
        return dfs(s, 0)[0];
    }
    public String[] dfs(String s, int i){
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            else if(s.charAt(i) == '['){
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0){
                    ans.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']'){
                return new String[] {String.valueOf(i), ans.toString()};
            }
            else{
                ans.append(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return new String[]{ans.toString()};
    }

    /**
     * 使用栈的解法。官方的那个解答我照着写不对
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> multiStack = new LinkedList<>();
        LinkedList<String> ansStack = new LinkedList<>();
        for(Character c : s.toCharArray()){
            if(c == '['){
                multiStack.addLast(multi);
                ansStack.addLast(ans.toString());
                multi = 0;
                ans = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiStack.removeLast();
                for(int i = 0; i < curMulti; ++i){
                    tmp.append(ans);
                }
                ans = new StringBuilder(ansStack.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}


