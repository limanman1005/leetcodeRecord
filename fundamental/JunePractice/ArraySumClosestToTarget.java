package JunePractice;

/**
 * ClassName: ArraySumClosestToTarget
 * Description:
 * date: 2020/6/14 22:22
 *
 * @author liyh
 */
public class ArraySumClosestToTarget {
    public static void main(String[] args) {
        Solution1300 solution1300 = new Solution1300();
        int[] arr = {2, 3, 5};
        System.out.println(solution1300.findBestValue(arr, 10));
    }
}

class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        int right = target;
        int left = 0;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if(countSum(arr, mid) > target){
                right = mid - 1;
            }
            else{
                left = mid;
            }
        }
        return left;
    }

    private int countSum(int[] arr, int num){
        int sum = 0;
        for(int n: arr){
            sum += Math.min(num, n);
        }
        return sum;
    }
}