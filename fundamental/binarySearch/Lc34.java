package binarySearch;

import java.util.Arrays;

/**
 * ClassName: Lc34
 * Description: 找一个范围
 * date: 2020/4/20 13:39
 *
 * @author liyh
 */
public class Lc34 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3};
        System.out.println(new Solution34_2().searchLowerBound(arr, 2));
    }
}

class Solution34{
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if(nums.length == 0){
            return ans;
        }
        ans[0] = findFirst(nums, target);
        if(ans[0] == -1){
            return ans;
        }
        ans[1] = findLast3(nums, target);
        return ans;
    }
    public int findFirst(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            //如何得到这个判断，首先要考虑就是相等的时候，不能停，把右边的边界更新为当前mid即可。
            //这个mid的取法偏左，不担心陷入死循环。
            int mid = (left + right) >>> 1;
           if(target > arr[mid]){
               left = mid + 1;
           }
           else if(target == arr[mid]){
               right = mid;
           }
           else{
               right = mid - 1;
           }
        }
        return arr[left] == target? left: -1;
    }
    public int findLast(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            //这个思考和上面相似，结论相反。
            if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid;
            }
        }
        return target == arr[left]? left : -1;
    }

    public int findFirst2(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(target < arr[mid]){
                right = mid;
            }
            else if(target == arr[mid]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return target == arr[left]? left : -1;
    }
    public int findLast2(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int mid = (left + right + 1) >>> 1;
            if(target < arr[mid]){
                right = mid - 1;
            }
            else if(target == arr[mid]){
                left = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return target == arr[left]? left: -1;
    }
    public int findLast3(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if(target < arr[mid]){
                right = mid - 1;
            }
            else if(target == arr[mid]){
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return target == arr[left]? left: -1;
    }

    public int findLowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            //这个啊，就是由于这个mid的选取是偏左的，这时候，必须要有left+1才行，使用这样的方法使循环终结
            int mid = (left + right) >>> 1;
            if(target > arr[mid]){
                left = mid + 1;
            }
            else if(target == arr[mid]){
                right = mid;
            }
            else{
                right = mid;
            }
        }
        return  arr[left] == target ? left: -1;
    }

    public int findUpperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right + 1)>>>1;
            if(target < arr[mid]){
                right = mid - 1;
            }
            //这个条件定死了，碰到了左边界不能停，要继续把mid赋给左边界。（向右找），所以上面必须使用向上取值法。
            //向上取值保证了左边界可以不+1。就向右移动了。不会陷入死循环。
            //为了这个条件我们必须在取mid的时候向右取一位，right必须要向左减一，保证right有可能和left相等。
            else if(target == arr[mid]){
                left = mid;
            }
            else{
                left = mid;
            }
        }
        return target == arr[left]? left: -1;
    }
}
class Solution34_2{
    public int searchLowerBound(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        //写等号会不知道什么时候可以跳出循环。这样写是不行的。
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(target == nums[mid]){
                right = mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return left;
    }
}