package offer.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer087
 * Description:
 * date: 8/5/2022 下午11:58
 *
 * @author liyh
 */
public class Offer087 {
    public static void main(String[] args) {
        SolutionOffer087 solutionOffer087 = new SolutionOffer087();
        String str = "25525511135";
        List<String> strings = solutionOffer087.restoreIpAddresses(str);

    }
}
class SolutionOffer087{
    //这个考虑的东西还蛮多的，放到后面在做一做.现在的整体思路是行不通的。
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] strChars = s.toCharArray();
        helper(strChars, 0, sb, ans);
        return ans;
    }

    private void helper(char[] strChars, int start, StringBuilder sb, List<String> ans){
        if(start == strChars.length){
            ans.add(sb.toString());
            return ;
        }
        for(int i = start; i < strChars.length; ++i){
            if(isValidIPPart(strChars, start, i)){
                for(int j = start; j <= i; ++j){
                    sb.append(strChars[j]);
                }
                sb.append('.');
                helper(strChars, i + 1, sb, ans);
                sb.delete(start, i + 2);
            }
        }
    }

    private boolean isValidIPPart(char[] strChars, int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; ++i){
            sb.append(strChars[i]);
        }
        String numStr = sb.toString();
        return Integer.valueOf(numStr) <= 255 && (numStr.equals("0") || numStr.charAt(0) != 0);
    }

}
