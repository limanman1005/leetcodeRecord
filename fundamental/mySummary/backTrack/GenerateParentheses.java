package mySummary.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenerateParentheses
 * Description:给定一个数字n生成所有n对括号的合法组合
 * 这个状态是什么状态？？？
 * 这个状态是由left和right决定的。
 * 此题不只回溯一种解法，其他算法也值得一看。
 * date: 2020/5/22 16:08
 *
 * @author liyh
 */
public class GenerateParentheses {
}
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, n, ans);
        return ans;
    }

    /**
     * 这个是回溯算法
     * 这里的状态有left（还剩多少个左括号没有用）和right（还剩多少右括号没有用）
     *
     * @param sb
     * @param left
     * @param right
     * @param ans
     */
    public void dfs(StringBuilder sb, int left, int right, List<String> ans){
        //到了左括号和右括号都用完的状态了，找到了一个结果。
        if(left == 0 && right == 0){
            ans.add(sb.toString());
            return ;
        }
        //left > right的状态，不合法，直接剪枝。
        if(left > right){
            return;
        }
        //还有左括号
        if(left > 0){
            //可以append进去
            sb.append("(");
            //进入下一个状态
            dfs(sb, left - 1, right, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        //有右括号
        if(right > 0){
            //append一个右括号
            sb.append(")");
            //进入下一个状态
            dfs(sb, left, right - 1, ans);
            //恢复状态。
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
