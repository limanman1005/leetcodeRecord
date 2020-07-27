import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: MergeSort0319
 * Description: 归并排序另有非递归解法，见大话数据结构
 * date: 2020/3/19 14:21
 *
 * @author liyh
 */
public class MergeSort0319 {

    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        mergeArray(nums, left, mid, right);
    }

    private static void mergeArray(int[] nums, int left, int mid, int right){
        int[] copy = Arrays.copyOf(nums, nums.length);
        int lp = left;
        int rp = mid+1;
        int cur = left;
        while(lp <= mid && rp <= right){
            if(copy[lp] <= copy[rp]){
                nums[cur++] = copy[lp++];
            }
            else{
                nums[cur++] = copy[rp++];
            }
        }
        while(lp <= mid){
            nums[cur++] = copy[lp++];
        }
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10, -100, 100);
        int[] clone = arr.clone();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        mergeSort(clone, 0, arr.length-1);
        System.out.println(Arrays.toString(clone));
    }
}
