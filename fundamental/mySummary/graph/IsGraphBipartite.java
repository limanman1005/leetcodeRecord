package mySummary.graph;

import java.util.Arrays;

/**
 * ClassName: IsGraphBipartite
 * Description:
 * date: 2021/10/2 15:10
 *
 * @author liyh
 */
public class IsGraphBipartite {
    public static void main(String[] args) {

        int[][] graph ={{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        Solution785 solution785 = new Solution785();
        boolean bipartite = solution785.isBipartite(graph);
        System.out.println("bipartite = " + bipartite);
    }
}

class Solution785{

    public boolean isBipartite(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        int[] colors = new int[rows];
        Arrays.fill(colors, -1);
        for(int i = 0; i < rows; ++i){
            if(colors[i] == -1){
                if(!dfs(graph, colors, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int vertex, int color){
        colors[vertex] = color;
        int[] adjs = graph[vertex];
        for(int i = 0; i < adjs.length; ++i){
            if(colors[vertex] == colors[adjs[i]]){
                return false;
            }
            else if(colors[adjs[i]] == -1){
                return dfs(graph, colors, adjs[i],  1 - color);
            }
            else{
                continue;
            }
        }
        return true;
    }

}
