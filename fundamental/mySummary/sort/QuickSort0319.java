package mySummary.sort;

import java.util.Arrays;

/**
 * ClassName: sort.QuickSort0319
 * Description:
 * date: 2020/3/19 13:43
 *
 * @author liyh
 */
public class QuickSort0319 {
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left,  pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right){
        int pivotIndex = left;
        int mid = left + (right - left)/2;
        if((nums[mid] >= nums[left] && nums[mid] < nums[right]) || (nums[mid] >= nums[right] && nums[mid] < nums[right])){
            pivotIndex = mid;
        }
        else if((nums[right] >= nums[left] && nums[right] < nums[mid]) || (nums[right] >= nums[mid] && nums[right] < nums[left])){
            pivotIndex = right;
        }
        int pivot = nums[pivotIndex];
        Util.swap(nums, pivotIndex, left);
        int lp = left + 1;
        int rp = right;
        while(lp <= rp){
            while (lp <= rp && nums[lp] <= pivot){
                lp++;
            }
            while(lp <= rp && nums[rp] > pivot){
                rp--;
            }
            if(lp < rp){
                Util.swap(nums, lp, rp);
            }
        }
        //这里交换rp是因为lp可能会超出范围吗？
        Util.swap(nums, left, rp);
        return rp;
    }

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(15, -100, 100);
        quickSort(randomArr, 0, randomArr.length-1);
        System.out.println(Arrays.toString(randomArr));
        System.out.println(Util.isOrdered(randomArr));
    }
}
