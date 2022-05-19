package niucode.qushi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/17 15:51
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        String arrString = scanner.nextLine();
        String[] split = arrString.split(" ");
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i){
            nums[i] = Integer.parseInt(split[i]);
        }
        SoutionQS2 soutionQS2 = new SoutionQS2();
        int ans = soutionQS2.getAns(nums, K);
        System.out.println(ans);

    }



}


/**
 * 有点难度啊，没啥思路啊。
 */
class SoutionQS2{

    public int getAns(int[] arr, int K){
        int len = arr.length;
        Arrays.sort(arr);
        int ans = arr[len - 1] - arr[0];
        for (int i = 0; i < len - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int high = Integer.MIN_VALUE;
            int low = Integer.MAX_VALUE;
            if(arr[len - 1] - K > 0){
                high = Math.max(arr[len - 1] - K, a + K);
            }
            else {
                high = a + K;
            }
            if(b - K > 0){
                low = Math.min(arr[0] + K, b - K);
            }
            else{
                low = arr[0] + K;
            }
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

}
