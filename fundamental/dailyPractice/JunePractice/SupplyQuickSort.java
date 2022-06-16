package dailyPractice.JunePractice;

/**
 * ClassName: SupplyQuickSort
 * Description:
 * date: 16/6/2022 上午1:39
 *
 * @author liyh
 */
public class SupplyQuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[10];
        int min = 0;
        int max = 100;
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (max + 1 - min) + min);
        }
        quickSort.quickSort(arr, 0, arr.length - 1);
        for(int num : arr){
            System.out.println("num = " + num);
        }
    }
}

class QuickSort{


    public void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int idx = partition(nums, left, right);
        quickSort(nums, left, idx);
        quickSort(nums, idx + 1, right);
    }

    private int partition(int[] nums, int left, int right){
        int pivotIdx = (left + right) >>> 1;
        int tmp = nums[left];
        nums[left] = nums[pivotIdx];
        nums[pivotIdx] = tmp;
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] > pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] < pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
