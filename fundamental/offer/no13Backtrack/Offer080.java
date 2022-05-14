package offer.no13Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer080
 * Description:
 * date: 7/5/2022 下午4:50
 *
 * @author liyh
 */
public class Offer080 {
}
class SolutionOffer080 {

    /**
     * 组合数字
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<>(), ans);
        return ans;
    }


    private void backTrack(int num, int n, int k, List<Integer> oneResult, List<List<Integer>> ans){
        //每个元素都选了一遍，为了避免拦住边界
        if(oneResult.size() == k){
            ans.add(new ArrayList<>(oneResult));
            return ;
        }
        //面临的抉择是对于1到n的每一个数字都要选择一遍，
        //为了避免重复我们需要进行按顺序选择，然后加一
        for(int i = num; i <= n; ++i){
            oneResult.add(i);
            backTrack(i+1, n, k, oneResult, ans);
            oneResult.remove(oneResult.size() - 1);
        }

    }
}
