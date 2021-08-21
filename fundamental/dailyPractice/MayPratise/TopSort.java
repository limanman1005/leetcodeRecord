package dailyPractice.MayPratise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * ClassName: TopSort
 * Description:
 * date: 2020/5/17 17:45
 *
 * @author liyh
 */
public class TopSort {
    public static void main(String[] args) {
//        int[][] pre = new int[][]{{1, 0}, {0, 1}};
//        new Solution201().findOrder(2, pre);
        int[] ints = new int[3];
        ints[0] = 1;
        ArrayList<Integer> integers = new ArrayList<>();


    }
}

class Solution201 {
    private List<List<Integer>> edges;
    private int[] indeg;
    private int[] ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        ans = new int[numCourses];
        for(int[] edge : prerequisites){
            edges.get(edge[1]).add(edge[0]);
            ++indeg[edge[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[index++] = cur;
            for(int v : edges.get(cur)){
                --indeg[v];
                if(indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if(index != numCourses){
            return new int[]{};
        }
        return ans;
    }
}
