package offer.no13Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer085
 * Description:
 * date: 8/5/2022 下午10:39
 *
 * @author liyh
 */
public class Offer085 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }
}

class SolutionOffer085{
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, ans, 0, 0, n);
        return ans;
    }

    private void dfs(StringBuilder sb, List<String> ans, int left, int right, int n){
        if(left < right){
            return;
        }
        if(left == n && right == n){
            ans.add(sb.toString());
            return ;
        }
        if(left < n){
            sb.append("(");
            dfs(sb, ans, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left > right){
            sb.append(")");
            dfs(sb, ans, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
