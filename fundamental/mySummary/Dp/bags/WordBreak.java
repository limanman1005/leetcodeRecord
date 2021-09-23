package mySummary.Dp.bags;

import java.util.ArrayList;
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
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");
        boolean ans = solution139.wordBreak3("leetcode", strings);
        System.out.println(ans);
//        String test = "123";
//        System.out.println(test.substring(0, 3));
    }
}

class Solution139 {


    /**
     * 递归写法，递归函数的意思是以这个开头的字符串在不在字典中。
     * 推向下一个东西就是，从这个开头一直推向结尾的看下可不可以包含字典里面的数组。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        else if(wordDict.size() == 0){
            return false;
        }
        //todo 这题的从后向前还是能好好分析一波的。
        return dfs(s, wordDict, 0);
    }
    private boolean dfs(String s, List<String> wordDict, int start){
        if(start == s.length()){
            return true;
        }
        for(int end = start + 1; end <= s.length(); ++end){
            if(wordDict.contains(s.substring(start, end)) && dfs(s, wordDict, end)){
                return true;
            }
        }
        return false;
    }




    /**
     * 动态规划算法
     * dp代表在i位置上是否能在字典表上出现
     * 这个解法可以理解为完全背包问题，但是需要提前想好遍历的顺序
     * 有一点难想，所以不按照背包的思路反而好理解。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //这里从第一个位置i出发,填充dp
        //背包容量必须在外
        for(int i = 1; i <= s.length(); ++i){
            //第二个循环用来使用判断下它前面的是否已经在字典表里面出现了。
            //j到i的连续字串一一试探
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
