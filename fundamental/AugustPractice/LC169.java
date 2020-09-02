package AugustPractice;

/**
 * ClassName: AugustPractice.LC169
 * Description:
 * date: 2020/3/13 21:45
 * 此题找到一个数组中出现次数大于【n/2】的元素
 * @author liyh
 */
public class LC169 {
}

//解法一 使用分治思想
class Solution169_1{
    public int majorityElement(int[] nums) {
        return majorityElementHelper(nums, 0, nums.length-1);
    }
    public int majorityElementHelper(int[] nums, int lo, int hi){
        if(lo == hi){
            return nums[lo];
        }

        int mid = (hi - lo)/2 + lo;
        int left = majorityElementHelper(nums, lo, mid);
        int right = majorityElementHelper(nums, mid+1, hi);
        if(left == right){
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left: right;
    }
    public int countInRange(int[] nums, int num, int lo, int hi){
        int count = 0;
        for(int i = lo; i <= hi; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
}
//解法二 投票算法
class Solution169_2{
    //to do
}
