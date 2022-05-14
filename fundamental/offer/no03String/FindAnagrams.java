package offer.no03String;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindAnangrams
 * Description:
 * date: 29/4/2022 下午4:52
 *
 * @author liyh
 */
public class FindAnagrams {
}

/**
 * 此题和014是一摸一样的题，在一些部位填一些代码即可。
 */
class SolutionOffer015And438{
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null){
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()){
            return ans;
        }
        int lenS = s.length();
        int lenP = p.length();
        int[] counts = new int[26];
        for(int i = 0; i < lenP; ++i){
            counts[s.charAt(i) - 'a']++;
            counts[p.charAt(i) - 'a']--;
        }
        if(areAllZero(counts)){
            ans.add(0);
        }
        for(int i = lenP; i < lenS; ++i){
            counts[s.charAt(i) - 'a']++;
            counts[s.charAt(i - lenP) - 'a']--;
            if(areAllZero(counts)){
                ans.add(i - lenP + 1);
            }
        }
        return ans;
    }

    private boolean areAllZero(int[] counts){
        for(int num: counts){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
