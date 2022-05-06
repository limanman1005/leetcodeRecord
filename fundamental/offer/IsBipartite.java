package offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ClassName: IsBipartite
 * Description:
 * date: 27/4/2022 下午11:53
 *
 * @author liyh
 */
public class IsBipartite {
    public static void main(String[] args) {
        SolutionOffer106 solutionOffer106 = new SolutionOffer106();
        int[][] graph = {{}, {3}, {}, {1}, {}};
        boolean bipartite = solutionOffer106.isBipartite(graph);
        System.out.println(graph.length);
        System.out.println("graph[0].length = " + graph[0].length);
        System.out.println(bipartite);

    }
}
class SolutionOffer106{


    public boolean isBipartite(int[][] graph) {
        if(graph == null){
            return false;
        }
        int rows = graph.length;
        int cols = graph[0].length;
        int[] colors = new int[rows];
        Arrays.fill(colors, -1);
        for(int i = 0; i < rows; ++i){
            if(colors[i] == -1){
                if(!couldBipartite(graph, colors, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }


    private boolean couldBipartite(int[][] graph, int[] colors, int i, int color){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i);
        colors[i] = color;
        while(!queue.isEmpty()){
            int vetex = queue.pollFirst();
            for(int neighbor : graph[vetex]){
                if(colors[neighbor] >= 0){
                    if(colors[neighbor] == colors[vetex]){
                        return false;
                    }
                }
                else{
                    queue.addLast(neighbor);
                    colors[neighbor] = 1 - colors[vetex];
                }

            }
        }
        return true;
    }




}
