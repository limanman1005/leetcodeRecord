package mySummary.binarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: GuessNum
 * Description:
 * date: 2020/4/26 21:54
 *
 * @author liyh
 */
public class GuessNum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());


    }
}
class Solution374 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid - 1;
            } else if (count == mid) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

