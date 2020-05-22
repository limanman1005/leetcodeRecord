package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CombinationSum
 * Description: 组合总和，给一个数组和一个目标值，这个数组里面的数字可以任意次数使用，找出所有可以组成目标值的组合
 * date: 2020/5/22 15:55
 *
 * @author liyh
 */
public class CombinationSum {
}
class Solution39 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates .length == 0 || target < 0){
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return ans;
    }
    public void dfs(int[] candidates, int target, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
        }
        else{
            for(int i = start; i < candidates.length; ++i){
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}