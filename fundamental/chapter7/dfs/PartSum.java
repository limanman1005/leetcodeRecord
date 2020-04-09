package chapter7.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: partSum
 * Description: 给一个数组，判断有没有子集加起来等于一个给定的数的
 * 还是体会dfs加回溯的思想
 * date: 2020/4/8 18:23
 * 测试用例
 * 输入
 *
 *     n=4
 *     a={1,2,4,7}
 *     k=13
 * 输出:
 *
 *     Yes (13 = 2 + 4 + 7)
 * @author liyh
 */
public class PartSum {
    /**
     * 核心dfs
     * @param a 数组
     * @param k 目标值
     * @param cur 当前判断要不要加的数值
     * @param ints 答案数组
     */
    public static void dfs(int[] a, int k, int cur, ArrayList<Integer> ints){
        if(k == 0){
            System.out.print("Yes (" + origin + " = ");
            int size = ints.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ints.get(i) + (i == size - 1? "" : " + "));
            }
            System.out.println(")");
            System.exit(0);
        }
        if(k < 0 || cur == a.length){
            return;
        }
        //不选择这个数，向下递归
        dfs(a, k, cur + 1, ints);
        //选择这个数，然后向下递归
        ints.add(a[cur]);
        dfs(a, k - a[cur], cur + 1, ints);
        //选择之后再恢复到原来的状态
        int last = ints.size() - 1;
        ints.remove(last);
    }
    private static int origin;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        origin = target;
        dfs(arr, target, 0, new ArrayList<>());
    }
}
