package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindKCloestNum
 * Description:
 * date: 2020/4/27 11:42
 *
 * @author liyh
 */
public class FindKClosestNum {
}

class Solution658 {
    /**
     * 这个方法的核心就是使用二分法找到左边界。然后以此向后加k个数得到区间
     * 一些细节还待整理，但是这个代码的思路倒是好记。暂时这样吧。
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - k;
        while(left < right){
            int mid = (left + right) >>> 1;
            //mid就是目前判断的左区间待选值
            //这个条件就是x-arr[mid]（x距离arr【mid】的距离）比arr【mid】距离x的距离要大。
            //mid选取的偏左了。所以待选值的区间删去left到mid部分，将left变为mid加1
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }
            //这时那个相反的情况，我们直接使用right=mid。不用考虑那么多。
            else{
                right = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i < left + k; ++i){
            ans.add(arr[i]);
        }
        return ans;
    }
}
