package mySummary.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PlindromePartitioning
 * Description:
 * date: 28/5/2022 上午2:39
 *
 * @author liyh
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        List<List<String>> aab = solution131.partition("aab");
        System.out.println(aab);
    }
}
class Solution131{
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s == null || s.length() == 0){
            return ans;
        }

        dfs(s, 0, ans, new ArrayList<String>());
        return ans;
    }


    private void dfs(String s, int idx, List<List<String>> ans, List<String> oneResult){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(oneResult));
            return ;
        }

        for(int i = idx; i < s.length(); ++i){
            String curJudgeString = s.substring(idx, i + 1);
            if(isPalindrome(curJudgeString)){
                oneResult.add(curJudgeString);
                dfs(s, i + 1, ans, oneResult);
                oneResult.remove(oneResult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
