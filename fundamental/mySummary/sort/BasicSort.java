package mySummary.sort;

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
        MergeSortLoop mergeSortLoop = new MergeSortLoop();
        int[] test = new int[]{1, 5, 2,13, 14, 1, 2,  9, 6, 3, 10, 4, 7, 8, 11};
        mergeSortLoop.mergeSort2(test);

//        mergeSort.mergeSort(test);
        System.out.println(Arrays.toString(test));
//        System.out.println(mergeSort.reverseNum);
        while(true){

        }
    }
}
class SimpleSort{

}
class MergeSort{
    private int[] copy;
    public int reverseNum = 0;
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
class MergeSortLoop{
    private int[] copy;
    public void mergeSort(int[] arr){
        if(arr == null || arr.length == 0){
            return ;
        }
        //使用一个copy，便于后面mergeArr函数一样。
        copy = new int[arr.length];
        //这个控制宽度
        int width = 1;
        //循环终止条件就是宽度小于len
        while(width < arr.length){
            //调用函数进行分段合并
            mergePass(arr, width);
            //宽度翻倍
            width *= 2;
        }
    }


    private void mergePass(int[] arr, int width){
        //根据width算出两两合并的数组的范围
        int start = 0;
        int mid = start + width - 1;
        int end = start + 2 * width - 1;
        //将所有这个宽度的数组进行两两合并
        while(end < arr.length){
            mergeArr2(arr, start, mid, end);
            //更新start，mid和end
            start = start + 2 * width;
            mid = start + width - 1;
            end = start + 2 * width - 1;
        }
        //确保边界情况也被合并进去了。
        if(mid < arr.length){
            mergeArr2(arr, start, mid, arr.length - 1);
        }
    }

    /**
     * 这个mergerArr不够优雅，还是之前写的比较优雅
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    @Deprecated
    private void mergeArr(int[] arr, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
//        System.arraycopy(arr, start, copy, start, end - start + 1);
        int[] tmp = new int[end - start + 1];
        int idx = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                tmp[idx++] = arr[i++];
            }
            else{
                tmp[idx++] = arr[j++];
            }
        }
        while(i <= mid){
            tmp[idx++] = arr[i++];
        }
        while(j <= end){
            tmp[idx++] = arr[j++];
        }
        for(int k = start; k <= end; ++k){
            arr[k] = tmp[k - start];
        }
    }
    private void mergeArr2(int[] arr, int start, int mid, int end){
        System.arraycopy(arr, start, copy, start, end - start + 1);
        int lp = start;
        int rp = mid + 1;
        int parr = start;
        while(lp <= mid && rp <= end){
            if(copy[lp] <= copy[rp]){
                arr[parr++] = copy[lp++];
            }
            else{
                arr[parr++] = copy[rp++];
            }
        }
        while(lp <= mid){
            arr[parr++] = copy[lp++];
        }
    }

    public void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        int len = arr.length;
        copy = new int[len];
        int width = 1;
        while(width < len){
            mergePass2(arr, width);
            width *= 2;
        }
    }

    private void mergePass2(int[] arr, int width){
        int start = 0;
        int mid = start + width - 1;
        int end = start + 2 * width - 1;
        while(end < arr.length){
            mergeArr2(arr, start, mid, end);
            start = start + width * 2;
            mid = start + width - 1;
            end = start + width * 2 - 1;
        }
        //边界情况不能忘
        if(mid < arr.length){
            mergeArr2(arr, start, mid, arr.length - 1);
        }
    }
}
