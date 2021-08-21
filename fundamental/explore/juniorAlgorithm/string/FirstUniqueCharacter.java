package explore.juniorAlgorithm.string;

/**
 * ClassName: FirstUniqueCharacter
 * Description: 找到字符串里面第一个唯一的字符
 * date: 2020/6/13 13:24
 *
 * @author liyh
 */
public class FirstUniqueCharacter {
}
class Solution387 {
    /**
     * 这个就是使用下hash表，为了节省时间使用了一个int数组。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }
        int len = s.length();
        int[] map = new int[26];
        char[] strs = s.toCharArray();
        for(int i = 0; i < len; ++i){
            map[strs[i] - 'a']++;
        }
        for(int i = 0; i < len; ++i){
            if(map[strs[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
