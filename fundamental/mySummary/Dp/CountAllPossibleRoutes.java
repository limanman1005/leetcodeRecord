
package mySummary.Dp;

import java.util.Arrays;

/**
 * ClassName: LC1575
 * Description:
 * date: 2021/8/17 17:22
 *
 * @author liyh
 */

public class CountAllPossibleRoutes {
}
class Solution1575 {
    private int mod = 1000000007;

    /**
     * 此题的dfs解法，从每一个位置出发，搜索可以到达的位置，baseCase有两种算法
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        if(locations == null || locations.length == 0){
            return -1;
        }
        int n = locations.length;
        return dfs(locations, start, finish, fuel);
    }

    /**
     * 这里添加一个加了记忆化搜索和改变baseCase的解法
     *
     */
    private int[][] memo;

    /**
     * dfs的入参和出参设计，要有当前位置，现有的油量可以向下搜索。
     * 暴力搜索，如果需要一个结果总数，那么我们返回一个int值比较的合适，给上面进行操作。
     * @param locations
     * @param curPos
     * @param finish
     * @param curFuel
     * @return
     */

    private int dfs(int[] locations, int curPos, int finish, int curFuel){
        //baseCase1 当前位置没油了，也没有达到终点，方法数为0。
        if(curFuel == 0 && curPos != finish){
            return 0;
        }
        //不能添加这个条件，会导致提前剪枝。
//        if(curFuel == 0 && curPos == finish){
//            return 1;
//        }
        //到达一个城市，还有油，但是不够到达其他任何一个城市了。
        boolean hasNext = false;
        for(int i = 0; i < locations.length; ++i){
            if(i != finish){
                int need = Math.abs(locations[i] - locations[finish]);
                if(need <= curFuel){
                    hasNext = true;
                    break;
                }
            }
        }
        //这里如果刚好是终点，可以返回1。
        if(curFuel != 0 && !hasNext){
            return curPos == finish? 1: 0;
        }
        //开始去往下一个城市，如果当前正好是终点，那么sum初始化为1。
        int sum = (curPos == finish? 1: 0);
        //开启搜索从当前城市中可以到达的城市。
        for(int i = 0; i < locations.length; ++i){
            if(i != curPos){
                int cost = Math.abs(locations[i] - locations[curPos]);
                if(curFuel >= cost){
                    sum += dfs(locations, i, finish, curFuel - cost);
                    sum %= mod;
                }
            }
        }
        return sum;
    }

    public int countRoutes2(int[] locations, int start, int finish, int fuel) {
        if(locations == null || locations.length == 0){
            return -1;
        }
        memo = new int[locations.length][fuel + 1];
        for(int i = 0; i < locations.length; ++i){
            Arrays.fill(memo[i], -1);
        }
        return dfs2(locations, start, finish, fuel);
    }



    private int dfs2(int[] locations, int curPos, int finish, int curFuel){
        //baseCase判断一下选择该位置后油量能否到终点，如果不能直接返回0
        int cost = Math.abs(locations[finish] - locations[curPos]);
        if(cost > curFuel){
            memo[curPos][curFuel] = 0;
            return 0;
        }
        //利用记忆化memo
        if(memo[curPos][curFuel] != -1){
            return memo[curPos][curFuel];
        }
        //sum初始值需要判断一下
        int sum = (curPos == finish ? 1: 0);
        //遍历一下可以选择作为下一站的位置
        for(int i = 0; i < locations.length; ++i){
            if(i != curPos){
                //这里判断一下当前油量能都到达遍历的位置，如果可以到达则选择作为下一站。
                cost = Math.abs(locations[i] - locations[curPos]);
                if(curFuel >= cost){
                    sum += dfs2(locations, i, finish, curFuel - cost);
                    sum %= mod;
                }
            }
        }
        memo[curPos][curFuel] = sum;
        return sum;
    }


    /**
     * 记忆化搜索改dp写法
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public int countRoutes3(int[] locations, int start, int finish, int fuel) {
        if(locations == null || locations.length == 0){
            return -1;
        }
        int len = locations.length;
        int[][] dp = new int[len][fuel + 1];
        //边界条件不能忘，这里有边界条件的处理
        for(int i = 0; i <= fuel; ++i){
            dp[finish][i] = 1;
        }
        //找出递归方程dp[curPos][fuel] += dp[k][fuel - cost];
        //其中fuel和fuel-cost有大小关系，大的需要依赖小的值，所以必须从小到大遍历fuel
        for(int curFuel = 0; curFuel <= fuel; ++curFuel){
            //选定一个i之后遍历所有的不为i的位置作为下一站，然后判断下能否到达下一站，如果可以加上其值
            for(int i = 0; i < len; ++i){
                for(int k = 0; k < len; ++k){
                    if(i != k){
                        int cost = Math.abs(locations[i] - locations[k]);
                        if(cost <= curFuel){
                            dp[i][curFuel] += dp[k][curFuel - cost];
                            dp[i][curFuel] %= mod;
                        }
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}
