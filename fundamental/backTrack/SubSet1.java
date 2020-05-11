package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SubSet1
 * Description:
 * date: 2020/5/8 16:22
 *
 * @author liyh
 */
public class SubSet1 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.remove(1);
        System.out.println(integers.get(0));
    }
}

class Solution78 {
    /**
     * 求子集从小集合推向大集合的循环思路
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //起始的空集合。
        ans.add(new ArrayList<Integer>());
        //这个对于每一个数组里面的数来说，都加到前面的所有集合中，形成一个新的集合。
        for(Integer n : nums){
            //先看下目前有多少集合。
            int size = ans.size();
            //对于每一个集合，都把元素放进去形成一个新的集合
            for(int i = 0; i < size; ++i){
                List<Integer> newSub = new ArrayList<Integer>(ans.get(i));
                newSub.add(n);
                ans.add(newSub);
            }
        }
        return ans;
    }

    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 这个上个循环解法的递归解法。递归有一个不断把问题缩小的想法在里面
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        ans.add(new ArrayList<>());
        if(nums.length == 0){
            return ans;
        }
        helper(nums, 0);
        return ans;
    }
    public void helper(int[] nums, int cur){
        if(cur >= nums.length){
            return;
        }
        int size = ans.size();
        for(int i = 0; i < size; ++i){
            List<Integer> nSub = new ArrayList<Integer>(ans.get(i));
            nSub.add(nums[cur]);
            ans.add(nSub);
        }
        helper(nums, cur + 1);
    }


}
