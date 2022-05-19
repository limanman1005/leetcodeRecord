package niucode.jianxin.two;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/23 19:12
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numLine = scanner.nextLine();
        String[] numSplit = numLine.split(" ");
        int m = Integer.parseInt(numSplit[0]);
        int n = Integer.parseInt(numSplit[1]);
        String arrLine = scanner.nextLine();
        String[] arrSplit = arrLine.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrSplit[i]);
        }
        int ans = getFIFOTime(arr, m, n);
        System.out.println(ans);
    }

    private static int getFIFOTime(int[] arr, int m, int n) {
        LinkedList<Integer> orderSet = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(!orderSet.contains(arr[i])){
                if(orderSet.size() <= m){
                    ans++;
                    orderSet.add(arr[i]);
                }
                else {
                    orderSet.pollFirst();
                    orderSet.addLast(arr[i]);
                    ans++;
                }
            }
        }
        return ans;
    }
}
