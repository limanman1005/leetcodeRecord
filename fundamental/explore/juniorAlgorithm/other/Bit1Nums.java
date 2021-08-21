package explore.juniorAlgorithm.other;

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
     * 解法一：每次都和自己减一进行与操作。
     * 由于每次减一会把这个数字的排在最后的1变成0。剩下的0变成1
     * 例 111000 减一变成 110111。
     * 这时候我们和自己做 & 运算就可以了。前面的位数都不变，最后的一个1变成0了。
     * 直到n本身变成0的时候，就相当于做完了所有的统计。
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

    /**
     * 解法二，使用一个mask。然后不断移动mask中1的位置。
     * @param n
     * @return
     */
    public int hammingWeight2(int n){
        int ans = 0;
        int mask = 1;
        for(int i = 0; i < 32; ++i){
            if((n & mask) != 0){
                ans++;
            }
            mask <<= 1;
        }
        return ans;
    }

    /**
     * 解法三: 使用java的无符号左移，移动n。
     * @param n
     * @return
     */
    public int hammingWeight3(int n){
        int ans = 0;
        while(n != 0){
            if((n & 1) != 0){
                ans++;
            }
            n = n >>> 1;
        }
        return ans;
    }
}

