package sort;

import java.util.Arrays;

/**
 * ClassName: BasicSort
 * Description:
 * date: 2020/9/9 11:09
 *
 * @author liyh
 */
public class BasicSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] test = new int[]{1, 5, 2, 9, 6};
        mergeSort.mergeSort(test);
        System.out.println(Arrays.toString(test));
    }
}
class SimpleSort{

}
class MergeSort{
    private int[] copy;
    private int reverseNum = 0;
    public void mergeSort(int[] arr){
        int len = arr.length;
        copy = new int[len];
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right){
        if(left >= right){
            return ;
        }
        int mid = (left + right) >>> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeArr(arr, left, mid, right);
    }
    private void mergeArr(int[] arr, int left, int mid, int right){
        System.arraycopy(arr, left, copy, left, right - left + 1);
        int lp = left, rp = mid + 1;
        int cur = left;
        //lp和rp不要和left, right弄混了。
        while(lp <= mid && rp <= right){
            if(copy[lp] <= copy[rp]){
                arr[cur++] = copy[lp++];
            }
            else{
                arr[cur++] = copy[rp++];
                reverseNum += mid - lp + 1;
            }
        }
        while (lp <= mid){
            arr[cur++] = copy[lp++];
        }
    }
}
