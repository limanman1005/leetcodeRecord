package mySummary.stack;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: LC306And1081
 * Description:
 * date: 2021/9/8 16:51
 *
 * @author liyh
 */
public class LC316And1081 {
    public static void main(String[] args) {
        Solution316And1081 solution316And1081 = new Solution316And1081();
        String strs = solution316And1081.removeDuplicateLetters("cbacdcbc");
        System.out.println(strs);


    }
}

class Solution316And1081 {


    /**
     * 去除一个字符中的重复字符，其保持顺序不变，还需保证字典序最小。
     * 前两个问题使用一个记录是否出现的数组，然后顺序遍历即可。
     * 保证字典序则比较的麻烦。
     * 从左到右的遍历元素，如果发现当前元素比上一个元素小并且上一个元素在后面的序列中出现过，那么可以删除上一个元素，将当前元素放入结果容器中。
     * 这个意味着需要提前知道字符串中的字符信息，所有需要一个数组记录字符元素出现的次数。
     * 通过这样的方式，来保证相对位置最小的同时保证字典序不变。
     * 为了保证结果中只出现一次，如果发现栈中已经有了待遍历的元素，直接跳过。
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] count = new int[26];
        boolean[] exists = new boolean[26];
        char[] strs = s.toCharArray();
        for(char ch : strs){
            count[ch - 'a']++;
        }
        //这里直接存储Character可能会更好一点
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < strs.length; ++i){
            //栈中已有，直接跳过
            if(!exists[strs[i] - 'a']){
                //栈中不存在这个数，当前字符的字典序比栈顶的元素小且栈中的元素后面还会出现，那么可删除栈中当前的元素，并将boolean数组置为false
                while(!stack.isEmpty() && strs[stack.peekLast()] > strs[i] && count[strs[stack.peekLast()] - 'a'] > 0){
                    exists[strs[stack.pollLast()] - 'a'] = false;
                }
                //入栈并并标记入栈
                stack.addLast(i);
                exists[strs[i] - 'a'] = true;
            }
            //后续序列相应字符数减一
            count[strs[i] - 'a']--;
        }
        //拼接结果
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(strs[stack.pollFirst()]);
        }
        return sb.toString();
    }
}
