package dailyPractice.JulyPractice;

/**
 * ClassName: DivisorGame
 * Description: 一个有关博弈论的题。如果用程序的思维来解释的话，还是比较的有意思的
 * date: 2020/7/24 11:26
 *
 * @author liyh
 */
public class DivisorGame {
}
class Solution1025 {
    /**
     * f数组代表剩下数字是i的时候先手的胜败状态。
     * 如果递推呢，一个状态一次又一次的向后找如果满足当前数字可选，并且选完这个数字之后的状态不是必败的。如果是的alice就赢了。
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        //f数组是当前数字对应的必胜还是必败的状态
        boolean[] f = new boolean[N + 3];
        f[1] = false;
        f[2] = true;
        for(int i = 3; i <= N; ++i){
            for(int j = 1; j < i; ++j){
                //这个就是选i之后的情况，并且选完之后是必败的状态。说明alice就赢了。
                if((i % j == 0 && !f[i - j])){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
