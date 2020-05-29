package MayPratise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SubarrayModK
 * Description: 给一个数组求这个子数组的连续子数组的和可以被给定的K整除
 * 连续子数组问题，有的可以使用前缀和
 * date: 2020/5/27 9:28
 *
 * @author liyh
 */
public class SubarrayModK {
}

class Solution974 {
    /**
     * 这个是Hash表+注意统计法
     * 我们首先求出前缀和，然后和K求余。这样我们就知道了前缀和求余相同的值有几个。（根据同余定理，两个求余相同的值，两者相减求余为0）
     * 然后或者是使用一个map存起来求余的答案和次数，在遍历的时候遇到不断累加的到答案
     * 或者是之后重新遍历map使用排列组合数求出答案
     * 此题还有一个算出map表之后使用排列组合数的答案，这里按下不表
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        //这个表示的是如何前缀和本身能被K求余==0
        record.put(0, 1);
        int sum = 0, ans = 0;
        for(int elem : A){
            sum += elem;
            //这里是为了保证求余为正数
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}