import java.util.Arrays;

/**
 * ClassName: MergeSort0401
 * Description:这个类就用来使用归并排序
 * date: 2020/4/1 10:53
 *
 * @author liyh
 */
public class MergeSort0401 {

    public static int reverseNum;
    private static int[] copy;


    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeArray(nums, left, mid, right);
    }

    private static void mergeArray(int[] nums, int left, int mid, int right) {
//        int[] copy = Arrays.copyOf(nums, nums.length);
        //这个可以使用节省一点时间，全部copy太费时间了
        System.arraycopy(nums, left, copy, left, right - left + 1);
        int lp = left;
        int rp = mid + 1;
        int cur = left;
        while(lp <= mid && rp <= right){
            if(copy[lp] <= copy[rp]){
                nums[cur++] = copy[lp++];
            }
            else{
                nums[cur++] = copy[rp++];
                reverseNum += mid - lp + 1;
            }
        }
        while(lp <= mid){
            nums[cur++] = copy[lp++];
        }

    }

    public static void main(String[] args) {
        int[] randomArr = {7,5, 6, 4 };
        int[] clone = randomArr.clone();
        System.out.println(Arrays.toString(clone));
        mergeSort(clone, 0, clone.length-1);
        System.out.println(reverseNum);
        Arrays.sort(clone);
        System.out.println(Arrays.toString(clone));
        mergeSort(randomArr, 0, randomArr.length-1);
        System.out.println(Arrays.toString(randomArr));
//        MergeSortPractice mergeSortPractice = new MergeSortPractice();
//        mergeSortPractice.mergeSort(randomArr, 0, randomArr.length - 1);
//        System.out.println(Arrays.toString(randomArr));
    }
}

class MergeSortPractice{
    public void mergeSort(int[] arr, int left, int right){
        if(left >= right){
            return ;
        }
        int mid = (left + right) >>> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeArray(arr, left, mid, right);
    }

    private void mergeArray(int[] arr, int left, int mid, int right){
        int[] copy = Arrays.copyOf(arr, arr.length);
        int lp = left;
        int rp = mid + 1;
        int cur = left;
        while(lp <= mid && rp <= right){
            if(copy[lp] >= copy[rp]){
                arr[cur++] = copy[rp++];
            }
            else{
                arr[cur++] = copy[lp++];
            }
        }
        while(lp <= mid){
            arr[cur++] = copy[lp++];
        }
    }
}
