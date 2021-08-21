package explore.math;

/**
 * ClassName: UglyNum2
 * Description:
 * date: 2020/9/10 18:41
 *
 * @author liyh
 */
public class UglyNum2 {
    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        int i = solution264.nthUglyNumber(10);
    }
}
class Solution264 {
    /**
     * 这道题是非典型的动态规划，这种思路还是暂时记下来好了
     * 使用三个指针记录下各个用了多少了
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; ++i){
            arr[i] = Math.min(2 * arr[p2] ,Math.min(3 * arr[p3], 5 * arr[p5]));
            if(arr[i] == 2 * arr[p2]){
                ++p2;
            }
            if(arr[i] == 3 * arr[p3]){
                ++p3;
            }
            if(arr[i] == 5 * arr[p5]){
                ++p5;
            }
        }
        return arr[n - 1];
    }
}
