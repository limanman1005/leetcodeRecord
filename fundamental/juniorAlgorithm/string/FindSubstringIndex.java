package juniorAlgorithm.string;

/**
 * ClassName: FindSubstringIndex
 * Description:
 * date: 2020/6/16 13:19
 *
 * @author liyh
 */
public class FindSubstringIndex {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        solution28.strStr2("aaaaa", "bba");
    }
}

class Solution28 {
    /**
     * 这个算法的思路就是首先比较下原字符串和要比较的字符串的第一个字符相等吗？
     * 如果相等，截取下来比较和目前比较一下。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if(needleLen > haystackLen){
            return -1;
        }
        if(needleLen == 0){
            return 0;
        }
        for(int i = 0; i < haystackLen - needleLen + 1; ++i){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i, i + needleLen).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 完全不适用java给的api做的法。
     * 有一点难写
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if(nLen == 0){
            return 0;
        }
        int ph = 0;
        while(ph < hLen - nLen + 1){
            //这里是找到一个开头和needle一样的
            while(ph < hLen - nLen + 1 && haystack.charAt(ph) != needle.charAt(0)){
                ++ph;
            }
            //如果剩下的长度都比needle小了，还是没有开头匹配的直接返回-1；
            if(ph == hLen - nLen + 1){
                return -1;
            }
            //找到开头后进行逐个比较
            int curLen = 0,  pn= 0;
            //这里注意这个要时刻指针不越界
            while(pn < nLen && ph < hLen && haystack.charAt(ph) == needle.charAt(pn)){
                ++pn;
                ++ph;
                ++curLen;
            }
            //判断下是否比较成功
            if(curLen == nLen){
                return ph - nLen;
            }
            //如果没有成功回到开头加1的位置继续比较
            ph = ph - curLen + 1;
        }
        return -1;
    }
}
