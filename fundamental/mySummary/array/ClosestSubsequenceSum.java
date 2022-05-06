package mySummary.array;

import java.util.Arrays;

/**
 * ClassName: CloestSubsequenceSum
 * Description:
 * date: 27/4/2022 下午4:26
 *
 * @author liyh
 */
public class ClosestSubsequenceSum {
    public static void main(String[] args) {
        Solution1755 solution1755 = new Solution1755();
        int[] ints = new int[]{5, -7, 3, 5};
        int i = solution1755.minAbsDifference(ints, 6);
        System.out.println(i);
    }
}
class Solution1755{



    //todo 还有和此题有点像的题，日后需要做一下
    public int minAbsDifference(int[] nums, int goal) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int lSubsetLen = len / 2;
        int rSubsetLen = len - lSubsetLen;
        int[] lSum = new int[1 << lSubsetLen];
        int[] rSum = new int[1 << rSubsetLen];
        //找到左边子集的和，lSum存储的是下标数字代表的位数的子集和
        //小的数字一定已经被计算过了，所以只需一次相加
        for(int i = 1; i < (1 << lSubsetLen); ++i){
            for(int j = 0; j < lSubsetLen; j++){
                if((i & (1 << j)) == 0){
                    continue;
                }
                lSum[i] = lSum[i - (1 << j)] + nums[j];
                break;
            }
        }
        for(int i = 1; i < (1 << rSubsetLen); ++i){
            for(int j = 0; j < rSubsetLen; ++j){
                if((i & (1 << j)) == 0){
                    continue;
                }
                rSum[i] = rSum[i - (1 << j)] + nums[lSubsetLen + j];
                break;
            }
        }
        Arrays.sort(lSum);
        Arrays.sort(rSum);
        int ans = Integer.MAX_VALUE;
        for(int x : lSum){
            ans = Math.min(ans, Math.abs(x - goal));
        }
        for(int x : rSum){
            ans = Math.min(ans, Math.abs(x - goal));
        }
        //左右指针的设置的意思是缩小搜索空间。
        //每个数组中已经需要选择一个了，如果right指向最大的值且left指向最小的和比goal大，那么right可以向左移，left向右移。
        int left = 0;
        int right = rSum.length - 1;
        while(left < lSum.length && right >= 0){
            int sum = lSum[left] + rSum[right];
            ans = Math.min(ans, Math.abs(goal - sum));
            if(sum > goal){
                right--;
            }
            else{
                left++;
            }
        }
        return ans;
    }



    public void subsetSum(int[] nums){
        for (int i = 0; i < 10; ++i){
            for(int j = 0; j < 3; ++j){
                if((i  & (j << 3)) == 0){
                    break;
                }
                System.out.println("j = " + j);
                break;
            }
        }
    }

}
