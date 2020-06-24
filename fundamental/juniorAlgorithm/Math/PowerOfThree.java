package juniorAlgorithm.Math;

/**
 * ClassName: PowerOfThree
 * Description: 给一个数，判断下是不是3的幂
 * date: 2020/6/19 18:21
 *
 * @author liyh
 */
public class PowerOfThree {
    public static void main(String[] args) {
        double t = 5.5;
        int i = (int) t;
        System.out.println(i);

//        System.out.println(log);
    }
}

class Solution326 {
    /**
     * 常规做法，不断的做除法
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 补一个递归的做法
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        if(n == 1){
            return true;
        }
        else if(n == 0){
            return false;
        }
        else{
            return isPowerOfThree2(n/3) && n % 3 == 0;
        }
    }
}
