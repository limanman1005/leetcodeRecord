package niucode.Meituan;

import java.util.Arrays;

/**
 * ClassName: HuaQi
 * Description:
 * date: 2021/10/15 18:14
 *
 * @author liyh
 */
public class HuaQi {
    public static void main(String[] args) {
        SolutionHuaQi1 solutionHuaQi1 = new SolutionHuaQi1();
        int[][] test = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] fee = {5, 1, 2, 20, 20, 3};
        int i = solutionHuaQi1.minCostWithTimeLimited(25, test, fee);
        System.out.println(i);
    }
}


/**
 * 此题是一个最短路径问题，使用迪杰斯特拉算法计算最短路径的裸题，带了一个时间的限制
 */
class SolutionHuaQi1{
    public int minCostWithTimeLimited (int maxTime, int[][] edges, int[] passingFees) {
        // write code here
        int n = passingFees.length;
        int[] minCost = new int[n + 1];
        int[] minMinute = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[][] mat = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for (int j = 0; j <= n; j++) {
                mat[i][j] = mat[j][i] = (i == j? 0: Integer.MAX_VALUE);
            }
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], c = edge[2];
            mat[u][v] = c;
        }
        dijkstra(mat, minCost, minMinute, passingFees, visited);
        return minCost[n - 1];
    }

    private void dijkstra(int[][] mat, int[] minCost, int[] minMinute, int[] passingFees, boolean[] visited) {
        Arrays.fill(visited, false);
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[1] = 0;
        minMinute[1] = passingFees[0];
        for (int i = 1; i <= passingFees.length; i++) {
            int t = -1;
            for(int j = 1; j <= passingFees.length; ++j){
                if(!visited[i] && (t == -1 || passingFees[j - 1]  < passingFees[t - 1])){
                    t = j;
                }
            }
            if(t == -1){
                continue;
            }
            visited[t] = true;
            for (int k = 1; k <= passingFees.length; k++) {
                minCost[k] = Math.min(minCost[k], minCost[t] + passingFees[k - 1]);
            }
        }
    }

}


/**
 * 此题合并两个升序的数组题，使用三指针从后向前便利可解
 */
class SolutionHuaQi2{

    /**
     * 只有60%，奇怪
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public String merge (int[] nums1, int m, int[] nums2, int n) {
        // write code here
        int p1 = 0, p2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(p1 < m || p2 < n){
            long val1 = p1 < m? nums1[p1]: Long.MAX_VALUE;
            long val2 = p2 < m? nums2[p2]: Long.MAX_VALUE;
            if(val1 < val2){
                stringBuilder.append(val1);
                p1++;
            }
            else{
                stringBuilder.append(val2);
                p2++;
            }
        }
        return stringBuilder.toString();
    }



}


