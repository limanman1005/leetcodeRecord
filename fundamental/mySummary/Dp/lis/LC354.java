package mySummary.Dp.lis;

import java.util.Arrays;

/**
 * ClassName: LC354
 * Description: 俄罗斯信封套娃问题，本质上和最长上升子序列一样
 * date: 2021/9/14 10:32
 *
 * @author liyh
 */
public class LC354 {
    public static void main(String[] args) {
        int[][] test = {{1, 3}, {3, 5}, {2, 3}};

        Arrays.sort(test, (a,b)-> a[0] > b[0] ? 1: -1);

        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
    }
}
