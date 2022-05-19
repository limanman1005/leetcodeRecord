package inAndOut.test3;

import java.util.Arrays;

/**
 * ClassName: Main
 * Description:
 * date: 2020/9/12 20:42
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        char[] test = { 'a', 'b', 'c', 'd', 'e'};
        reverse(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
        new StringBuilder("123".substring(1, 2));
    }

    public static void reverse(char[] chars, int left, int right){
        while(left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
