import java.util.Arrays;
import java.util.Enumeration;

/**
 * ClassName: HeapSortPratice
 * Description:
 * date: 2020/4/1 17:54
 *
 * @author liyh
 */
public class HeapSort0401 {
    public static void makeHeap(int[] nums){
        int len = nums.length;
        for(int i = len/2 - 1; i >= 0; --i){
            minHeapFix(nums, i, len - 1);
        }
    }

    private static void minHeapFix(int[] nums, int i, int len){
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left >= len){
            return;
        }
        int min = left;
        if(right >= len){
            min = left;
        }
        else if(nums[min] > nums[right]){
            min = right;
        }
        if(nums[min] < nums[i]){
            Util.swap(nums, i, min);
            minHeapFix(nums, min, len);
        }
    }


    public static void heapSort(int[] nums){
        makeHeap(nums);
        int len = nums.length;
        for(int i = len - 1; i >= 0; --i){
            Util.swap(nums, 0, i);
            minHeapFix(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, -100, 100);
        System.out.println(Arrays.toString(randomArr));
        makeHeap(randomArr);
        System.out.println(Arrays.toString(randomArr));
        heapSort(randomArr);
        System.out.println(Arrays.toString(randomArr));
        System.out.println(Util.isOrdered(randomArr));
    }
}
