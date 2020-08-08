package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PhoneNumString
 * Description: 给一个数字字符串，给出所有在手机上九宫格
 * date: 2020/5/19 9:42
 *
 * @author liyh
 */
public class PhoneNumString {
    public static void main(String[] args) {
//        Solution17 solution17 = new Solution17();
//        List<String> strings = solution17.letterCombinations("234");
//        System.out.println(strings);
        int x = 10;
        int count = 0;
        while(x != 0){
            x = x & (x -1);
            count++;
        }
        System.out.println(count);
    }
}

class Solution17 {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ans = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        char[] str = digits.toCharArray();
        dfs(str, 0);
//        System.out.println(sb.toString());
        return ans;
    }
    public void dfs(char[] str, int cur){
        if(cur == str.length){
            ans.add(sb.toString());
            return;
        }
        String curString = map[str[cur] - '0'];
        for(int i = 0; i < curString.length(); ++i){
            System.out.println(sb.toString());
            sb.append(curString.charAt(i));
            dfs(str, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}