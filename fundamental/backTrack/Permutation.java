package backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Permutation
 * Description: 全排列那道题
 * date: 2020/5/8 23:44
 *
 * @author liyh
 */
public class Permutation {
    public static void main(String[] args) {
        new Solution46().permute(new int[]{1, 2, 3});
    }
}
class Solution46 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, track, used);
        return ans;
    }
    public void dfs(int[] nums, int depth, List<Integer> path, boolean[] used){
        if(nums.length == depth){
            ans.add(new ArrayList<>(path));
            return;
        }
        //这行代码其实就是找一个没有用过的加进去，然后进行下一轮的挑选
        for(int i = 0; i < nums.length; ++i){
            if(used[i]){
                continue;
            }
            //在这个位置选择nums[i]
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth+1, path, used);
            //把这个位置的num[i]撤销
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}