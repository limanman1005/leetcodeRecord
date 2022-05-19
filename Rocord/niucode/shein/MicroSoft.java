package niucode.shein;

import java.math.BigInteger;

/**
 * ClassName: MicroSoft
 * Description:
 * date: 2021/10/16 13:57
 *
 * @author liyh
 */
public class MicroSoft {

    public static void main(String[] args) {
        SolutionMiroSoft solutionMiroSoft = new SolutionMiroSoft();
//        int[] A = {3, 5, 1};
//        int solution = solutionMiroSoft.solution(A);
//        System.out.println(solution);
//        String solution = solutionMiroSoft.solution("abc?ac");
//        System.out.println(solution);
        String solution = solutionMiroSoft.solution(6,1,1);
        System.out.println(solution);

    }


}
class SolutionMiroSoft {

    private String ans = null;
    private boolean flag = true;

    /**
     * 替换，字符串中的？号，使得相邻的字符不同
     * 回溯应该可以的，但是会不会超时
     * @param riddle
     * @return
     */
    public String solution(String riddle) {
        // write your code in Java SE 8
        char[] riddleChar = riddle.toCharArray();
        for (int i = 0; i < riddleChar.length; i++) {
            if(riddleChar[i] != '?'){
                continue;
            }
            else {
                char pre = (i == 0? ' ': riddleChar[i - 1]);
                char behind = (i == riddleChar.length - 1? ' ': riddleChar[i + 1]);
                char insert = 'a';
                while(insert == pre || insert == behind){
                    insert++;
                }
                riddleChar[i] = insert;
            }
        }
        return new String(riddleChar);
    }


    /**
     * 返回A，B，C个a,b,c组成的字符串，三个相同的字符串不能相邻
     * 这个感觉也只能暴力回溯，答案说了不考虑时间，那么就是暴力求解喽
     * @param A
     * @param B
     * @param C
     * @return
     */
    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        int len = A + B + C;
        char[] ansChars = new char[len];
        helper(A, B, C, 0, ansChars);
        return ans;
    }

    private void helper(int a, int b, int c, int cur, char[] ansChars) {
        if(cur == ansChars.length){
            if(flag){
                ans = new String(ansChars);
            }
            flag = false;
            return;
        }
        else{
            if(a > 0){
                if(cur >= 2 && ansChars[cur - 1] == 'a' && ansChars[cur - 2] == 'a'){

                }
                else{
                    ansChars[cur] = 'a';
                    helper(a - 1, b, c, cur + 1, ansChars);
                }
            }
            if(b > 0){
                if(cur >= 2 && ansChars[cur - 1] == 'b' && ansChars[cur - 2] == 'b'){

                }
                else{
                    ansChars[cur] = 'b';
                    helper(a, b - 1, c, cur + 1, ansChars);
                }
            }
            if(c > 0){
                if(cur >= 2 && ansChars[cur - 1] == 'c' && ansChars[cur - 2] == 'c'){

                }
                else{
                    ansChars[cur] = 'c';
                    helper(a , b, c - 1, cur + 1, ansChars);
                }
            }

        }
    }


    /**
     * 数组A中代表一些数字，然后这些数字乘以17，再将各个位数相加，既是结果。
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            stringBuilder.append(A[i]);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.reverse().toString());
        BigInteger multiNum = new BigInteger("17");
        BigInteger multiResult = bigInteger.multiply(multiNum);
        String ansStr = multiResult.toString();
        char[] numChars = ansStr.toCharArray();
        int ans = 0;
        for(int i = 0; i < numChars.length; ++i){
            ans += (numChars[i] - '0');
        }
        return ans;
    }
}
