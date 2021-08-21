package mySummary.binarySearch;

/**
 * ClassName: EatBananaNum
 * Description: 珂珂吃香蕉问题
 * date: 2020/4/27 15:15
 *
 * @author liyh
 */
public class EatBananaNum {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println((a + b - 1)/b);
    }
}

class Solution875 {
    /**
     * 根据这个速度是一个范围内的整数值，得到思路是二分查找。
     * 怎么缩小空间的判断是一个函数。值得注意的是向上取整的方法。
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int maxSpeed = 1;
        for(int num : piles){
            if(num > maxSpeed){
                maxSpeed = num;
            }
        }
        int left = 1;
        int right = maxSpeed;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(check(piles, mid) > H){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public int check(int[] piles, int speed){
        int hour = 0;
        for(int num : piles){
            hour += (num + speed - 1)/speed;
        }
        return hour;
    }
}


