package mySummary.array;

import java.util.Arrays;

/**
 * ClassName: NextPermutation
 * Description:
 * date: 19/5/2022 下午5:03
 *
 * @author liyh
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution031 solution031 = new Solution031();
        int[] arr = {1, 3, 2};
        solution031.nextPermutation(arr);
        for (int num: arr){
            System.out.println(num);
        }
    }
}
class Solution031{
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int firstIncreIdx = -1;
        //找到倒着找第一个升序的对的下标
        for(int i = len - 2; i >= 0; --i){
            if(nums[i] < nums[i + 1]){
                firstIncreIdx = i;
                break;
            }
        }
        if(firstIncreIdx == -1){
            Arrays.sort(nums);
            return ;
        }else{
            //倒着遍历寻找第一个比下标firstIdx大的元素，保证在之前的元素中没有出现过
            //然后交换两个元素，最后保证i之后的下标是一个升序的序列即可
            int j = len - 1;
            while(j >= 0 && nums[firstIncreIdx] >= nums[j]){
                j--;
            }
            swap(nums, firstIncreIdx, j);
            Arrays.sort(nums, firstIncreIdx + 1, len);
        }


    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 这个写法更优雅，整个算法分三步
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int len = nums.length;
        //第一步找到从len - 2 开始找数组的顺序对
        int firstOrderIdx = -1;
        for(int i = len - 2; i >= 0; --i){
            if(nums[i] < nums[i + 1]){
                firstOrderIdx = i;
                break;
            }
        }
        //特殊情况不存在顺序对，按照题目要求返回最小的顺序排列
        if(firstOrderIdx == -1){
            Arrays.sort(nums);
        }
        else{
            //第二步：从len - 1找到第一个比firstOrderIdx大的数，进行交换
            for(int i = len - 1; i >= 0; --i){
                if(nums[i] > nums[firstOrderIdx]){
                    swap(nums, i, firstOrderIdx);
                    break;
                }
            }
            //第三步：将firstIdx后面的进行从小到达排序
            Arrays.sort(nums, firstOrderIdx + 1, len);
        }
        return ;
    }
}
