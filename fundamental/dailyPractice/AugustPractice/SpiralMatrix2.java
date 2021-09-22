package dailyPractice.AugustPractice;

/**
 * ClassName: SpiralMatrix2
 * Description: 此题和leetcode54题是相反的。
 * date: 2020/9/5 20:56
 *
 * @author liyh
 */
public class SpiralMatrix2 {
}
class Solution59 {
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++){
                mat[t][i] = num++;
            }
            t++;
            for(int i = t; i <= b; i++){
                mat[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--){
                mat[b][i] = num++;
            }
            b--;
            for(int i = b; i >= t; i--){
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}
