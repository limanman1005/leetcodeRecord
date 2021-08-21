package mySummary.sort;

/**
 * ClassName: sort.QuickSort0316
 * Description:
 * date: 2020/3/16 21:31
 * 反复练习达到熟悉的水准
 * @author liyh
 */
public class QuickSort0316 {
    public static void quicksort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int pIndex = partition2(nums, l, r);
        quicksort(nums, l, pIndex - 1);
        quicksort(nums, pIndex + 1, r);
    }
    public static int partition1(int[] nums, int l, int r){
        int pivot = nums[l];
        int lp = l + 1;
        int rp = r;
        while(lp <= rp){
            if(nums[lp] <= pivot){
                lp++;
            }
            else{
                Util.swap(nums, lp, rp);
                rp--;
            }
        }
        Util.swap(nums, l, rp);
        return rp;
    }

    public static int partition2(int[] nums, int l, int r){
        int pivot = nums[l];
        int lp = l+1;
        int rp = r;
        while(lp <= rp){
            while(lp <= rp && nums[lp] <= pivot){
                lp ++;
            }
            while(lp <= rp && nums[rp] > pivot){
                rp--;
            }
            //这个还是防止运算的东西
            if(lp < rp){
                Util.swap(nums, lp, rp);
            }
        }
        Util.swap(nums, l, rp);
        return rp;
    }

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(15, -100, 100);
        quicksort(randomArr, 0, randomArr.length-1);
        for (int i : randomArr) {
            System.out.println(i);
        }
    }
}
