package offer.no10SearchAndSort;

/**
 * ClassName: DebugOffer076
 * Description:
 * date: 16/5/2022 上午1:04
 *
 * @author liyh
 */
public class DebugOffer076 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2,4,5,5,6};
        SolutionOffer076Debug solutionOffer076Debug = new SolutionOffer076Debug();
        int kthLargest = solutionOffer076Debug.findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }
}

class SolutionOffer076Debug {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int idx = partition(nums, 0, len - 1);
        while(idx != k - 1){
            if(idx > k - 1){
                idx = partition(nums, 0, idx - 1);
            }
            else{
                idx = partition(nums, idx + 1, len - 1);
            }
        }
        return nums[idx + 1];
    }

    /**
     * 升序的partition貌似有问题啊，这是为什么，算了暂时按下不表了
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right){
        int pivotIdx = left;
        int p1 = left + 1;
        int p2 = right;
        while(p1 <= p2){
            while(p1 <= p2 && nums[p1] > nums[pivotIdx]){
                p1++;
            }
            while(p1 <= p2 && nums[p2] < nums[pivotIdx]){
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
