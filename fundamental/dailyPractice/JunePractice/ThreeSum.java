package dailyPractice.JunePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Description: 给一个数组找到三个数相加等于特定数的和。这个两重去重还是有点意思的
 * date: 2020/6/12 9:57
 * @author liyh
 */
public class ThreeSum {
    public static void main(String[] args) {
        HashSet<List<Integer>> lists = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
//        list2.addAll(list1);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        lists.add(list2);
        lists.add(list1);
        System.out.println(lists.size());

    }
}
class Solution15 {
    /**
     * 解法很优雅。使用了两次去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        //处理一下边界条件
        if(nums == null || len < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; ++i){
            //这个是本题等于0的特殊判断
            if(nums[i] > 0){
                break;
            }
            //重复的数字，确定第一个数字
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //找到左右边界，因为拍过序了所以
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                //找到一组值，继续向后搜索
                if(sum == 0){
                    //加入到答案里面
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //继续去重之后向左移
                    while(L < R && nums[L] == nums[L + 1]){
                        L++;
                    }
                    //去重之后向右移
                    while(L < R && nums[R] == nums[R - 1]){
                        R--;
                    }
                    //改变边界
                    L++;
                    R--;
                }
                //整个和比较的小。左边界移
                else if(sum < 0){
                    L++;
                }
                //整个和比较的大。右边界移
                else if(sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }
}
