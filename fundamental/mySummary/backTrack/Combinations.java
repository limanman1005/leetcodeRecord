package mySummary.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Combinations
 * Description: 给一个n和一个k。找出数字1-n之间选择k个数的所有组合
 * 从选择一个数的状态到选择两个数的状态不断的转移，到选择了k个状态的组合。这个题会有很多无效的状态，要提前剪枝。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * date: 2020/5/22 15:49
 *
 * @author liyh
 */
public class Combinations {
}
class Solution77 {
    /**
     * 这道题的状态就是list的大小。在每一层都做选择。可选的范围由start到搜索上界。每一层有很多的状态可选。
     * 由于每个数字只能选取一次，直接按顺序选，进入下一个状态的时候把这个可选的范围排除出去。
     * 然后删去这个状态。在同一层上选取其他的状态。
     */
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n){
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list);
        return ans;
    }
    public void dfs(int n, int k, int start, List<Integer> list){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        //这里存在一个搜索的上界，超过这个上界再开始搜索无意义，不会凑够k个数的
        //改成n也可以通过，但是会比较的慢，无剪枝
        for(int i = start; i <= n - (k - list.size()) + 1; ++i){
            list.add(i);
            dfs(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
