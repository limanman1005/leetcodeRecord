package mySummary.stack;

import java.util.LinkedList;

/**
 * ClassName: LC402
 * Description: 移掉K位数字，使其结果最小，并且保持原有顺序
 * date: 2021/9/8 16:50
 *
 * @author liyh
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        String s = solution402.removeKdigits("10001", 4);
        System.out.println(s);
    }
}
class Solution402 {
    /**
     * 此题的整体思路是尽可能保留高位上的小数字，为了保持原有顺序那么使用一个栈来进行处理是什么有必要的
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || num.length() < k){
            return "";
        }
        int len = num.length();
        if(len == k){
            return "0";
        }
        //因为要找打最小的，需要让最高位尽可能的小，将每一位都放入栈中，如果下一位比栈顶的元素小，那么出栈栈顶元素，让较小的元素进栈充当答案位数之一
        //从左到右的遍历保证了原有顺序不变
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < len; ++i){
            //这里使用一个栈记录下一个比栈顶元素小的，需要加上一个条件就是删除的次数大于零才能出栈
            //这个循环不能保证一定删了k次，如果数字刚好是升序的那么可能一次也不删
            while(k > 0 && !stack.isEmpty() && num.charAt(i) <stack.peekLast()){
                //出栈顶元素
                stack.pollLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        //将栈中元素拼接位字符串
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        //可能存在没有删除够k个，需要删除尾部的几个元素
        if(k > 0){
            sb.delete(sb.length() - k, sb.length());
        }
        //删除前导零
        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        //如果删完了那么返回零
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
