package JunePractice;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: KthLargestElementInArray
 * Description: 找到数组中最大的第k个数。
 * 一般有两种办法，一个是改造下快排，另一个是使用堆排序，这两个在面试中常考，重点中的重点
 * date: 2020/6/29 10:17
 *
 * @author liyh
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] arr = {4, 1, 7, 5};
        System.out.println(solution215.findKthLargest2(arr, 1));
    }
}

class Solution215 {
    Random random = new Random();

    /**
     * 这个是改造快排的方法
     * @param nums
     * @param k
     * @return
     */
    @Deprecated
    public int findKthLargest(int[] nums, int k) {
        //len - k将最大的转变成最小的索引
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    public int quickSelect(int[] a, int l, int r, int index){
        //随机找一个数字然后把他放到正确的位置上。
        int q = randomPartition(a, l, r);
        //如果这个数字正好是下标，直接返回
        if(q == index){
            return a[q];
        }
        else{
            //如果不是那么判断下大小然后中它的左边或者右边继续寻找。
            return q < index? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }
    public int randomPartition(int[] a, int l, int r){
        //随机找一个l到r之间的坐标
        int i = random.nextInt(r - l + 1) + l;
        //然后把选中的那个位置i交换到最右边的r上去。
        swap(a, i, r);
        //最后调用函数，把i位置上的数放到正确的位置上去。
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r){
        //此函数用来把r上的数放到正确的位置。
        int x = a[r], i = l - 1;
        for(int j = l; j < r; ++j){
            if(a[j] <= x){
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 这个也是快排的东西来做的。不过更清晰一点。感觉更好一点
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        //首先判断下边界条件
        if(k <= 0 || k > nums.length){
            return -1;
        }
        //然后确定边界
        int left = 0, right = nums.length - 1;
        //第一次分组。这个是按大到小排序的，所以不需要索引转换
        //里面就是选择一个数，然后把他放到正确的位置
        int index = partition2(nums, k, left, right);
        //如果不是第k大的（即在k - 1索引上的数）
        while(index !=  k - 1){
            //如果这次放到位置比期望的要小，那么说明要找的在右边
            if(index < k - 1){
                left = index + 1;
            }
            //同理，在左边
            else if(index > k - 1){
                right = index - 1;
            }
            //如果相等了就是找到了，不需要在随机找一个了，就跳出循环
            else{
                break;
            }
            //调整完范围后需要再找
            index = partition2(nums, k , left, right);
        }
        return nums[index];
    }

    /**
     * 这里的partition应成为我的划分模板
     * @param arr
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int partition2(int[] arr, int k, int start, int end){
        //这里找了一个中间的位置。避免极端情况
        int p = (start + end) /2;
        //这里把中间位置放到start上
        int tmp = arr[start];
        arr[start] = arr[p];
        arr[p] = tmp;
        //使用tmp存上pivot的值（这时候start存的是start的值）
        tmp = arr[start];
        //然后遍历start和end之间的数字
        //这里先找左边不满足情况的不能变
        while(start < end){
            //跳过右边小于tmp的数字，找到一个合适的end位置
            while(start < end && arr[end] <= tmp){
                end--;
            }
            //把end位置的数字放到start位置去
            arr[start] = arr[end];
            //找到一个合适的start位置
            while(start < end && arr[start] >= tmp){
                start++;
            }
            //把找到的合适的位置放到end上面去。
            arr[end] = arr[start];
        }
        //把选出来的那个数放到这时候已经到了尽头的start位置上，即可满足tmp左边的都大于tmp，右边的数组都小于tmp
        arr[start] = tmp;
        //返回当前tmp所在的位置。
        return start;
    }


    /**
     * 再补充一种写法，和第二种差不多，只不过使用递归来代替了循环
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length){
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }
    private int quickSort(int[] nums, int left, int right, int kth){
        if(left == right){
            return nums[left];
        }
        int idx = partition3(nums, left, right);
        if(idx == kth){
            return nums[kth];
        }
        if(idx < kth){
            return quickSort(nums, idx + 1, right, kth);
        }
        else{
            return quickSort(nums, left, idx - 1, kth);
        }
    }
    private int partition3(int[] nums, int left, int right){
        Random ran = new Random();
        int idx = left + ran.nextInt(right - left);
        int idxValue = nums[idx];
        nums[idx] = nums[left];
        nums[left] = idxValue;
        while(left < right){
            while(left < right && nums[right] >= idxValue){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= idxValue){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = idxValue;
        return left;
    }


    /**
     * 使用堆的做法，对的各种操作很重要，要牢记在心。
     * 建立一个全部元素的大顶堆，然后再删除k-1次，在栈顶的就是第k大的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest4(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length - 1; i >= nums.length - k + 1; --i){
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] a, int heapSize){
        for(int i = heapSize/2; i >= 0; --i){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i , int heapSize){
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if(left < heapSize && a[left] > a[largest]){
            largest = left;
        }
        if(right < heapSize && a[right] > a[largest]){
            largest = right;
        }
        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }
}