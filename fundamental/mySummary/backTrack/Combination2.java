package mySummary.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Combination2
 * Description:
 * date: 2020/10/2 22:43
 * 给定一个数组  candidates  和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * @author liyh
 */
public class Combination2 {
}
class Solution40{
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> oneResult = new ArrayList<>();
        dfs(candidates, target, oneResult, 0);
        return ans;
    }
    private void dfs(int[] candidates, int target, List<Integer> oneResult, int start){
        if(target == 0){
            ans.add(new ArrayList<>(oneResult));
            return ;
        }
        for(int i = start; i < candidates.length; ++i){
            //这个是后序的都不需要判断了
            if(target < candidates[i]){
                return ;
            }
            //此步是为了防止元素重复使用
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            //加入待选序列
            oneResult.add(candidates[i]);
            //进行下一个添加
            dfs(candidates, target - candidates[i], oneResult, i + 1);
            //恢复现场
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
