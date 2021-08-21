package dailyPractice.JunePractice;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Candies
 * Description: 六一简单题，给一个数组，再给一个数。
 * 判断数组中的每一个元素加上给定的数能不能大于这个数组中的最大值
 * date: 2020/6/2 18:40
 *
 * @author liyh
 */
public class Candies {
}
class Solution1431 {
    /**
     * 简单方法，无需多说
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        if(candies == null){
            return ans;
        }
        int max = 0;
        for(int candy : candies){
            max = Math.max(candy, max);
        }
        for(int candy : candies){
            if(candy + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}
