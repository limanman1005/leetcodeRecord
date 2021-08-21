package dailyPractice.JunePractice;

import java.util.Collections;

/**
 * ClassName: PalindromeNumber
 * Description: 给一个整数判断下是不是回文
 * date: 2020/6/10 9:38
 *
 * @author liyh
 */
public class PalindromeNumber {
    public static void main(String[] args) {

    }
}
class Solution9 {
    /**
     * 反转一半数字的判断方法
     * @param x 数字
     * @return
     */
    public boolean isPalindrome(int x) {
        //边界条件，直接返回false
        if(x < 0 || x % 10 == 0 && x != 0){
            return false;
        }
        int reverseNumber = 0;
        //当反转的数字大于x的时候意味着反转到一半了
        while(x > reverseNumber){
            //每次将最后一位取出然后加上去
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        //如果x的位数是奇数这时候使用reverNum需要除以10.
        return x == reverseNumber || x == reverseNumber/10;
    }

    /**
     * 每次都取出头尾的进行比较的算法
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        //找到x的位数
        while(x / div >= 10){
            div *= 10;
        }
        //不断的取首尾
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right){
                return false;
            }
            //去掉首位
            x = (x % div) /10;
            //div更新
            div /= 100;
        }
        return true;
    }
}
