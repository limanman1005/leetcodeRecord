package mySummary.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Permutation2
 * Description: 给一个数组，里面有重复的数字，然后求所有可能的全排列
 * date: 2021/10/20 1:08
 *
 * @author liyh
 */
public class Permutation2 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] arr = {1, 1};
        solution47.permuteUnique(arr);

    }
}

class Solution47 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, path, used);
        return ans;
    }


    /**
     * 回溯函数设计，idx代表要选择的第几个位置。
     * 然后就是for循环遍历整个数组进行选择。
     * 提前使用sort便于去重。
     * 使用used数组记录使用信息。
     * @param nums
     * @param idx
     * @param path
     * @param used
     */
    private void dfs(int[] nums, int idx, List<Integer> path, boolean[] used){
        if(idx == nums.length){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int i = 0; i < nums.length; ++i){
            //比不去重的就多了这几行代码，意思是两种情况直接剪枝：1.之前用过了。
            //2.同层的nums[i] == nums[i - 1] 重复的数字
            //used[i - 1] == false 意味着在同一层，即idx一样，在同一个循环里
            //两个合起来的意思就是同一层下，和上一个一样的数字不选。也就是说选择一样数字中的最左侧。
            if(used[i] || (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false)){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, idx + 1, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
