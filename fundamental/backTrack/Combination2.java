package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Combination2
 * Description:
 * date: 2020/10/2 22:43
 *
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
            //这个是为了元素相同重复
            //这里还只能是i和i-1相比，才能保证后续一定会回溯减元素。
            //和上个不一样才能加上去
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            //加入待选序列
            oneResult.add(candidates[i]);
            //进行下一个解析
            dfs(candidates, target - candidates[i], oneResult, i + 1);
            //恢复现场
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
