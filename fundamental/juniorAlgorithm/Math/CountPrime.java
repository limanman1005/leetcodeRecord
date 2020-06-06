package juniorAlgorithm.Math;

import java.util.Arrays;

/**
 * ClassName: CountPrime
 * Description:
 * date: 2020/6/6 13:11
 *
 * @author liyh
 */
public class CountPrime {
}
class Solution {
    /**
     * 这个就是素数表的用法，可以进一步优化一下
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //这里的循环条件可以优化为 i * i < n
        for(int i = 2; i < n; ++i){
            if(isPrime[i]){
                //这里也可以优化为 j = i * i开始。
                for(int j = 2 * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int ans = 0;
        for(int i = 2; i < n; ++i){
            if(isPrime[i]){
                ans++;
            }
        }
        return ans;
    }
}