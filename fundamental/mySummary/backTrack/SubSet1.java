package mySummary.backTrack;

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
        int[] arr = new int[]{1, 2, 3, 4};
//        List<List<Integer>> lists = new Solution78().subsets5(arr);
//        lists.forEach(System.out::println);
        Solution78 solution78 = new Solution78();
        List<List<Integer>> lists1 = solution78.subsets4(arr);
        lists1.forEach(System.out::println);
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

    private List<List<Integer>> output = new ArrayList<>();
    private int n, k;

    /**
     * 子集的回溯算法。这个回溯思路是把不同大小的子集分开来求出，最后汇总。
     * @param nums
     * @return
     */
    public List<List<Integer>> subset3(int[] nums){
        n = nums.length;
        //k表示的目前生成的子集的大小，一共要生成[0, k]个子集的大小。
        for(k = 0; k < n + 1; ++k){
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    private void backtrack(int first, ArrayList<Integer> cur, int[] nums) {
        if(cur.size() == k){
            output.add(new ArrayList<>(cur));
            //这里还是加上return吧。虽然不return也可以得到正确答案。
            return ;
        }
        for(int i = first; i < n; ++i){
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {return result;}
        dfs(result,nums,new ArrayList<Integer>(),0);
        return result;
    }

    /**
     * 二叉回溯法。状态树是一个二叉树。
     * 这个方法应该是最好理解的一个方法了。
     * @param result
     * @param nums
     * @param list
     * @param level
     */
    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int level) {
        // terminal
        if (level == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // process current logic 可选择，或者不选择  // drill down
        dfs(result,nums,list,level+1);
        list.add(nums[level]);
        dfs(result,nums,list,level+1);
        // restore current status;
        list.remove(list.size()-1);
    }



//    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 这个方法没有等决策完成就是添加到结果中了，有点不易理解。这个记下吧
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets5(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }
    private void backtrack(int[] nums, List<Integer> set, int start){
        ans.add(new ArrayList<>(set));
        for(int i = start; i < nums.length; ++i){
            set.add(nums[i]);
            backtrack(nums, set,i + 1);
            set.remove(set.size() - 1);
        }
    }
}
