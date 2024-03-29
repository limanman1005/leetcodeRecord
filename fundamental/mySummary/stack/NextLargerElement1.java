package mySummary.stack;

import java.util.*;

/**
 * ClassName: NextLargerElement1
 * Description:
 * date: 2020/9/16 10:57
 *
 * @author liyh
 */
public class NextLargerElement1 {
}

class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2 == null || nums2.length == 0){
            if(nums1 != null){
                int[] ans = new int[nums1.length];
                Arrays.fill(ans, -1);
                return ans;
            }
            else{
                return new int[0];
            }
        }
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        Deque<Integer> stack = new LinkedList<>();
        //这里可739题一摸一样，就是找nums2的下一个最大元素的下标，如果存在那么放进stack中
        for(int i = 0; i < nums2.length; ++i){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int calIndex = stack.pop();
                map.put(nums2[calIndex], nums2[i]);
            }
            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        //从map中取回结果
        for(int i = 0; i < nums1.length; ++i){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
