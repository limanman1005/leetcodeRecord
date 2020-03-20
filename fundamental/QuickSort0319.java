import java.util.Arrays;
import java.util.UUID;

/**
 * ClassName: QuickSort0319
 * Description:
 * date: 2020/3/19 13:43
 *
 * @author liyh
 */
public class QuickSort0319 {
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex-1);
        quickSort(nums, pivotIndex+1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lp = left + 1;
        int rp = right;
        while(lp <= rp){
            while(lp <= rp && nums[lp] <= pivot){
                lp++;
            }
            while(lp <= rp && nums[rp] > pivot){
                rp--;
            }
            if(lp < rp){
                Util.swap(nums, lp, rp);
            }
        }
        Util.swap(nums, left, rp);
        return rp;
    }



    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, -100, 100);
        quickSort(randomArr, 0, randomArr.length-1);

        for (int i : randomArr) {
            System.out.println(i);
        }
    }
}
