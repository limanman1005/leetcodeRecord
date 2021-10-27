package checkLost;

import java.util.ArrayList;

/**
 * ClassName: checkLost.ReverseInteger
 * Description:
 * date: 2021/7/20 12:46
 *
 * @author liyh
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
    }
}
class Solution07{
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            //移除计算
            if(ans > Integer.MAX_VALUE/10 ||(ans == Integer.MAX_VALUE /10 && pop > 7)){
                return 0;
            }
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE /10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
