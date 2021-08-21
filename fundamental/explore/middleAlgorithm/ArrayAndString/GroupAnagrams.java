package explore.middleAlgorithm.ArrayAndString;

import java.util.*;

/**
 * ClassName: GroupAnagrams
 * Description: 给一个字符串数组，这些字符串里面如果组成的字符种类和数目一致，就分成同一组。
 * date: 2020/6/27 17:28
 *
 * @author liyh
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(32);
        objectObjectHashMap.putIfAbsent(1, 1);
        objectObjectHashMap.putIfAbsent(1, 2);
    }
}
class Solution49 {
    /**
     * 这个使用了arrays的排序，时间复杂度稍高一点
     * 排序之后字符和种类一样的就相等了。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return ans;
        }
        Map<String, List> map = new HashMap<>(32);
        for(String s:  strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
            else{
                map.get(key).add(s);
            }
        }
        return new ArrayList(map.values());
    }


    /**
     * 这个是自己编码了一个key。理论上比上一个快，但是使用期间比较的慢。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0){
            return  new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>(32);
        int[] count = new int[26];
        for(String s : strs){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; ++i){
                sb.append(i);
                sb.append(count[i] + '0');
            }
            String key = sb.toString();
            if(!ans.containsKey(key)){
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                ans.put(key, tmp);
            }
            else{
                ans.get(key).add(s);
            }
        }
        return new ArrayList(ans.values());
    }


}
