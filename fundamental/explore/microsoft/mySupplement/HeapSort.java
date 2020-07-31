package explore.microsoft.mySupplement;

import java.util.Arrays;

/**
 * ClassName: HeapSort
 * Description:
 * date: 2020/7/30 10:16
 *
 * @author liyh
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 9, 5, 6, 10, 2, 20, -9, 99, 13, 21, 0, -1};
        int[] ints = Arrays.copyOfRange(arr, 0, 1);
        System.out.println(Arrays.toString(ints));
//        Solution215_2 solution215_2 = new Solution215_2();
//        solution215_2.headSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
class Solution215_2{
    public void makeHeap(int[] arr){
        int len = arr.length;
        for(int i = len/2; i >= 0; --i){
            fixMinHeap(arr, i, len);
        }
    }

    private void fixMinHeap(int[] arr, int i, int len) {
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

    private void swap(int[] arr, int i, int min) {
        int tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp;
    }

    public void headSort(int[] arr){
        makeHeap(arr);
        int len = arr.length;
        for(int i = len - 1; i >= 0; --i){
            swap(arr, 0, i);
            fixMinHeap(arr, 0, i);
        }
    }
}