package juniorAlgorithm.string;

/**
 * ClassName: LongestCommonPrefix
 * Description: 给一个字符数组，找到这些字符数组的公共前缀
 * date: 2020/6/4 13:12
 *
 * @author liyh
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] str = new String[]{"flower", "flow", "flight"};
        System.out.println(solution14.longestCommonPrefix2(str));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; ++i){
            //这个是找到当前前缀在带查找字符串的第一个位置。如果为0代表前缀和当前字符串的前面几个字母重合了。是当前的最长前缀，然后去匹配下一个字符串
            //直到所有的字符串都匹配上了。
            while(strs[i].indexOf(prefix) != 0){
                //每次都删掉尾部的一个字符。
                prefix = prefix.substring(0, prefix.length() - 1);
                //判断下是否已经是空的了，如果为空直接返回即可
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for(int i = 1; i < strs.length; ++i){
            int j = 0;
            for(; j < ans.length() && j < strs[i].length(); ++j){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            if(ans.equals("")){
                return ans;
            }
        }
        return ans;
    }
}