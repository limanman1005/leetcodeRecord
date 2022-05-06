package offer;

import java.util.LinkedList;

/**
 * ClassName: Offer038And739
 * Description:
 * date: 1/5/2022 上午10:45
 *
 * @author liyh
 */
public class Offer038 {
}


class SolutionOffer038And739{

    /**
     * 单调栈的应用
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        for(int i = 0; i < len; ++i){
            //本来是不想记了，但是这个循环意味初始化的顺序
            //stack的代码放到了while循环之后意味着在循环内进行了初始化
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]){
                int lastTempIdx = stack.pollLast();
                ans[lastTempIdx] = i - lastTempIdx;
            }
            stack.addLast(i);
        }
        return ans;
    }
}
