package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: CombinationSum
 * Description: 组合总和，给一个数组和一个目标值，这个数组里面的数字可以任意次数使用，找出所有可以组成目标值的组合
 * date: 2020/5/22 15:55
 *
 * @author liyh
 */
public class CombinationSum {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.peekLast();
    }
}
class Solution39 {
    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 回溯算法
     * 这题的状态就是target的值
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates .length == 0 || target < 0){
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return ans;
    }

    /**
     * 每一层都有选取一个nums[i]的状态，可重复选取使用start变量控制选取的值的时候进入下一层可以不变。
     * 只需在这个支路返回的时候裁掉即可。
     * @param candidates
     * @param target
     * @param list
     * @param start
     */
    public void dfs(int[] candidates, int target, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
        }
        else{
            //对于每一个数字加进去，把目标值减下，然后进入下一个状态。
            for(int i = start; i < candidates.length; ++i){
                list.add(candidates[i]);
                //我们使用一个参数来控制加进去数组里面的哪一个数？
                //由于可以重复使用，于是我们传入i
                dfs(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }



//    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 补充一个体现思考逻辑的解法，提前sort会省很多的事情。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates .length == 0 || target < 0){
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs2(candidates, target, list, 0);
        return ans;
    }
    public void dfs2(int[] candidates, int target, List<Integer> list, int start){
        if(target < 0){
            return ;
        }
        for(int i = start; i < candidates.length; ++i){
            if(target == candidates[i]){
                list.add(candidates[i]);
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            else if(target > candidates[i]){
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
            else{
                return;
            }
        }
    }
}