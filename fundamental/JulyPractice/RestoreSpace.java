package JulyPractice;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: RestoreSpace
 * Description: 给一串字符串，然后一个字典表。在字典表里面找到尽可能多的单词。使得未识别的单词数目最少。
 * 例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * date: 2020/7/9 9:22
 * 做过字体，还可以做一下1392这道题。
 * @author liyh
 */
public class RestoreSpace {
}

class Solution17_13 {
    /**
     * 此为dp解法，使用字典树优化的暂时不表
     * dp的思想还是说一下。
     * dp定义为前i个字符最少的未识别数量。
     * 这样话，对于每一i来说都去从0位置开始的之后的每一个位置和i组成的单词在不在
     * 字典表里。如果在了就在的dp[i]和dp[j]中取最小的一个。
     * 这里字典表的数据比较的多，hash时间可能会比较大
     * 还有就是如果一个字符串前缀或者后缀已经不再字典树里面了那么有些j到i之间不必要枚举
     * 这里使用字典树，来解决这个问题。
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>(1024);
        for(String str: dictionary) {
            dic.add(str);
        }
        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            //先假设当前字符作为单词不在字典中
            dp[i] = dp[i-1]+1;
            for(int j=0; j<i; j++){
                if(dic.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}
