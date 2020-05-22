package MayPratise;

import java.util.Arrays;

/**
 * ClassName: LongestSubStringContainVowelsInEvenCount
 * Description: 给一个字符串，找到最长的包含元音字符最长的子串长度
 * date: 2020/5/22 10:40
 *
 * @author liyh
 */
public class LongestSubStringContainVowelsInEvenCount {
}
class Solution1371 {
    /**
     * 这题首先使用前缀和数组的思想，加上一些状态压缩的思想，就变成了下面这个样子
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int len = s.length();
        int[] pos = new int[32];
        //初始化状态数组，这个数组维护5个元音出现奇偶情况。一种32种情况
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for(int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if(ch == 'a'){
                status ^= (1 << 0);
            }
            else if(ch == 'e'){
                status ^= (1 << 1);
            }
            else if(ch == 'i'){
                status ^= (1 << 2);
            }
            else if(ch == 'o'){
                status ^= (1 << 3);
            }
            else if(ch == 'u'){
                status ^= (1 << 4);
            }
            //出现相同的状态是因为中间的字符串满足了条件
            if(pos[status] >= 0){
                ans = Math.max(ans, i - pos[status] + 1);
            }
            //第一次出现这个状态的话就记录下位置
            else{
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}