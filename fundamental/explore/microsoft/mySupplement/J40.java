package explore.microsoft.mySupplement;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: J40
 * Description: 剑指offer40题debug
 * date: 2020/7/30 14:44
 *
 * @author liyh
 */
public class J40 {
    public static void main(String[] args) {
        int[] arr = {0,  2,  8, 5, 29, -2, 6, 1, 3, 5, 10};
        SolutionJ40 solutionJ40 = new SolutionJ40();
//        int[] leastNumbers = solutionJ40.getLeastNumbers(arr, 1);
//        System.out.println(Arrays.toString(leastNumbers));
        solutionJ40.heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
class SolutionJ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || k <= 0){
            return null;
        }
        if(k >= arr.length){
            return arr;
        }
        makeMinHeap(arr);
        int heapSize = arr.length;
        for(int i = 0 ; i < k; ++i){
            swap(arr, 0, heapSize - 1);
            fixMinHeap(arr, 0, heapSize - 1);
            heapSize--;
        }
        return Arrays.copyOfRange(arr, 0, k);
    }
    private void makeMinHeap(int[] arr){
        int len = arr.length;
        for(int i = len / 2; i >= 0; --i){
            fixMinHeap(arr, i, len);
        }
    }

    private void fixMinHeap(int[] arr, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = left;
        if(left >= len){
            return;
        }
        if(right < len && arr[right] < arr[min]){
            min = right;
        }
        if(arr[min] < arr[i]){
            swap(arr, i, min);
            fixMinHeap(arr, min, len);
        }
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void heapSort(int[] arr){
        makeMinHeap(arr);
        int len = arr.length;
        for(int i = len - 1; i >= 0; --i){
            swap(arr, 0, i);
            fixMinHeap(arr, 0, i);
        }
    }
}
