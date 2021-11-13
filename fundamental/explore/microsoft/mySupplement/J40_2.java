package explore.microsoft.mySupplement;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: Main
 * Description:
 * date: 2020/7/30 13:49
 *
 * @author liyh
 */
public class J40_2 {
    public static void main(String[] args) {
        SolutionJ40_2 solution = new SolutionJ40_2();
        int[] arr = {3, 2, 1};
        int[] leastNumbers = solution.getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(leastNumbers));
    }
}

class SolutionJ40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k <= 0 || k > arr.length){
            return new int[0];
        }
        int left = 0, right = arr.length - 1;
        int index = partition(arr, left, right);
        while(index != k - 1){
            if(index < k - 1){
                left = index + 1;
            }
            else if(index > k - 1){
                right = index - 1;
            }
            else{
                break;
            }
            index = partition(arr, left, right);
        }
        return Arrays.copyOfRange(arr, 0, k);
    }
    private int partition(int[] arr, int left, int right){
        int pivotIndex = (left + right) >>> 1;
        int tmp = arr[left];
        arr[left] = arr[pivotIndex];
        arr[pivotIndex] = tmp;
        int pivot = arr[left];
        //放到左边了这个
        while(left < right){
            while(left < right && arr[right] <= pivot){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] >= pivot){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
