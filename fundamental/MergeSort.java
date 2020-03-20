import java.awt.*;

/**
 * ClassName: MergeSort
 * Description:
 * date: 2020/3/16 23:19
 * 归并排序
 * @author liyh
 */
public class MergeSort {

    private static int[] helper;

    public static void mergeSort(int[] nums, int l, int r){
        if(l < r){
            int mid = l + (r - l)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        System.arraycopy(nums, l, helper, l, r - l + 1);
        int left = l;
        int right = mid + 1;
        int current = l;
        while(left <= mid && right <= r){
            if(helper[left] <= helper[right]){
                nums[current++] = helper[left++];
            }else{
                nums[current++] = helper[right++];
            }
        }
        while(left <= mid){
            nums[current++] = helper[left++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 4, 1, 0, 90};
        helper = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
