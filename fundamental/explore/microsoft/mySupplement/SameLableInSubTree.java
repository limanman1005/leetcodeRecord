package explore.microsoft.mySupplement;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SameLableInSubTree
 * Description:
 * date: 2020/8/12 13:27
 *
 * @author liyh
 */
public class SameLableInSubTree {
}

class Solution1519 {
    private int[] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; ++i){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited, labels);
        return ans;
    }
    private int[] dfs(List<List<Integer>> graph, int curNodeNum, boolean[] visited, String labels){
        visited[curNodeNum] = true;
        int[] count = new int[26];
        for(int child : graph.get(curNodeNum)){
            if(visited[child] == false){
                int[] preCount = dfs(graph, child, visited, labels);
                for(int i = 0; i < 26; ++i){
                    count[i] += preCount[i];
                }
            }
        }
        count[labels.charAt(curNodeNum) - 'a']++;
        ans[curNodeNum] = count[labels.charAt(curNodeNum) - 'a'];
        return count;
    }
}