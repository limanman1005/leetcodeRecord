package mySummary.backTrack;

import java.math.BigInteger;

/**
 * ClassName: BinaryWatch
 * Description:
 * date: 2021/10/16 21:35
 *
 * @author liyh
 */
public class BinaryWatch {
    public static void main(String[] args) {
        Integer x = 14;
        BigInteger bigInteger = new BigInteger("14");
        int lowestSetBit = bigInteger.getLowestSetBit();
        System.out.println(lowestSetBit);
    }
}

class Solution401{

}
