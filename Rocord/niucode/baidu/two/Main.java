package niucode.baidu.two;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/18 19:35
 *
 * @author liyh
 */
public class Main {

    private static int[] cache;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNum = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < caseNum; ++i){
            String numStr = scanner.nextLine();
            int ans = getCalResult(numStr);
            System.out.println(ans);
        }
    }




    private static void calCache(int[] cache, int n) {
        cache = new int[1000000000];
        Arrays.fill(cache, 1);
        for(int i = 2; i < 1000000000; i+= 2){
            BigInteger bigInteger = new BigInteger(String.valueOf(i));
            int lowestSetBit = bigInteger.getLowestSetBit();
            cache[i] = (int) Math.pow(2, lowestSetBit + 1) - 1;
        }
    }

    private static int getCalResult(String numStr) {
        BigInteger bigInteger = new BigInteger("2");
        BigInteger add = new BigInteger("2");
        int ans = 0;
        int boundary = Integer.parseInt(numStr);
        for(int i = 1; i <= boundary; ++i){
            if(cache[i] != 0){
                ans += cache[i];
            }
            else{
                int lowestSetBit = bigInteger.getLowestSetBit();
                double fValue = Math.pow(2, lowestSetBit + 1) - 1;
                ans += fValue;
                cache[i] = ans;
                bigInteger = bigInteger.add(add);
            }
        }
        return ans;
    }
}
