package math;

/**
 * ClassName: UglyNum
 * Description:
 * date: 2020/9/10 18:35
 *
 * @author liyh
 */
public class UglyNum {
}
class Solution263 {
    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while(num != 1){
            if(num % 2  == 0){
                num = num /2;
            }
            else if(num % 3 == 0){
                num = num /3;
            }
            else if(num % 5 == 0){
                num = num/5;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
