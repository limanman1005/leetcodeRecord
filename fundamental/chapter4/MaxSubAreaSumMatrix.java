package chapter4;

/**
 * ClassName: MaxSubAreaSumMatrix
 * Description:
 * date: 2020/4/18 16:16
 *
 * @author liyh
 */
public class MaxSubAreaSumMatrix {
    public static int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] subMatrix = new int[n];
        int li = 0, lj = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                subMatrix[j] = 0;
            }
            for(int j = i; j < m; ++j){
                sum = 0;
                for(int k = 0; k < n; k++){
                    subMatrix[k] += matrix[j][k];
                    if(sum > 0){
                        sum += subMatrix[k];
                    }
                    else{
                        sum = subMatrix[k];
                        li = i;
                        lj = k;
                    }
                    if(sum > maxSum){
                        maxSum = sum;
                        ans[0] = li;
                        ans[1] = lj;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }
}
