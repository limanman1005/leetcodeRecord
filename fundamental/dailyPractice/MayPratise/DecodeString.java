package dailyPractice.MayPratise;

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
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString2("3[a2[c]]"));
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

    /**
     * 这个递归有点秀了
     * @param s
     * @param i 代表到哪了
     * @return 返回了一个字符数组，有点意思
     */
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
                //这里将ans置空的操作也很必要
                ans = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiStack.removeLast();
                for(int i = 0; i < curMulti; ++i){
                    tmp.append(ans);
                }
                //比较关键的就在这，从栈中取出一个进行和已经重复好的进行拼接
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

    private int index = 0;

    /**
     * 这个写法很六，index可以放到函数参数里面优点麻烦。有点坑的
     * @param s
     * @return
     */
    public String decodeString3(String s) {
        return dfs2(s);
    }
    private String dfs2(String s){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        String inside = null;
        while(index < s.length()){
            if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                num = num * 10 + s.charAt(index) - '0';
            }
            else if(s.charAt(index) == '['){
                ++index;
                inside = dfs2(s);
                while(num-- > 0){
                    sb.append(inside);
                }
                num = 0;
            }
            else if(s.charAt(index) == ']'){
                break;
            }
            else{
                sb.append(s.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }

}


