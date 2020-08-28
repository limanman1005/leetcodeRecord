package JulyPractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ClassName: UniqueBST
 * Description: 给一个整数n，求以1.。。n为节点组成的二叉搜索树有多少种？
 * 这其实是一个卡特兰数
 * date: 2020/7/15 10:00
 *
 * @author liyh
 */
public class BSTNum {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        pq.add(3);
        pq.add(1);
        pq.add(2);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);

    }
}
class Solution96 {
    /**
     * dp解法
     * dp代表以i个数可以组成多少的二叉搜索树。
     * dp[i]就是所有的0到j和j到i之间的所有能组成二叉搜索树的乘积。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //空树也是二叉搜索树，初始化为1.
        dp[0] = 1;
        //第一层循环填充dp[i],代表这个整数是多少
        for(int i = 1; i <= n; ++i){
            //dp[i] = dp[j - 1] * dp[i - j] (j从1到i之间取到每一个数)
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 这个直接计算卡特兰数的循环解法
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        long ans = 1;
        for(int i = 0; i < n; ++i){
            ans = ans * 2 * (2 * i + 1) /(i + 2);
        }
        return (int) ans;
    }

    /**
     * 补充一个递归计算卡特兰数的
     * @param n
     * @return
     */
    public int numTrees4(int n) {
        return (int) catlan(n);
    }
    private long catlan(long n){
        if(n == 0){
            return 1;
        }
        return catlan(n - 1) * (4 * n - 2) / (n + 1);
    }
}
