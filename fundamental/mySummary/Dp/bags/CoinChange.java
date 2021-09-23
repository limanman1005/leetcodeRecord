package mySummary.Dp.bags;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CoinChange
 * Description:
 * date: 2020/8/21 11:15
 *
 * @author liyh
 */
public class CoinChange {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] arr = {1, 2,3};
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        collect.forEach(System.out::println);

//        Integer[] arr = new Integer[]{2, 3, 5};
//        Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println();
//        int i = solution322.coinChange(arr, 3);

    }
}

class Solution322 {
    /**
     * dp写法，也可以看作是一个背包问题。
     * 只不过求的值不是最大价值、组合、排列等而是组成特定值的数组的长度最小
     * 所有状态方程有一点特别。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        //这里使用amount + 1是后面会求min。使用-1就找不到最小值了
        Arrays.fill(ans, amount + 1);
        ans[0] = 0;
        for(int coin: coins){
            if(coin <= amount){
                ans[coin] = 1;
            }
        }
        //完全背包，每个硬币可以选择多次，所以使用从前向后。
        //长度无关排列，组合所以内外循环的顺序没有变化
        for(int i = 1; i <= amount; ++i){
            for(int coin: coins){
                if(i >= coin){
                    if(ans[i-coin] != amount + 1){
                        ans[i] = Math.min(ans[i], ans[i-coin] + 1);
                    }
                }
            }
        }
        return ans[amount] == amount  + 1? -1: ans[amount];
    }


    private int[] memo;

    /**
     * 记忆化递归写法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        memo = new int[amount + 1];
        dfs(coins, amount);
        return memo[amount];
    }

    public int dfs(int[] coins, int amount){
        if(amount < 0){
            return  - 1;
        }
        if(amount == 0){
            return 0;
        }
        if(memo[amount] != 0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin){
                int preAns = dfs(coins, amount - coin);
                if(preAns != -1 && preAns < min){
                    min = preAns + 1;
                }
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE? -1 : min);
        return memo[amount];
    }

    private int ans = Integer.MAX_VALUE;

    /**
     * 暴力搜索，这个不带返回值的递归的不能加memo
     * 因为没有计算出当前钱数的最优值，所以无法保存。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        dfs(coins, amount, 0);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return  ans;
    }

    public void dfs(int[] coins, int amount, int curSum){
        if(amount < 0){
            return ;
        }
        if(amount == 0){
            ans = Math.min(curSum, ans);
        }
        for(int coin : coins){
            dfs(coins, amount - coin, curSum + 1);
        }
    }
}
