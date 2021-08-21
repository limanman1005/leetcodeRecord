package dailyPractice.JulyPractice;

/**
 * ClassName: KthSmallestElementInASortedMatrix
 * Description: 找到一个从左到右和从上到下的都有序的矩阵的第K个数
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * date: 2020/7/2 9:41
 *
 * @author liyh
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int a = -1;
        System.out.println(Integer.toBinaryString(a));
        a = a >>> 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(-1 >> 1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
class Solution378 {
    /**
     * 本题使用二分法。在最大值和最小值right和left之间进行二分查找。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while(left < right){
            int mid = (left + right) >>> 1;
            if(check(matrix, mid, k, n)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 使用check判断比当前元素大的元素有几个。
     * 然后和k比较一下返回结果
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return
     */
    private boolean check(int[][] matrix, int mid, int k, int n){
        int i = n - 1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                //加上（i + 1）代表加上了上面一列的元素。
                num += (i + 1);
                j++;
            }
            else{
                i--;
            }
        }
        return num >=k;
    }
}
