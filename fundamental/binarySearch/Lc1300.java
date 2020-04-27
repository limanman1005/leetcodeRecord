package binarySearch;

/**
 * ClassName: Lc1300
 * Description:
 * date: 2020/4/27 15:42
 *
 * @author liyh
 */
public class Lc1300 {
}

class Solution1300 {
    /**
     * 这题也是一个在整数的范围找到一个符合条件的数。用的二分查找。
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        int left = 1;
        //这个是根据题目给的范围选定的
        int right = 100000;
        //减治法的标准二分,根据找一个范围的解法，这种写法就是能找到一个边界。
        while(left < right){
            int mid = (left + right) >>> 1;
            if(check(arr, mid) < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        int ans1 = check(arr, left);
        int ans2 = check(arr, left - 1);
        if(target - ans2 > ans1 -target){
            return left;
        }
        else{
            return left - 1;
        }
    }
    public int check(int[] arr, int threshold){
        int sum = 0;
        for(int num: arr){
            sum += Math.min(num, threshold);
        }
        return sum;
    }
}
