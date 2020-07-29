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
        int[] copy = Arrays.copyOf(nums, nums.length);
        int lp = left;
        int rp = mid + 1;
        int cur = left;
        while(lp <= mid && rp <= right){
            if(copy[lp] <= copy[rp]){
                nums[cur++] = copy[lp++];
            }
            else{
                nums[cur++] = copy[rp++];
                reverseNum += mid - left + 1;
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
//        Arrays.sort(clone);
//        System.out.println(Arrays.toString(clone));
//        mergeSort(randomArr, 0, randomArr.length-1);
//        System.out.println(Arrays.toString(randomArr));
    }
}
