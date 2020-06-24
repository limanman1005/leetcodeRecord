package juniorAlgorithm.other;

/**
 * ClassName: Bit1Nums
 * Description: 给一个数组，求二进制位是一的情况。这个貌似有api
 * date: 2020/6/19 18:32
 *
 * @author liyh
 */
public class Bit1Nums {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(1024);
        System.out.println(s);
    }
}

class Solution191 {
    // you need to treat n as an unsigned value

    /**
     * 解法一：每次都和自己减一进行与操作
     * 然后统计
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n &= n - 1;
        }
        return count;
    }
}

