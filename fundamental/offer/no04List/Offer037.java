package offer.no04List;

import java.util.LinkedList;

/**
 * ClassName: Offer037
 * Description:
 * date: 30/4/2022 上午11:29
 *
 * @author liyh
 */
public class Offer037 {

    public static void main(String[] args) {
        SolutionOffer037And735 solutionOffer037And735 = new SolutionOffer037And735();
        int[] arr = {-2, -1, 1, 2};
        int[] ints = solutionOffer037And735.asteroidCollision(arr);
        for(int num : ints){
            System.out.println(num);
        }

    }
}
class SolutionOffer037And735 {
    /**
     * 这个标记一下，还是有锻炼到写代码的能力的。
     * 就是情况有点不一样。之后在补一补这道题吧。
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        a: for(int i = 0; i < asteroids.length; ++i){
            b: while(!stack.isEmpty() && asteroids[i] * stack.peekLast() < 0){
                if(Math.abs(stack.peekLast()) > Math.abs(asteroids[i])){
                    continue a;
                }
                else if(Math.abs(stack.peekLast()) < Math.abs(asteroids[i])){
                    stack.pollLast();
                }
                else{
                    stack.pollLast();
                    continue a;
                }
            }
            stack.addLast(asteroids[i]);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
