package mySummary.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName: HeapSort
 * Description:
 * date: 2020/4/1 17:21
 *
 * @author liyh
 */
public class HeapSort {


    public static void makeMinHeap(int[] nums){
        int len = nums.length;
        for(int i = len/2 - 1; i >= 0; i--){
            minHeapFixDown(nums, i, len);
        }
    }

    private static void minHeapFixDown(int[] nums, int i, int len) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        //找和左右孩子节点中的最小值。
        if(left >= len){
            return;
        }
        int min = left;
        if(right >= len){
            min = left;
        }
        else{
            if(nums[right] < nums[left]){
                min = right;
            }
        }
        //如果nums[i]比两个孩子都要小，不用调整
        if(nums[i] <= nums[min]){
            return;
        }
        //否则顶点和两个孩子中的较小的交换。
        Util.swap(nums, i, min);
        minHeapFixDown(nums, min, len);
    }


    public static void heapSort(int[] nums){
        makeMinHeap(nums);
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--){
            Util.swap(nums, 0, i);
            minHeapFixDown(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, -100, 100);
        System.out.println(Arrays.toString(randomArr));
        makeMinHeap(randomArr);
        System.out.println(Arrays.toString(randomArr));
        heapSort(randomArr);
        System.out.println(Arrays.toString(randomArr));
        PriorityQueue<Integer> integers = new PriorityQueue<>(36, (l1, l2) -> l2 - l1);

    }

    /**
     * ClassName: HeapSortPratice
     * Description:
     * date: 2020/4/1 17:54
     *
     * @author liyh
     */
    public static class HeapSort0401 {
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
}
