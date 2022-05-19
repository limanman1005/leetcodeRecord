package inAndOut;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2020/8/30 13:18
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args){
        SolutionTest solutionTest = new SolutionTest();
        int[] arr = {3, 1, 2, 4};
        int i = solutionTest.reversePairs(arr);

    }
}
class SolutionTest {
    private int[] copy;
    private int reverseNum;
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        copy = new int[len];
        int width = 1;
        while(width < len){
            mergeWidth(nums, width);
            width *= 2;
        }
        return reverseNum;
    }
    private void mergeWidth(int[] nums, int width){
        int start = 0;
        int mid = start + width - 1;
        int end = start + 2 * width - 1;
        while(end < nums.length){
            mergeArr(nums, start, mid, end);
        }
        if(mid < nums.length){
            mergeArr(nums, start, mid, nums.length - 1);
        }
    }


    private void mergeArr(int[] nums, int start, int mid, int end){
        int lp = start, rp = mid + 1, cur = start;
        System.arraycopy(nums, start, copy, start, end - start + 1);
        while(lp <= mid && rp <= end){
            if(copy[lp] <= copy[rp]){
                nums[cur++] = copy[lp++];
            }
            else{
                nums[cur++] = copy[rp++];
                reverseNum += rp - mid + 1;
            }
        }
        while(lp <= mid){
            nums[cur++] = copy[lp++];
        }
    }
}