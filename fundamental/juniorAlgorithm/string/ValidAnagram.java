package juniorAlgorithm.string;

/**
 * ClassName: ValidAnagram
 * Description: 有效的字符异位词（给两个字符串判断下），就是使用hash表统计下字符串的字符出现的次数。
 * 由于都是小写字母，所以使用了一个固定大小的数组。并且把三次循环压缩成了两次。
 * date: 2020/6/13 16:55
 *
 * @author liyh
 */
public class ValidAnagram {
}
class Solution242 {
    /**
     * 还是hash表的一个使用，但是把三次循环压缩成了两次。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); ++i){
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); ++i){
            map[t.charAt(i) - 'a']--;
            if(map[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
