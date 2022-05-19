package niucode.jingdong.one;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/30 18:55
 *
 * @author liyh
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String numLine = scanner.nextLine();
        String[] split = numLine.split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
//        int[] arr = {1,5,4,3,2};
        int ans = solve(arr);
        System.out.println(ans);
    }

    /**
     * 过了91%，剩下的有点哪里错了有点难顶啊，哪些错误用例阻碍了AC呢。
     * @param arr
     * @return
     */
    private static int solve(int[] arr) {
        int min = 10001, max = -1;
        int minIdx = 0, maxIdx = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }
        int leftCount = Math.max(minIdx + 1, maxIdx + 1);
//        int leftCount = minIdx + 1 + maxIdx + 1;
        int rightCount = Math.max(len - minIdx, len - maxIdx);
//        int rightCount = len - minIdx + len - maxIdx;
        int leftRightCount = minIdx + 1 + len - maxIdx;
        int rightLeftCount = len - minIdx + maxIdx + 1;
        int ans = Math.min(leftCount, Math.min(rightCount, Math.min(leftRightCount, rightLeftCount)));
        return ans;
    }

}
class SolutionJD01{

}
