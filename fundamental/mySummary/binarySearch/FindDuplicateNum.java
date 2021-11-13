package mySummary.binarySearch;

/**
 * ClassName: FindDuplicateNum
 * Description: 二分法的应用
 * date: 2020/4/26 11:23
 *  本题还有一个快慢指针的解法。
 *  注意上面两种解法都是有特定的条件的。即数组里面的数字是1-n数组大小是n + 1，
 * @author liyh
 */
public class FindDuplicateNum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(new Solution287().findDuplicate2(arr));
    }
}

class Solution287 {
    /**
     * 搜索部分空间的二分法。感觉好用一点。
     * 有的东西直接记答案比较好
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while(left < right){
            int mid = (left + right+1) >>> 1;
            //这里用一个循环来找到一个依据把区间二分。
            int count = 0;
            for(int num: nums){
                if(num < mid){
                    count++;
                }
            }
            //大于和等于都一样，主要和依据的判定有关系的
            if(count >= mid){
                right = mid -1;
            }
            else{
                left = mid;
            }
        }
        return left;
    }

    /**
     * 这个是搜索了全部空间的二分法。
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            int count = 0;
            for(int num: nums){
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid -1;
            }
            else if(count == mid){
                left = mid + 1;
            }
            else{
                left = mid + 1;
            }
        }
        //写小于等于的时候，返回值的意义不好说啊。
        return left;
    }

    /**
     * 此为双指针法，技巧性很强的，怎么想到环的我还是没想到。
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
