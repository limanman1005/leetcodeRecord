package offer.no13Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Offer081
 * Description:
 * date: 7/5/2022 下午5:14
 *
 * @author liyh
 */
public class Offer081 {
}

class SolutionOffer081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return ans;
        }
        List<Integer> oneSet = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, oneSet , ans);
        return ans;
    }


    private void backTrack(int[] candidates, int target, int idx, List<Integer> oneSet, List<List<Integer>> ans){
        if(idx == candidates.length || target < 0){
            return ;
        }
        if(target == 0){
            ans.add(new ArrayList<>(oneSet));
        }else if(idx < candidates.length){
            backTrack(candidates,target, idx + 1, oneSet, ans);
            oneSet.add(candidates[idx]);
            backTrack(candidates, target - candidates[idx], idx, oneSet, ans);
            oneSet.remove(oneSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> oneResut = new ArrayList<>();
        backTrack2(candidates, target, 0, oneResut, ans);
        return ans;
    }

    private void backTrack2(int[] candidates, int target, int idx, List<Integer> oneResut, List<List<Integer>> ans){
        if(target < 0){
            return ;
        }
        if(target == 0){
            ans.add(new ArrayList<>(oneResut));
            return ;
        }
        for(int i = idx; i < candidates.length; ++i){
            oneResut.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, oneResut, ans);
            oneResut.remove(oneResut.size() - 1);
            //这一行是不能加的，这个for循环，暗含了跳过这个数字的情况了
            // backTrack(candidates, target, i + 1, oneResut, ans);
        }
    }
}
