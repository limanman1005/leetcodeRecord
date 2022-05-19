package niucode.baidu.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/18 20:42
 *
 * @author liyh
 */
public class Main {
    private static int[] cache;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cache = new int[10000000];
        calCache(cache);
        int caseNum = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < caseNum; ++i){
            int curNum = Integer.parseInt(scanner.nextLine());
            int ans = 0;
            for(int j = 1; j <= curNum; ++j){
                ans += cache[j];
            }
            System.out.println(ans);
        }
    }

    private static void calCache(int[] cache) {
        Arrays.fill(cache, 1);
        for(int i = 2; i < cache.length; i+= 2){
            BigInteger bigInteger = new BigInteger(String.valueOf(i));
            int lowestSetBit = bigInteger.getLowestSetBit();
            cache[i] = (int) Math.pow(2, lowestSetBit + 1) - 1;
        }
    }
}
