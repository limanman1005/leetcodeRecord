package niucode.shopee.two;

import java.util.*;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/25 15:14
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        SolutionShopee02 solutionShopee02 = new SolutionShopee02();
        String str = "lazada";
        boolean stringBalance = solutionShopee02.isStringBalance(str);
        System.out.println(stringBalance);
    }

}

class SolutionShopee02{

    public boolean isStringBalance(String inputStr) {
        // write code here
        if(inputStr == null || inputStr.length() == 0){
            return true;
        }
        HashSet<Character> set = new HashSet<>();
        char[] strChars = inputStr.toCharArray();
        int[] strNum = new int[26];
        for (int i = 0; i < strChars.length; i++) {
            strNum[strChars[i] - 'a']++;
            set.add(strChars[i]);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for(Character ch: set){
            integers.add(strNum[ch - 'a']);
        }
        Collections.sort(integers);
        int len = integers.size();
        boolean ans = true;
        boolean deleted = false;
        for (int i = 0; i < len - 1; i++) {
            if(integers.get(i) == integers.get(i + 1)){
                continue;
            }
            else{
                if(Math.abs(integers.get(i) - integers.get(i + 1)) < 2 && !deleted){
                    deleted = true;
                    continue;
                }
                else{
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
}
