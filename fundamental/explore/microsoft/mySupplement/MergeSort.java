package explore.microsoft.mySupplement;
import java.util.Arrays;

/**
 * ClassName: MergeSort
 * Description: 归并排序，使用归并算逆序数
 * date: 2020/7/29 18:33
 *
 * @author liyh
 */
public class MergeSort {
    public static void main(String[] args) {
        Solution_j51 solution_j51 = new Solution_j51();
        int[] arr = {1, 2, 3, 4};
        int i = solution_j51.reversePairs(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));

    }
}
class Solution_j51 {
    private int ans = 0;
    private int[] tmp;
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }
    private void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return ;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeArray(nums, left, mid, right);
    }

    private void mergeArray(int[] nums, int left, int mid, int right){
        System.arraycopy(nums, left, tmp, left, right - left + 1);
        int lp = left;
        int rp = mid + 1;
        int op = left;
        while(lp <= mid && rp <= right){
            if(tmp[lp] <= tmp[rp]){
                nums[op++] = tmp[lp++];
            }
            else{
                nums[op++] = tmp[rp++];
                ans += mid - lp + 1;
            }
        }
        while(lp <= mid){
            nums[op] = tmp[lp];
            op++;
            lp++;
        }
    }
}
