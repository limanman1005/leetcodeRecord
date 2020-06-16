package juniorAlgorithm.string;

/**
 * ClassName: MyStringToInteger
 * Description: 这是一道需要细心的题，没事多看看
 * date: 2020/6/13 18:21
 *
 * @author liyh
 */
public class MyStringToInteger {
}

class Solution {
    /**
     * 甜姨的解法
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        //首先去掉开头可能存在的空格
        while(idx < n && chars[idx] == ' '){
            idx++;
        }
        //去完后判断下是不是全部是空格
        if(idx == n){
            return 0;
        }
        //记录正负数，统统转成正数处理，并跳过符号位
        boolean negative = false;
        if(chars[idx] == '-'){
            negative = true;
            idx++;
        }
        else if(chars[idx] == '+'){
            idx++;
        }
        //如果不是符号位直接返回零
        else if(!Character.isDigit(chars[idx])){
            return 0;
        }
        int ans = 0;
        //开启循环做判断，首先需要位数没到头，然后这位上是个数字，进入循环
        while(idx < n && Character.isDigit(chars[idx])){
            int digit = chars[idx] - '0';
            //这里判断下可能溢出的情况
            if(ans > (Integer.MAX_VALUE - digit) / 10){
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            //在不溢出的情况下不断地累加数字
            ans = ans * 10 + digit;
            idx++;
        }
        //最后在做正负数的判断
        return negative? -ans: ans;
    }
}



