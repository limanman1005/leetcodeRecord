package mySummary.Dp.lis;

import java.util.Arrays;

/**
 * ClassName: LC960
 * Description: 删列造序，一个字符串数组，其中每个字符串长度都相等。
 * 对每一个字符串都固定删除一定的长度，求这个最小的长度。
 * 本质上就是求出每个字符串的最长上升子序列，然后找出最长上升子序列长度x，再使用总长度减去x即可。
 * date: 2021/9/14 10:42
 *
 * @author liyh
 */
public class DeleteColumnsToMakeSorted3 {
    public static void main(String[] args) {
        String[] strs = {"baabab"};
        Solution960 solution960 = new Solution960();
        int i = solution960.minDeletionSize2(strs);

    }
}

class Solution960 {
    /**
     * 这个还需要进一步解释
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        if(strs == null || strs.length == 0){
            return 0;
        }
        int row = strs.length;
        int col = strs[0].length();
        int[] dp = new int[col];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 0; i < col; ++i){
            for(int j = i + 1; j < col; ++j){
                boolean flag = true;
                for(int r = 0; r < row; ++r){
                    if(strs[r].charAt(j) < strs[r].charAt(i)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    maxLen = Math.max(dp[j], maxLen);
                }
            }
        }
        return col - maxLen;
    }



    public int minDeletionSize2(String[] ss) {
        int[] dp = new int[ss[0].length()];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            j:
            for (int j = 0; j < i; j++) {
                for (String s : ss) {
                    if (s.charAt(i) < s.charAt(j)) {
                        continue j;
                    }
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return dp.length - max;
    }


    public int minDeletionSize3(String[] strs) {
        int[] dp = new int[strs[0].length()];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 1; i < dp.length; ++i){
            for(int j = 0; j < i; ++j){
                //flag的位置有点坑啊
                boolean flag = true;
                for(String s : strs){
                    if(s.charAt(i) < s.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(dp[i], maxLen);
                }
            }
        }
        return dp.length - maxLen;
    }
}
