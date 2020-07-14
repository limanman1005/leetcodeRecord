package middleAlgorithm.SortAndSearch;

/**
 * ClassName: SortColor
 * Description: 此题也叫做荷兰国旗问题
 * date: 2020/7/14 20:02
 *
 * @author liyh
 */
public class SortColor {
}
class Solution75 {
    /**
     * 计数排序法
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] memo = new int[3];
        for(int num : nums){
            memo[num]++;
        }
        int index = 0;
        for(int i = 0; i < memo.length; ++i){
            int size = memo[i];
            for(int j = 0; j < size; ++j){
                nums[index++] = i;
            }
        }
    }


    /**
     * 加一个一趟扫秒法
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for(int i = 0; i <= p2; ++i){
            if(nums[i] == 0){
                swap(nums, i, p0++);
            }
            else if(nums[i] == 2){
                //这里i--有点难理解。
                swap(nums, i--, p2--);
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 补充一个好理解的
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int p0 = 0, cur = 0;
        int p2 = nums.length - 1;
        int tmp;
        while(cur <= p2){
            if(nums[cur] == 0){
                tmp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            }
            else if(nums[cur] == 2){
                tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = tmp;
            }
            else{
                cur++;
            }
        }
    }
}



}