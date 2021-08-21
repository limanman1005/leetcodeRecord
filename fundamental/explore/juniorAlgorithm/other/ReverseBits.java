package explore.juniorAlgorithm.other;

/**
 * ClassName: ReverseBits
 * Description: 给一个数，反转这个数的二进制。
 * date: 2020/6/19 18:40
 *
 * @author liyh
 */
public class ReverseBits {
}
class Solution190 {
    // you need treat n as an unsigned value

    /**
     * 第一种解法
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        //这个也是不断的找到n的最后一位。然后加上最后一位的后整体向前
        for(int i = 0; i < 32; ++i){
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }


    /**
     * 这个和上面的思路是一样的，只不过形式不同
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int ans = 0;
        //这里是31，因为第一位是0。
        int bitSize = 31;
        //不断的拿到n的最后一位，然后移动bitSize位。给ans加上即可。
        while(n != 0){
            ans += (n & 1) << bitSize;
            bitSize--;
            n = n >>> 1;
        }
        return ans;
    }

    /**
     * 使用异或运算代替加法
     * @param n
     * @return
     */
    public int reverseBits3(int n) {
        int ans = 0;
        for(int i = 0; i < 32; ++i){
            ans ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return ans;
    }
}
