package MayPratise;

/**
 * ClassName: QuickPow
 * Description:
 * date: 2020/5/11 10:54
 *
 * @author liyh
 */
public class QuickPow {
    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2, 3));
    }
}
class Solution50 {
    /**
     * 这个是递归的思路。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? quickMul(x, N) : 1.0/quickMul(x, -N);
    }
    public double quickMul(double x, long N){
        //无论是奇还是偶，都必然归到这边来。
        if(N == 0){
            return 1.0;
        }
        //不断的减小问题的规模。
        double y = quickMul(x, N/2);
        //如果为奇数代表要多乘一个x才是结果。后序需要用到分解后的结果所以需要写上来
        return N % 2 == 0? y*y: y*y*x;
    }
}
