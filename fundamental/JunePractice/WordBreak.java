package JunePractice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: WordBreak
 * Description: 本题是一个dp题。
 * date: 2020/6/25 12:05
 *
 * @author liyh
 */
public class WordBreak {
}

class Solution139 {


    /**
     * 动态规划算法
     * dp代表在i位置上是否能在字典表上出现
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //这里从第一个位置i出发,填充dp
        for(int i = 1; i <= s.length(); ++i){
            //第二个循环用来使用判断下它前面的是否已经在字典表里面出现了。
            for(int j = 0; j < i; ++j){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * dp解法的优化算法，减少了一些重复的判断
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        if(wordDict.size() == 0){
            return false;
        }
        Set<String> set = new HashSet<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for(String word : wordDict){
            set.add(word);
            minLength = Math.min(minLength, word.length());
            maxLength = Math.max(maxLength, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); ++i){
            //计算left，right的值，锁定一个范围内进行判断。
            left = Math.max(i - maxLength + 1, 0);
            right = Math.max(i - minLength + 1, 0);
            for(int j = left; j <= right; ++j){
                if(dp[j] && set.contains(s.substring(j, i + 1))){
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
