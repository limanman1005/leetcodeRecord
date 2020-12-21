package sort;


/**
 * ClassName: QuickSort
 * Description:
 * date: 2020/3/10 22:01
 * 这里是有关快排的题目。
 * @author liyh
 */
public class QuickSort {
    public static void quickSort(int[] nums, int l, int r){
        if( l < r){
            int q = partition(nums, l, r);
            quickSort(nums, l, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    /**
     * 使用首元素作为pivot,单侧指针扫描法
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int lp = l + 1;
        int rp = r;
        while(lp <= rp){
            if(nums[lp] >= pivot){
                lp++;
            }
            else{
                Util.swap(nums,lp, rp);
                rp--;
            }
        }
        //这一点注意由于取的pivot永远在左面，所以我们必须每次都和左边交换。
        Util.swap(nums, l, rp);
        return rp;
    }

    /**
     * 选取首元素为pivot，使用双侧指针扫描法
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static int partition2(int[] nums, int l, int r){
        int pivot = nums[l];
        int lp = l + 1;
        int rp = r;
        while(lp <= rp){
            while(lp<=rp && nums[lp]<=pivot){
                lp++;
            }
            while(lp<=rp && nums[rp]>pivot){
                rp--;
            }
            if(lp < rp){
                Util.swap(nums, lp, rp);
            }
        }
        Util.swap(nums, l, rp);
        return rp;
    }
    public static int partition3(int[] nums, int l, int r){
        int midIndex = l + (r - l)/2;
        int pivotIndex = -1;
        if((nums[l] > nums[r] && nums[l] < nums[midIndex]) || (nums[l] > nums[midIndex] && nums[l] < nums[r])){
            pivotIndex = l;
        }
        else if((nums[r] > nums[l] && nums[r] < nums[midIndex]) || (nums[r] > nums[midIndex] && nums[r] < nums[l])){
            pivotIndex = r;
        }
        else{
            pivotIndex = midIndex;
        }
        Util.swap(nums, l, pivotIndex);
        int pivot = nums[l];

        int lp = l + 1;
        int rp = r;
        while(lp <= rp){
            //这里两个条件的顺序不能换。
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
        //最后交换要用rp，为什么呢
        Util.swap(nums, l, rp);
        return rp;
    }



    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 0, 9, 6, 8, 9};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}