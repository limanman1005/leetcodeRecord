/**
 * ClassName: SortQuestion
 * Description:
 * date: 2020/3/31 16:53
 *
 * @author liyh
 */
public class SortQuestion {
    /**
     * 这个是把元素按照某一性质（比如奇偶性）分成前后两部分，双指针法很好用
     * @param num
     */
    public static void oddAndEven(int[] num){
        int lp = 0;
        int rp = num.length - 1;
        while(lp <= rp){
            if(num[lp] % 2 == 0){
                Util.swap(num, lp, rp);
                rp--;
            }
            else{
                lp++;
            }
        }
    }

    public static int partition(int[] nums, int left, int right){
        int pivotIndex = left;
        int lp = left + 1;
        int rp = right;
        while(lp <= rp){
            while (left <= right && nums[lp] <= nums[pivotIndex]){
                lp++;
            }
            while(left <= right && nums[rp] > nums[pivotIndex]){
                rp--;
            }
            //这一步不添加是要出错的
            if(lp < rp){
                Util.swap(nums, lp, rp);
            }
        }
        Util.swap(nums, left, rp);
        return rp;
    }


    /**
     * 在乱序数组里里面找到按大小排序后的第K个数
     * @param nums 数组
     * @param k 在目前的范围内找第几个数
     * @param left 左边边界
     * @param right 右边边界
     * @return 第K个数
     */
    public static int selectK(int[] nums, int k, int left, int right){
        int pivotIndex = partition(nums, left, right);
        //这个数在目前的范围内是第几个数
        int qk = pivotIndex - left + 1;
        if(qk == k){
            return nums[pivotIndex];
        }
        else if(qk > k){
            return selectK(nums, k, left, pivotIndex - 1);
        }
        else{
            return selectK(nums, k - qk, pivotIndex + 1, right);
        }
    }

    /**
     * 这种方法直接使用selecK方法找到排名中间的数字。
     * @param nums 参数
     * @return 众数
     */
    public static int majorityNum(int[] nums){
        return selectK(nums, nums.length/2, 0, nums.length - 1);
    }


    /**
     * 投票法的求众数。
     * @param nums 数组
     * @return 答案
     */
    public static int majorityNum2(int[] nums){
        int index = 0;
        int cur = nums[0];
        int curNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if(cur == nums[i]){
                curNum++;
            }
            else{
                curNum--;
            }
            if(curNum == 0){
                //这里置一不能忘
                curNum  = 1;
                index = i;
                cur = nums[i];
            }
        }
        return nums[index];
    }

    /**
     * 找恰好等于n/2的数。因为总数一定是偶数。所以把情况看为是不是最后一个数。
     * 每次遍历的时候都和最后一个数比较，如果相等了，就把计数器加一。
     * 剩下的按照投票法继续进行。
     * 最后判断一下，如果最后一个数的计数器等于N/2了，那么答案是最后一个数
     * 如果不是N/2那么答案是投票出来的那个数。
     * @param nums 数组
     * @return 答案。
     */
    public static int halfNum(int[] nums){
        int candidate = nums[0];
        int count = 0;
        int countOfLast = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == nums[n - 1]){
                countOfLast++;
            }
            if(count == 0){
                candidate = nums[i];
                count = 1;
                continue;
            }
            if(nums[i] == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        if(countOfLast == n/2){
            return nums[n-1];
        }
        else{
            return candidate;
        }

    }


    /**
     * 找到某个数组中缺失的最小值。
     * 这个方法改变元素组中的值，但是不使用辅助数组。
     * @param nums 传入的数组
     * @param l 左侧边界
     * @param r 右侧边界
     * @return 最小的数值
     */
    public static int findMin(int[] nums, int l, int r){
        if(l > r){
            return l + 1;
        }
        int midIndex = l + (r - l)/2;
        int pivot = selectK(nums, midIndex - l +1, l, r);
        int expectValue = midIndex + 1;
        if(pivot == expectValue){
            return findMin(nums, midIndex + 1, r);
        }
        else{
            return findMin(nums, l, midIndex - 1);
        }
    }

    /**
     * 这个方法利用辅助数组。这里值得记住的是辅助数组不用开的特别大
     * 大小只要是原数组长度加1即可。这一点是应该记住的。
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums){
        int len = nums.length;
        int[] helper = new int[len+1];
        for (int i = 0; i < len; i++) {
            if(nums[i] <= len){
                helper[nums[i]] = 1;
            }
        }
        for(int i = 1; i <= len; i++){
            if(helper[i] != 1){
                return i;
            }
        }
        return nums.length;
    }







    public static void main(String[] args) {
//        int[] arr = {2, 1, 3};
//        oddAndEven(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        int[] arr = {0, 7, 9, 6, 1, 3, 2, 8, 4, 5};
//        int i = selectK(arr, 9, 0, 9);
//        System.out.println(i);
//        int[] arr = {1, 2, 2, 3};
//        System.out.println(halfNum(arr));
        int[] arr = {1, 3};
        int min = findMin2(arr);
        System.out.println(min);
    }
}
