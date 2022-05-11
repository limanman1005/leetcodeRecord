package offer;

/**
 * ClassName: Offer076
 * Description:
 * date: 6/5/2022 下午5:18
 *
 * @author liyh
 */
public class Offer076 {
}
class SolutionOffer076{
    /**
     * 使用快排的计算方法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int idx = pratition(nums, start, end);
        while(idx != target){
            if(idx > target){
                end = idx - 1;
            }
            else if(idx < target){
                start = idx + 1;
            }
            idx = pratition(nums, start, end);
        }
        return nums[idx];
    }

    private int pratition(int[] nums, int start, int end){
        int pivot = nums[start];
        int lp = start + 1;
        int rp = end;
        while(lp <= rp){
            while(lp <= rp && nums[lp] <= pivot){
                lp++;
            }
            while(lp <= rp && nums[rp] >= pivot){
                rp--;
            }
            if(lp < rp){
                swap(nums, lp, rp);
            }
        }
        swap(nums, start, rp);
        return rp;
    }

    private void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
