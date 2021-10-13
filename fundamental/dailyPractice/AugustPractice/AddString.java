package dailyPractice.AugustPractice;

/**
 * ClassName: AddString
 * Description: 8月每日一题
 * date: 2020/8/4 10:37
 *
 * @author liyh
 */
public class AddString {
}
class Solution415 {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(p1 >= 0 || p2 >= 0){
            int x = (p1 >= 0? num1.charAt(p1) - '0': 0);
            int y = (p2 >= 0? num2.charAt(p2) - '0': 0);
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            p1--;
            p2--;
        }
        if(carry != 0){
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
