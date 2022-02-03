package mySummary.queue;

import java.util.LinkedList;

/**
 * ClassName: LC239
 * Description: 此题和剑指Offer59一摸一样
 * date: 2021/8/25 13:54
 * 此题就是利用单调队列维护一个区间内的最大值，同理也可以维护一个最小值。
 * @author liyh
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] ints = solution239.maxSlidingWindow(arr, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        //todo 将offer59与59_2都做了吧
    }
}
class Solution239 {

    /**
     * 求一个范围大小中的最大或者最小值的问题，可以采用单调队列来实现
     * 这些题我可能做不完，但是形成的通用的思想还是要记住的
     * 首先使用单调队列的可以找到一定范围内的最大和最小值。
     * 使用单调队列，首先加入元素前要判断队尾元素要不要出队，然后将元素加入队列中
     * 其次，要判断当前队列中的值是否是合法窗口内的值（具体就是判断窗口的左右下标是否在合法范围内），如果是才能写入到答案中去
     * 这题使用数组下标是一个好的选择
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //答案数据的长度
        int[] ans = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < len; ++i){
            //1.只要队列不空，那么维护一个从左至右的递减队列
            //当待塞进去的数比队尾的数大的时候，队尾元素出队
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            //2.将数的下标加入队列
            queue.addLast(i);
            //3.判断了窗口的左边在哪里，且和队头的元素比较下，看队头元素是否还在窗口中
            //如果不在窗口中了，那么从队头出列
            //这个只能判定队列的最左侧元素是否在窗口的左侧范围内。如果不合法则移除队头元素
            int left = i - k + 1;
            if(queue.peekFirst() < left){
                queue.removeFirst();
            }
            //4.如果窗口形成那么将队头元素加入答案数组之中
            //这个就是看下右侧是否合法，只要是看窗口是否已经形成
            if(i + 1 >= k){
                ans[left] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}


