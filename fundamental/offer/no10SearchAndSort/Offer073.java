package offer.no10SearchAndSort;

/**
 * ClassName: Offer073
 * Description:
 * date: 4/5/2022 下午6:21
 *
 * @author liyh
 */
public class Offer073 {
}


class SolutionOffer073 {


    /**
     * 这是第一个模板，while使用了小于号，right收缩的时候没有减一
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxFromArr(piles);
        while(left < right){
            int mid = (left + right) >>> 1;
            int curNeedHour =  getHour(mid, piles);
            if(curNeedHour > h){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    private int getMaxFromArr(int[] piles){
        int max = -1;
        for(int num : piles){
            max = Math.max(num, max);
        }
        return max;
    }

    private int getHour(int speed, int[] piles){
        int hours = 0;
        for(int num : piles){
            hours += (num + speed  - 1) / speed;
        }
        return hours;
    }


    public int minEatingSpeed2(int[] piles, int h) {
        int left = 1;
        int right = getMaxFromArr(piles);
        //添加了等号之后，right是可以减一的。
        //此时left是right加1保存了最优且最右的一个值。
        while(left <= right){
            int mid = (left + right) >>> 1;
            int curNeedHour =  getHour(mid, piles);
            if(curNeedHour > h){
                left = mid + 1;
            }
            //无论是否刚好等于h，总可以在尝试下更小的速度
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}
