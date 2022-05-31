package offer.amzon.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SubarraySumEqualsK
 * Description:
 * date: 28/5/2022 上午11:18
 *
 * @author liyh
 */
public class SubarraySumEqualsK {
}
class Solution560{
    /**
     * 这个是求子数组的个数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(128);
        //目标put这个0，1对意味着自己就是，这时候所对应的数目就是1。
        map.put(0, 1);
        int sum =0;
        int ans = 0;
        for(int i = 0; i<n; ++i){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }

}
