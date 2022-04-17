package mySummary.backTrack;

import java.util.*;

/**
 * ClassName: SubSet2
 * Description: 子集的第二题使用了set进行去重
 * date: 2020/9/13 23:03
 *
 * @author liyh
 */
public class SubSet2 {
    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        int[] test = {1, 2, 2};
        List<List<Integer>> lists = solution90.subsetsWithDup3(test);
        lists.forEach(System.out::println);

    }
}
class Solution90 {

    public HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public LinkedList<Integer> curList = new LinkedList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序之后以便Set去重。
        Arrays.sort(nums);
        HashSet<List<Integer>> set = this.set;
        List<List<Integer>> lists = this.lists;
        LinkedList<Integer> curList = this.curList;
        helper(0, nums, curList, lists, set);
        lists.add(new ArrayList<Integer>());
        return lists;
    }
    public void helper(int n, int[] nums, LinkedList<Integer> curList, List<List<Integer>> lists, HashSet<List<Integer>> set){
        if(n>= nums.length){
            return ;
        }
        curList.add(nums[n]);
        if(!set.contains(curList)){
            lists.add(new ArrayList<Integer>(curList));
            set.add(new ArrayList<Integer>(curList));
        }
        helper(n+1, nums, curList, lists, set);
        curList.removeLast();
        helper(n+1, nums, curList, lists, set);
    }



    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 此方法在递归的路上将自己给搞定了
     * 有重复元素的子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        if(nums == null || nums.length == 0){
            return ans;
        }
        //提前sort然后再和上一个元素比较进行去重的操作
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }



    private void dfs(int[] nums, int start, List<Integer> curSet){
        ans.add(new ArrayList<>(curSet));
        for(int i = start; i < nums.length; ++i){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            curSet.add(nums[i]);
            dfs(nums, i + 1, curSet);
            curSet.remove(curSet.size() - 1);
        }
    }


    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        if(nums == null || nums.length == 0){
            return ans;
        }
        //提前sort然后再和上一个元素比较进行去重的操作
        Arrays.sort(nums);
        dfs2(nums, 0, new ArrayList<>());
        ans.add(new ArrayList<>());
        return ans;
    }



    private void dfs2(int[] nums, int start, List<Integer> curSet){
        //这个不是从零开始的，所以不需要和全排列去重那样，多加一个条件判断在不在同一层。
        for(int i = start; i < nums.length; ++i){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            curSet.add(nums[i]);
            ans.add(new ArrayList<>(curSet));
            dfs2(nums, i + 1, curSet);
            curSet.remove(curSet.size() - 1);
        }
    }
}
