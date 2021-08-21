package dailyPractice.JulyPractice;

import java.util.Arrays;

/**
 * ClassName: IsGraphBipartite
 * Description: 给一个图。判断是不是二分图。图给的是邻接表的形式。
 * 二分图就是每一个边连接的两个顶点可以划分到不同的集合。
 * 图的算法考不多，不如放到后面进行复习。bfs解法，暂且不写了。
 * date: 2020/7/16 10:42
 *
 * @author liyh
 */
public class IsGraphBipartite {
}
class Solution785 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    /**
     * 二分图嘛，使用图的遍历算法解决。
     * 这里是dfs解法
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        //这个主要用来记录每一个节点的颜色。并判断下还有那些节点没有被遍历。
        //这个图有可能是不连通的，可能需要多dfs几次。
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for(int i = 0; i < n && valid; ++i){
            if(color[i] == UNCOLORED){
                dfs(i, RED, graph);
            }
        }
        return valid;
    }
    private void dfs(int node, int c, int[][] graph){
        color[node] = c;
        //选择另一个颜色
        int otherColor = (c == RED? GREEN : RED);
        for(int neighbor: graph[node]){
            if(color[neighbor] == UNCOLORED){
                dfs(neighbor, otherColor, graph);
                if(!valid){
                    return;
                }
            }
            else if(color[neighbor] != otherColor){
                valid = false;
                return ;
            }
        }
    }
}
