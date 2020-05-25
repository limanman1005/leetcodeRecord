package juniorAlgorithm.array;

import java.util.HashSet;

/**
 * ClassName: ContainsDuplicateNum1
 * Description: 此题是判断一个数组里面有没有重复的元素。直接使用了HashSet
 * 这题leetcode有扩展
 * date: 2020/5/25 11:22
 *
 * @author liyh
 */
public class ContainsDuplicateNum1 {
}
class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
