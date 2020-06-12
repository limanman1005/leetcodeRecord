package juniorAlgorithm.array;

/**
 * ClassName: PlusOneInArray
 * Description: 给一个数组，表示数字。返回加上一的结果。
 * 这个题讲究技巧性，只能找一个好记得记住了。
 * date: 2020/5/25 15:03
 *
 * @author liyh
 */
public class PlusOneInArray {
    public static void main(String[] args) {
        new Solution66().plusOne2(new int[]{9});
    }
}

class Solution66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        //从这里面出来代表就是全是9.
        for(int i = len - 1; i >= 0; ++i){
            //先加一，然后对10求余确保不是10
            //找到第一个不是10的加一后可直接返回
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        //由于全是10，直接new一个新数组。
        digits = new int[len + 1];
        digits[0] = 1;
        return  digits;
    }

    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        if(digits[len - 1] != 9){
            digits[len - 1]++;
            return digits;
        }
        for(int i = len - 1; i >= 0; --i){
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}