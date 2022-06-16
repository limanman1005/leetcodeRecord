package mySummary.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: CourseSchedule2
 * Description:
 * date: 3/6/2022 下午5:55
 *
 * @author liyh
 */
public class CourseSchedule2 {
}

class Solution210{
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        if(prerequisites == null){
            return ans;
        }
        if(prerequisites.length == 0){
            for(int i = 0; i < numCourses; ++i){
                ans[i] = i;
            }
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < numCourses; ++i){
            inDegree.put(i, 0);
        }
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] relate : prerequisites){
            int preCourse = relate[1];
            int curCourse = relate[0];
            inDegree.put(curCourse, inDegree.get(curCourse) + 1);
            if(!adj.containsKey(preCourse)){
                adj.put(preCourse, new ArrayList<>());
            }
            adj.get(preCourse).add(curCourse);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                queue.addLast(key);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()){
            int curStudyCourseNum = queue.pollFirst();
            ans[idx++] = curStudyCourseNum;
            if(!adj.containsKey(curStudyCourseNum)){
                continue;
            }
            List<Integer> preCourses = adj.get(curStudyCourseNum);
            for(int next : preCourses){
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0){
                    queue.addLast(next);
                }
            }
        }
        for(int key : inDegree.keySet()){
            if(inDegree.get(key) != 0){
                return new int[0];
            }
        }
        return ans;
    }

}


