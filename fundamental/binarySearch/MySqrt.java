package binarySearch;

/**
 * ClassName: MySqrt
 * Description: 自己写一个sqrt的函数
 * date: 2020/4/26 10:52
 * 这里就是使用了long来避免了溢出问题。还有就是移动left的时候mid使排除不了的
 * @author liyh
 */
public class MySqrt {
}

class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x / 2;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else if (square == x) {
                return (int) mid;
            }
            //这里不能些mid-1。因为mid排除不了
            else {
                left = mid;
            }
        }
        return (int) left;
    }
}

