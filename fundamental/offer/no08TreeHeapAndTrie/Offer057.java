package offer.no08TreeHeapAndTrie;

/**
 * ClassName: Offer057
 * Description:
 * date: 12/5/2022 下午5:44
 *
 * @author liyh
 */
public class Offer057 {
    public static void main(String[] args) {
        SolutionOffer057 solutionOffer057 = new SolutionOffer057();
        int[] nums = {2147483646,2147483647};
        solutionOffer057.containsNearbyAlmostDuplicate(nums, 3, 3);
    }
}
class SolutionOffer057{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        //这个解法超时了，但是是正确的。注意i 和 j的判断。len - k是有可能小于0的。这是一个坑点
        for(int i = 0; i < len; ++i){
            for(int j = i + 1;  j <= i + k && j < len; ++j){
                if(Math.abs(((long)nums[i] - (long)nums[j])) <= t){
                    return true;
                }
            }
        }
        return false;
    }
}
