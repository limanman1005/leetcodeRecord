package binarySearch;

/**
 * ClassName: MySqrt
 * Description: 自己写一个sqrt的函数
 * date: 2020/4/26 10:52
 * 这里就是使用了long来避免了溢出问题。还有就是移动left的时候mid是排除不了的
 * 这个还有一个牛顿法
 * @author liyh
 */
public class MySqrt {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();

    }
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


    /**
     * 补一个牛顿迭代法。
     * 十分的有意思。不断的使用泰勒一阶公式，迭代出两个值，然后这两个值比较下，如果十分接近了，也代表差不多到0值了
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if(x < 0){
            return -1;
        }
        if(x == 0){
            return 0;
        }
        //初始值，可以随便选一个
        double cur = 1;
        while(true){
            double pre = cur;
            cur = (cur + x /cur) /2;
            if(Math.abs(cur - pre) < 1e-6){
                return (int) cur;
            }
        }
    }
}

