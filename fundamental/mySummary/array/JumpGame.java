package mySummary.array;

/**
 * ClassName: JumpGame
 * Description:
 * date: 19/5/2022 上午1:16
 *
 * @author liyh
 */
public class JumpGame {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] arr = {3, 2, 1, 0, 4};
        boolean jump = solution55.canJump2(arr);
        System.out.println(jump);
    }
}

class Solution55{
    private int[] memo;
    public boolean canJump(int[] nums) {
        if(nums.length == 1 && nums[0] == 0){
            return true;
        }
        memo = new int[nums.length];
        return dfs(nums, 0) == 1;
    }

    private int dfs(int[] nums, int idx){
        if(idx >= nums.length - 1){
            return 1;
        }
        if(memo[idx] != 0){
            return memo[idx];
        }
        int maxJumpLen = nums[idx];
        for(int i = 1; i <= maxJumpLen; ++i){
            if(dfs(nums, idx + i) == 1){
                memo[idx + 1] = 1;
                return 1;
            }
        }
        return -1;
    }



    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int len = nums.length;
        int maxDistance = 0;
        for(int i = 0; i <= maxDistance; ++i){
            int curAbleToReach = i + nums[i];
            //在循环内部更新最大距离，也就是循环终止条件
            maxDistance = Math.max(maxDistance, curAbleToReach);
            if(maxDistance >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
