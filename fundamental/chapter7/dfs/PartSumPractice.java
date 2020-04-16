package chapter7.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: PartSumPractice
 * Description:
 * date: 2020/4/10 10:15
 *
 * @author liyh
 */
public class PartSumPractice {

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

    private static void dfs(int[] arr, int target, int cur, ArrayList<Integer> ans) {
        if(target == 0){
            System.out.print("Yes (" + origin + " = ");
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ans.get(i) + (i == size - 1? "" : " + "));
            }
            System.out.println(")");
            System.exit(0);
        }
        if(target < 0 || cur == arr.length){
            return;
        }
        dfs(arr, target, cur + 1, ans);
        ans.add(arr[cur]);
        dfs(arr, target - arr[cur], cur + 1, ans);
        int last = ans.size();
        ans.remove(last - 1);
    }
}
