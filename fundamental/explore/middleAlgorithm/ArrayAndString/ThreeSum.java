package explore.middleAlgorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Description: 此题出现在6月的每日一题，这里就不赘述了。
 * 题号是15
 * date: 2020/6/26 17:16
 *
 * @author liyh
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution15.threeSum(arr);
        System.out.println(lists);
    }
}
class Solution15{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int p1 = 0; p1 < len - 2; p1++){
            int p2 = p1 + 1;
            int p3 = len - 1;
            while(p2 < p3){
                int sum = nums[p1] + nums[p2] + nums[3];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));
                    while(p2 < p3 && nums[p2] == nums[p2 + 1]){
                        p2++;
                    }
                    while(p2 < p3 && nums[p3] == nums[p3 - 1]){
                        p3++;
                    }
                    p2++;
                    p3--;
                }
                else if(sum < 0){
                    p2++;
                }
                else{
                    p3--;
                }
            }
        }
        return ans;
    }

}

