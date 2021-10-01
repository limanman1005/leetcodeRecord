package niucode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: InTest
 * Description:
 * date: 2021/9/27 22:44
 *
 * @author liyh
 */
public class InTest {

    public static void main(String[] args) {
        SolutionNow0929 solutionNow0929 = new SolutionNow0929();
        String ababab = solutionNow0929.reformat("a0b1c2");
        System.out.println(ababab);
    }



}
class SolutionNow0929{

    public String reformat (String s) {
        // write code here
        if(s == null || s.length() == 0){
            return "";
        }
        int numOfChar = 0, numOfNum = 0;
        int len = s.length();
        for(int i = 0; i < len; ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numOfNum++;
            }
            else{
                numOfChar++;
            }
        }
        if(Math.abs(numOfChar - numOfNum) > 1){
            return "";
        }
        if(numOfChar > numOfNum){
            numOfChar = 0;
            numOfNum = 1;
        }
        else{
            numOfChar = 1;
            numOfNum = 0;
        }
        char[] chars = new char[len];
        for(int i = 0; i < len; ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                chars[numOfNum] = s.charAt(i);
                numOfNum += 2;
            }
            else{
                chars[numOfChar] = s.charAt(i);
                numOfChar += 2;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < chars.length; ++i){
            ans.append(chars[i]);
        }
        return ans.toString();
    }



    public String longestPrefix (String s) {
        // write code here
        if(s == null || s.length() <= 1){
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] helper = new int[len + 1];
        Arrays.fill(helper, -1);
        for(int i = 1; i < len; ++i){
            int pre = helper[i - 1];
            while(pre != -1 && chars[pre + 1] != chars[i]){
                pre = helper[pre];
            }
            if(chars[pre + 1] == chars[i]){
                helper[i] = pre + 1;
            }
        }
        return s.substring(0, helper[len - 1] + 1);
    }


}
