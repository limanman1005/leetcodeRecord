package explore.juniorAlgorithm.string;

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
        String[] str = new String[]{"aa", "a"};
        System.out.println(solution14.longestCommonPrefixDebug2(str));

        one: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 2){
                    break one;
                }
                System.out.print(i);
            }
        }
    }
}

class Solution14 {
    /**
     * 这个方法没有下一个方法好理解
     * @param strs
     * @return
     */
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

    /**
     * 这个横向扫秒，比较好理解。
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        //首先选定一个作为答案的备选。
        String ans = strs[0];
        //然后使用循环遍历剩下的所有字符串。
        for(int i = 1; i < strs.length; ++i){
            int j = 0;
            //第二层循环判断下所有的字符串，分别找下与当前字符串一样的前缀。
            //找到那个最远的下标
            for(; j < ans.length() && j < strs[i].length(); ++j){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            //对每一个字符串，都截取一下
            ans = ans.substring(0, j);
            //如果等于空串了，那后边的就不用判断了
            if(ans.equals("")){
                return ans;
            }
        }
        return ans;
    }


    /**
     * 这个是纵向扫秒的方法。
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        //首先选定第一个字符串作为一个待选的项。
        String tmpAns = strs[0];
        int nums = strs.length;
        int len = tmpAns.length();
        //这层循环对选定的一个的每一个字符进行遍历
        for(int i = 0; i < len; ++i){
            char c = tmpAns.charAt(i);
            //这层循环对剩下的每一个字符串扫秒第i个字符，判断下等不等。
            for(int j = 1; j < nums; ++j){
                //如果到这个字符串尾或者字符不相等了，就找到了那个下标
                //纵向的可以直接返回，就是因为这个最短木桶原理。
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return tmpAns.substring(0, i);
                }
            }
        }
        return tmpAns;
    }


    public String longestCommonPrefixdebug(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int strNum = strs.length;
        String ans = strs[0];
        int len = ans.length();
        for(int i = 0; i < len; ++i){
            char c = ans.charAt(i);
            int j;
            for(j = 1; j < strNum; ++j){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    ans = ans.substring(0, i);
                }
            }
        }
        return ans;
    }


    public String longestCommonPrefixDebug2(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int strNum = strs.length;
        String ans = strs[0];
        int len = ans.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; ++i){
            char c = ans.charAt(i);
            boolean flag = true;
            for(int j = 1; j < strNum; ++j){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                sb.append(c);
            }
            else{
                return sb.toString();
            }
        }
        return ans;
    }
}
