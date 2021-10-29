package mySummary.listAndString;

import java.util.Arrays;

/**
 * ClassName: RearrangeWordsInSentence
 * Description:
 * date: 2021/10/28 1:50
 *
 * @author liyh
 */
public class RearrangeWordsInSentence {
    public static void main(String[] args) {
        Solution1451 solution1451 = new Solution1451();
        String leetcode_is_cool = solution1451.arrangeWords("Keep calm and code on");
        System.out.println(leetcode_is_cool);
    }
}
class Solution1451 {


    public String arrangeWords(String text) {
        String[] split = text.split(" ");
        Arrays.sort(split, (s1, s2)->{
            return s1.length() - s2.length();
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if(i == 0){
                char[] chars = split[0].toCharArray();
                if(chars[0] >= 'a' && chars[0] <= 'z'){
                    chars[0] = (char)(chars[0] ^ 32);
                }
                sb.append(chars);
            }
            else if(split[i].charAt(0) >= 'A' && split[i].charAt(0) <= 'Z'){
                char[] chars = split[i].toCharArray();
                chars[0] = (char)(chars[0] ^32);
                sb.append(chars);
            }
            else{
                sb.append(split[i]);
            }
            if(i != split.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
