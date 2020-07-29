import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * ClassName: HeapSort0403
 * Description:
 * date: 2020/4/3 11:12
 *
 * @author liyh
 */
public class HeapSort0403 {

    public static void makeMaxHeap(int[] nums){
        int len = nums.length;
        //对每一个非叶子节点进行堆调整
        for(int i = len/2 - 1; i >= 0; --i){
            maxHeapFixDown(nums, i, len);
        }
    }

    private static void maxHeapFixDown(int[] nums, int i, int len) {
        //找到左右孩子节点的最大值（这里是最大堆）,注意左右孩子是否超界。
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left >= len){
            return;
        }
        int max = left;
        if(right >= len){
            max = left;
        }
        else if(nums[left] < nums[right]){
            max = right;
        }
        //找到左右孩子的节点之间的最大值之后和当前节点作比较，看需不需要交换。
        if (nums[i] >= nums[max]){
            return;
        }
        else{
            //如果需要交换的话，继续递归的把交换过后的节点和它的子节点进行比较。
            Util.swap(nums, i, max);
            maxHeapFixDown(nums, max, len);
        }
    }
    public static void heapSort(int[] nums){
        //求出len便于后面直接使用。
        int len = nums.length;
        //建堆
        makeMaxHeap(nums);
        //把堆顶一个个的挪向最后一个元素（这个最后一个元素是会变化的），直到挪无可挪。
        //当然挪完之后是需要修复的
        for(int i = len - 1; i >= 0; --i){
            //交换堆顶和目前的最后一个元素
            Util.swap(nums, 0, i);
            //把堆顶的元素进行调整，大小记得减一。即跟随i变化.并且这个i是不能取到的。这里重点理解下。
            maxHeapFixDown(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(12, -100, 100);
        System.out.println(Arrays.toString(randomArr));
        int[] clone = randomArr.clone();
        Arrays.sort(clone);
        System.out.println(Arrays.toString(clone));
        heapSort(randomArr);
        System.out.println(Arrays.toString(randomArr));
    }
}
