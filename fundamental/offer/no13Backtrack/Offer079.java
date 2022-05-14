package offer.no13Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer079
 * Description:
 * date: 7/5/2022 下午4:48
 *
 * @author liyh
 */
public class Offer079 {
    public static void main(String[] args) {
        SolutionOffer079 solutionOffer079 = new SolutionOffer079();

        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = solutionOffer079.subsets(arr);
        subsets.forEach(System.out::println);
    }
}
class SolutionOffer079 {

    /**
     * 很典型的backtack题
     * 对于集合中的数字，每一个都面临选不选的抉择。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        backTrack(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backTrack(int[] nums, int idx, List<Integer> set, List<List<Integer>> ans){
        //终止条件就是把每一个元素都抉择完了最后set里面存放的是结果
        if(idx == nums.length){
            ans.add(new ArrayList<>(set));
            return ;
        }
        //对于每个数字都面临选择或者不选择的抉择。
        backTrack(nums, idx + 1, set, ans);
        set.add(nums[idx]);
        backTrack(nums, idx + 1, set, ans);
        set.remove(set.size() - 1);
    }

    /**
     * 这个函数错在，对于每个数字是选他还是不选他的问题，而不是每个数字都走一遍求自己的流程
     * @param nums
     * @param step
     * @param set
     * @param ans
     */
    private void backTrack2(int[] nums, int step, List<Integer> set, List<List<Integer>> ans){
        if(step == nums.length){
            ans.add(new ArrayList<>(set));
            return ;
        }
        for(int num : nums){
            backTrack2(nums, step + 1, set, ans);
            set.add(num);
            backTrack2(nums, step + 1, set, ans);
            set.remove(set.size() - 1);
        }
    }
}
