package offer;

import mySummary.Dp.lis.LIS;

import java.util.*;

/**
 * ClassName: Offer033
 * Description:
 * date: 29/4/2022 下午11:28
 *
 * @author liyh
 */
public class Offer033 {
    public static void main(String[] args) {
        SolutionOffer033And49 solutionOffer033And49 = new SolutionOffer033And49();
        String[] strs = new String[]{"12", "23"};
        solutionOffer033And49.groupAnagrams(strs);
    }
}
class SolutionOffer033And49{

    /**
     * 这个有一个问题就是使用Long乘积太大可能会溢出。另有排序算法。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
           if(strs == null || strs.length == 0){
               return null;
           }
           Map<Long, List<String >> map = new HashMap<>();
           int[] primeArray = getPrimeArray();
           for(int i = 0; i < strs.length; ++i){
               long wordHash = 1;
               for(int j = 0; j < strs[i].length(); ++j){
                   wordHash *= primeArray[strs[i].charAt(j) - 'a'];
               }
               map.putIfAbsent(wordHash, new LinkedList<>());
               map.get(wordHash).add(strs[i]);
           }
           return new LinkedList<>(map.values());
    }

    private int[] getPrimeArray(){
        int[] primeArray = new int[26];
        int idx = 0;
        while(idx < 26){
            if(idx == 0){
                primeArray[idx] = 2;
            }
            else{
                primeArray[idx] = nextPrimeWithLowerBound(primeArray[idx - 1]);
            }
            idx++;
        }
        return primeArray;
    }

    private int nextPrimeWithLowerBound(int curPrime) {
        int nextPrime = curPrime + 1;
        while(true){
            boolean isPrime = true;
            for(int i = 2; i < nextPrime; ++i){
                if(nextPrime % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                break;
            }
            else{
                nextPrime++;
            }
        }
        return nextPrime;
    }


    /**
     * 把他转换成char数组然后sort一下，同样的异位词会有相同的sort结果，不会有溢出问题。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < len; ++i){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(strs[i]);
        }
        return new LinkedList<>(map.values());
    }
}
