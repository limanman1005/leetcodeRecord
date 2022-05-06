package offer;

/**
 * ClassName: Offer072
 * Description:
 * date: 4/5/2022 下午5:54
 *
 * @author liyh
 */
public class Offer072 {
    public static void main(String[] args) {
        SolutionOffer072 solutionOffer072 = new SolutionOffer072();
        int ans = solutionOffer072.mySqrt2(8);
        System.out.println("ans = " + ans);
    }
}
class SolutionOffer072{

    /**
     * 当不想判断里面的细节的时候根据left来判断是否加1
     * 并且这时候while循环里面的条件必须为<号，否则无法跳出循环
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = x / 2;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if(mid > x / mid){
                right = mid - 1;
            }
            else if(mid < x / mid){
                left  = mid;
            }
            else{
                return mid;
            }
        }
        return left;
    }

    /**
     * 这个模板有时候并不能直接套用到找到最左或者最右的插入位置
     * @param x
     * @return
     */
    public int mySqrt2(int x){
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = x / 2;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(mid > x / mid){
                right = mid - 1;
            }
            else if(mid == x / mid){
                return mid;
            }
            else{
                left = mid  + 1;
            }
        }
        return right;
    }
}
