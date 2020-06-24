package juniorAlgorithm.other;

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
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; ++i){
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}


