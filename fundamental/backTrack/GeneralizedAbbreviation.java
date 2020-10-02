package backTrack;

import explore.recursion.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: GeneralizedAbbreviation
 * Description:
 * date: 2020/10/1 11:39
 *
 * @author liyh
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        Solution320 solution320 = new Solution320();
        List<String> abc = solution320.generateAbbreviation("abc");

    }
}
class Solution320{
    public List<String> generateAbbreviation(String word){
        ArrayList<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }
    private void backtrack(List<String> ans, StringBuilder sb, String word, int i, int k){
        int len = sb.length();
        if(i == word.length()){
            if(k != 0){
                sb.append(k);
            }
            ans.add(sb.toString());
        }
        else{
            backtrack(ans, sb, word, i + 1, k + 1);
            if(k != 0){
                sb.append(k);
            }
            sb.append(word.charAt(i));
            backtrack(ans, sb, word, i + 1, 0);
        }
        sb.setLength(len);
    }
}
