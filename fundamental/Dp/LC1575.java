
package Dp;
/**
 * ClassName: LC1575
 * Description:
 * date: 2021/8/17 17:22
 *
 * @author liyh
 */

public class LC1575 {
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
     * dfs的入参和出参设计，要有当前位置可以向下搜索。
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

    //todo 这里添加一个加了记忆化搜索和改变baseCase的解法







}
