package mySummary.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: RestoreIPAddr
 * Description:
 * date: 24/6/2022 上午1:35
 *
 * @author liyh
 */
public class RestoreIPAddr {
}
class Solution93{
    private List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 1, 0);
        return ans;
    }

    private void dfs(String s, int splitIdx, int k){
        if(k == 3){
            if(judge(s)){
                ans.add(new String(s));
            }
            return ;
        }

        for(int i = splitIdx; i < s.length() - 1; ++i){
            insertDot(s, i);
            dfs(s, i + 1, k);
            deleteDot(s, i);
        }
    }

    private void deleteDot(String s, int i) {

    }

    private void insertDot(String s, int i) {

    }

    private boolean judge(String s) {
        return false;
    }
}
