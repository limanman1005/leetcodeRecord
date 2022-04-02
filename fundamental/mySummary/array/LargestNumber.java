package mySummary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ClassName: LargestNumber
 * Description:
 * date: 2021/10/29 13:31
 *
 * @author liyh
 */
public class LargestNumber {

    public static void main(String[] args) {
        Solution179 solution179 = new Solution179();
        int[] num = {30,3,34,5,9};
//        String s = solution179.largestNumber(num);
//        System.out.println(s);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("34");
        strings.add("3");

        System.out.println(strings);
    }
}
class Solution179{
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> numString = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numString.add(String.valueOf(nums[i]));
        }
        Collections.sort(numString, (s1, s2) ->{
            int p1 = 0, p2 = 0;
            while(p1 < s1.length() && p2 < s2.length()){
                if(s1.charAt(p1)  > s1.charAt(p1)){
                    return 1;
                }
                else if(s1.charAt(p1) == s2.charAt(p2)){
                    p1++;
                    p2++;
                }
                else {
                    return -1;
                }
            }
            if(p1 < s1.length() && s1.charAt(p1) > '0'){
                return 1;
            }
            else if(p1 < s1.length() && s1.charAt(p1) == 0){
                return -1;
            }
            else if(p2 < s2.length() && s2.charAt(p2) > '0'){
                return -1;
            }
            else if(p2 < s2.length() && s2.charAt(p2) == '0'){
                return 1;
            }
            else{
                return 0;
            }
        });
        for(String num : numString){
            sb.append(num);
        }
        return sb.toString();
    }
}
