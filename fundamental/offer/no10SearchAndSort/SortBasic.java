package offer.no10SearchAndSort;

import java.util.Arrays;

/**
 * ClassName: SortBasic
 * Description:
 * date: 16/5/2022 上午12:20
 *
 * @author liyh
 */
public class SortBasic {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,9};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for(int num : arr){
            System.out.println("num = " + num);
        }
    }
}

class QuickSort{

    public void quickSort(int[] nums, int left, int right){

        if(left >= right){
            return ;
        }
        int partIdx = partition(nums, left, right);
        quickSort(nums, left, partIdx);
        quickSort(nums, partIdx + 1, right);
    }

    private int partition(int[] nums, int left, int right){
        int pivotIdx = left;
        int p1 = left + 1;
        int p2 = right;
        while(p1 <= p2){
            while(p1 <= p2 && nums[p1] < nums[pivotIdx]){
                p1++;
            }
            while(p1 <= p2 && nums[p2] > nums[pivotIdx]){
                p2--;
            }
            if(p1 < p2){
                swap(nums, p1, p2);
            }
        }
        swap(nums, pivotIdx, p2);
        return p2;

    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
