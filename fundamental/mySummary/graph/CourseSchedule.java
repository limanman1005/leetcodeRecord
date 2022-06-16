package mySummary.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: CourseSchedule
 * Description:
 * date: 2/6/2022 下午10:05
 *
 * @author liyh
 */
public class CourseSchedule {
}
class Solution207_2{
    /**
     * 拓扑排序，思路还是比较的清晰的
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //记录入度
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < numCourses; ++i){
            inDegree.put(i, 0);
        }
        //创建邻接表
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] relate : prerequisites){
            int cur = relate[1];
            int next = relate[0];
            inDegree.put(next, inDegree.get(next) + 1);
            if(!adj.containsKey(cur)){
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        //首先将入度为零的顶点入队
        LinkedList<Integer> queue = new LinkedList<>();
        for(int key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                queue.addLast(key);
                ans[idx++] = key;
            }
        }
        //遍历队列里的入度为零的节点，直到队空
        while(!queue.isEmpty()){
            int curCourseNum = queue.pollFirst();
            if(!adj.containsKey(curCourseNum)){
                continue;
            }
            List<Integer> successorList = adj.get(curCourseNum);
            //更新下当前入度为零的顶点的涉及到顶点度的值
            for(int nextCourseNum : successorList){
                inDegree.put(nextCourseNum, inDegree.get(nextCourseNum) - 1);
                if(inDegree.get(nextCourseNum) == 0){
                    queue.addLast(nextCourseNum);
                    ans[idx++] = nextCourseNum;
                }
            }
        }
        //看下那个节点入度不为零，说明存在环。不能全部修完。
        for(int key : inDegree.keySet()){
            if(inDegree.get(key) != 0){
                return false;
            }
        }
        return true;
    }

}
