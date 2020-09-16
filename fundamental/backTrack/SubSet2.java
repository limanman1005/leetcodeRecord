package backTrack;

import java.util.*;

/**
 * ClassName: SubSet2
 * Description: 子集的第二题使用了set进行去重
 * date: 2020/9/13 23:03
 *
 * @author liyh
 */
public class SubSet2 {
}
class Solution {

    public HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public LinkedList<Integer> curList = new LinkedList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
}
