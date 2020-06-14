package juniorAlgorithm.array;

/**
 * ClassName: CountAndSay
 * Description: 这个是字符串那一节的题，不小心放错了。
 * date: 2020/6/3 9:47
 *
 * @author liyh
 */
public class CountAndSay {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        String s = solution38.countAndSay(4);
        System.out.println(s);
    }
}

class Solution38 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 1;
        for(right = 1; right < prev.length(); right++){
            if(prev.charAt(left) != prev.charAt(right)){
                int count = right - left;
                sb.append(count).append(prev.charAt(left));
                left = right;
            }
        }
        //这个条件有点意思，不等说明绕过了最后的一部分，需要加上
        if(left != right){
            int count = right - left;
            sb.append(count).append(prev.charAt(left));
        }
        return sb.toString();
    }


}
