package explore.juniorAlgorithm.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FizzAndBuzz
 * Description: 简单题，思路也直接
 * date: 2020/6/19 18:17
 *
 * @author liyh
 */
public class FizzAndBuzz {
}

class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            if(i % 3 == 0 && i % 5 == 0){
                ans.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                ans.add("Fizz");
            }
            else if(i % 5 == 0){
                ans.add("Buzz");
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
