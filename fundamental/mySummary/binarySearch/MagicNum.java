package mySummary.binarySearch;

/**
 * ClassName: MagicNum lc上的面试题
 * Description: 这个题没过，暂时放一下
 * date: 2020/4/22 11:10
 *
 * @author liyh
 */
public class MagicNum {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, 4, 5};
        System.out.println(new SolutionTest().findMagicIndex(arr));
    }
}

class SolutionTest {
    public int findMagicIndex(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = (left + right) >>> 1;
        while(left < right){
            if(nums[mid] == mid){
                right = mid;
            }
            else if(nums[mid] < mid){
                left = mid + 1;
            }
            else{
                left = mid + 1;
            }
            mid = (left + right) >>> 1;
        }
        return left;
    }
}
