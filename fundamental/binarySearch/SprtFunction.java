package binarySearch;

/**
 * ClassName: SprtFunction
 * Description:
 * date: 2020/4/24 23:12
 *
 * @author liyh
 */
public class SprtFunction {

    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt(8));
    }
}
class Solution69 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(mid * mid > x){
                right = mid - 1;
            }
            else if(mid * mid == x){
                return mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}