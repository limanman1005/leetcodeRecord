package juniorAlgorithm.string;

/**
 * ClassName: checkLost.ReverseInteger
 * Description: 整数反转，把一个整数个反转了
 * date: 2020/6/13 12:45
 *
 * @author liyh
 */
public class ReverseInteger {
    public static void main(String[] args) {
    }
}

class Solution7 {
    /**
     * 这种带各种边界条件的还是直接记住这个答案吧，没事干多翻一翻自己以前写的东西
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            if(ans > Integer.MAX_VALUE /10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
