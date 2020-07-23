package middleAlgorithm.SortAndSearch;

/**
 * ClassName: SearchInRotateSortedArray
 * Description: 把有序数组绕某一点排序后搜索。lc33题
 * date: 2020/7/16 11:24
 * 还有其他的解法，不过等下再看吧
 * @author liyh
 */
public class SearchInRotateSortedArray {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] arr = {4,5,6,7,0,1,2};
        int search = solution33.search(arr, 0);
    }
}

class Solution33 {
    /**
     * 对于旋转过后，进行分类讨论下确定怎么样缩小空间
     * 旋转过后把数组分成两段。一段是有序的另一端是缩小版的旋转数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target){
                return mid;
            }
            //这个条件代表，mid在左边有序的序列里面。
            if(nums[mid] >= nums[left]){
                //然后进一步判断，要找的目标值在比mid小，且比left最left值要大。说明target在mid的左边
                //这时候right =  mid - 1;
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }
                //剩下的都是都是left向左移
                else{
                    left = mid + 1;
                }
            }
            else{
                //这里同理
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

