package offer.no015dp;

/**
 * ClassName: Offer090
 * Description:
 * date: 9/5/2022 上午10:49
 *
 * @author liyh
 */
public class Offer090 {
    public static void main(String[] args) {
        SolutionOffer090 solutionOffer090 = new SolutionOffer090();
        int[] arr = {1, 2, 3, 1};
        solutionOffer090.rob(arr);
    }
}
//此题有点意思，将0到n - 1间屋子分为两类

class SolutionOffer090 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp1 = new int[len];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for(int i = 2; i < len - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        dp1[len - 1] = dp1[len - 2];
        int[] dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < len; ++i){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }
}
