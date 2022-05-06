package offer;

/**
 * ClassName: Offer068
 * Description:
 * date: 4/5/2022 下午4:32
 *
 * @author liyh
 */
public class Offer068 {
    public static void main(String[] args) {
        SolutionOffer068 solutionOffer068 = new SolutionOffer068();
        int[] arr = {1, 3, 5, 6};
        int insert = solutionOffer068.searchInsert(arr, 2);
        System.out.println(insert);
    }
}
class SolutionOffer068 {


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    /**
     * leetcode加加的寻找最左边插入位置的模板，根据分析，left和right都可以用mid-1
     * 所以while可以使用等号。最后返回left的位置即可。这个就是一个模板记住关键点就好了。
     * 可以找到最左边符合位置的条件。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] >= target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
