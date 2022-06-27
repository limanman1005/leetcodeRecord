package mySummary.bfs;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: MinimumOperationsToConvertNum
 * Description:
 * date: 24/6/2022 上午12:28
 *
 * @author liyh
 */
public class MinimumOperationsToConvertNum {



}

/**
 * 一道非常好的双向BFS入门题
 */
class Solution2059{

    public int minimumOperations(int[] nums, int start, int goal) {
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.addLast(start);
        map.put(start, 0);
        while(!queue.isEmpty()){
            int cur = queue.pollFirst();
            int step = map.get(cur);
            for(int num: nums){
                int[] result = new int[]{cur + num, cur - num, cur ^ num};
                for(int next: result){
                    if(next == goal){
                        return step + 1;
                    }
                    if(next < 0 || next > 1000){
                        continue;
                    }
                    if(map.containsKey(next)){
                        continue;
                    }
                    map.put(next,  step + 1);
                    queue.addLast(next);
                }
            }
        }
        return -1;
    }

}
