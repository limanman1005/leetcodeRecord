package offer.backtrack;

import java.util.*;

/**
 * ClassName: Offer082
 * Description:
 * date: 8/5/2022 上午10:42
 *
 * @author liyh
 */
public class Offer082 {
    public static void main(String[] args) {
        SolutionOffer082 solutionOffer082 = new SolutionOffer082();
        int[] arr = new int[]{1, 2, 3};
        Arrays.sort(arr);
        List<List<Integer>> lists = solutionOffer082.combinationSum2(arr, 6);
        System.out.println(lists.size());
    }
}
//todo 以后有机会一定要处理一下子集中有重复元素的时候另一种递归的思考角度。
class SolutionOffer082 {
    /**
     * 这个如何跳过重复的元素来说，就是两种思考的角度罢了。导致递归树不同，
     * 这个思考方式比较的难想，但是在处理有重复元素的时候比较好用。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return ans;
        }
        List<Integer> oneResult = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, oneResult, ans);
        System.out.println(ans.size());
        return ans;
    }


    private void backTrack(int[] candidates, int target, int idx, List<Integer> oneResult, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(oneResult));
            return ;
        }
        if(target < 0 || candidates.length == idx){
            return ;
        }
        //重点就在这里，递归树的第一层就有很多候选，而不是对于每一个元素都考虑选择或者不选择
        for(int i = idx; i < candidates.length; ++i){
            if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }
            oneResult.add(candidates[i]);
            //这里注意是i + 1
            backTrack(candidates, target - candidates[i], i + 1, oneResult, ans);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
