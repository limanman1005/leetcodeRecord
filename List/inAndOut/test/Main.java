package inAndOut.test;


import java.util.Arrays;


/**
 * ClassName: Main
 * Description:
 * date: 2020/9/12 20:06
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numOfArr = scanner.nextInt();
//        int[] arr = new int[numOfArr];
//        scanner.nextLine();
//        String num = scanner.nextLine();
//        for(int i = 0; i < numOfArr; ++i){
//            arr[i] = num.charAt(i) - '0';
//        }
//        System.out.println(Arrays.toString(arr));

//        Solution solution = new Solution();
//        int jump = solution.jump(arr);
//        System.out.println(jump);
        int[] arr = {0, 1, 2, 1, 2};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.jump(arr));
    }
}
class Solution{
    public int jump(int[] arr){
        int len = arr.length;
        int cur = 0;
        int jumpNum = 0;
        while(cur < len - 1){
            int lastIndex = findLastIndex(arr, cur);
            if(lastIndex > cur + 1){
                cur = lastIndex;
            }
            else{
                cur = cur + 1;
            }
            jumpNum++;
        }
        return jumpNum;
    }
    public int findLastIndex(int[] arr, int cur){
        int len = arr.length;
        for(int i = len - 1; i > cur ; --i){
            if(arr[i] == arr[cur]){
                return i;
            }
        }
        return -1;
    }
}
class Solution2{
    public int jump(int[] arr){
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < arr.length; ++i){
            int tmp = findMinInDp(dp, arr, arr[i], i);
            if(tmp != Integer.MAX_VALUE){
                dp[i] = Math.min(tmp + 1, dp[i - 1] + 1);
            }
            else{
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[len - 1];
    }

    private int findMinInDp(int[] dp,int[]arr,  int target, int boundIndex){
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < boundIndex; ++i){
            if(arr[i] == target){
                ans = Math.min(ans, dp[i]);
            }
        }
        return ans;
    }

}
