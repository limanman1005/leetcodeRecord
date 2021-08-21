package dailyPractice.JunePractice;

/**
 * ClassName: FirstMissingPositive
 * Description: 此类问题有个名字叫做原地hash。
 * 同类型的题还有442和448
 * date: 2020/6/27 11:42
 *
 * @author liyh
 */
public class FirstMissingPositive {
}

class Solution41 {
    /**
     * 这个题的思路就是使用原来的数组做成一个hash表。
     * 为了防止下标溢出，我们只考虑1到n之间的数
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i = 0; i< nums.length; ++i){
            //判断下是否是1到n之间的数字，并且当前数字做下标的那个数组里面的数组和自己不相等（这个是为了避免死循环）。我们把这两个数交换
            //这个用的while循环
            while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        //遍历找到第一个下标和数组里面的数字不相等的就是答案
        //检索范围是 1 到  n - 1。
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != i){
                return i;
            }
        }
        //经过了上面的哪一个循环之后，说明1 - (n - 1)都存在。并且检查了1到N - 1的位置。
        //这时候看一下位置0。如果位置0的数字为n。那么缺失的是n + 1。
        if(nums[0] == nums.length){
            return nums.length + 1;
        }
        //如果位置0不是n，那么1到n - 1都有了，答案就是n了。
        return nums.length;
    }
}
