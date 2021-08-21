package dailyPractice.JulyPractice;

/**
 * ClassName: SortedArrayTwoSum
 * Description: 给两个排好序的数组，求两数之和等于给定值的东西
 * date: 2020/7/20 10:08
 * 最好使用双指针，并且这道题和在二维数组里面搜索有点像
 * @author liyh
 */
public class SortedArrayTwoSum {
}
class Solution167 {
    /**
     * 双指针的解法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            }
            else if(sum > target){
                j--;
            }
            else{
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
