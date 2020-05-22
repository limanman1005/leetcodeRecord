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
        return ans;
    }
    public void dfs(char[] str, int cur){
        if(cur == str.length){
            ans.add(sb.toString());
            return;
        }
        String curString = map[str[cur] - '0'];
        for(int i = 0; i < curString.length(); ++i){
            sb.append(curString.charAt(i));
            dfs(str, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}