package juniorAlgorithm.other;

/**
 * ClassName: HanmingDistance
 * Description: 给两个数，找到这两个数用二进制位表示的时候对应位置不同的数目
 * 这里使用了一个异或的运算把这个东西转成了统计数目的题
 * date: 2020/6/19 18:37
 *
 * @author liyh
 */
public class HanmingDistance {
}
class Solution461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor != 0){
            count++;
            xor = xor & (xor - 1);
        }
        return count;
    }
}