package explore.juniorAlgorithm.array;

/**
 * ClassName: RemoveDuplicateInSortedArray
 * Description:删除排序数组里面的重复元素，并返回删除后的数组长度
 * 这题使用双指针法即可，这个是同侧的双指针
 * date: 2020/5/25 10:30
 *
 * @author liyh
 */
public class RemoveDuplicateInSortedArray {
}
class Solution26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }

        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                //注意这里是++p
                nums[++p] = nums[q];
            }
            q++;
        }
        //这里隐含了对len == 1的特判
        return p + 1;
    }
}
