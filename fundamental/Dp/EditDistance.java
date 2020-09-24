package Dp;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: EditDistance
 * Description:
 * date: 2020/9/21 16:39
 *
 * @author liyh
 */
public class EditDistance {
}
class Solution72 {
    private Integer[][] memo;
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return helper(word1, word2, word1.length(), word2.length());
    }
    private int helper(String word1, String word2, int i, int j){
        if(i == 0 && j == 0){
            return 0;
        }
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            return helper(word1, word2, i - 1, j - 1);
        }
        else{
            int deleted = helper(word1, word2, i - 1, j);
            int insert = helper(word1, word2, i , j - 1);
            int replaced = helper(word1, word2, i - 1, j - 1);
            memo[i][j] = Math.min(Math.min(insert, deleted), replaced) + 1;
            return memo[i][j];
        }
    }
}