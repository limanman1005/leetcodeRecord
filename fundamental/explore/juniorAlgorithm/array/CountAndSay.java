package explore.juniorAlgorithm.array;

/**
 * ClassName: CountAndSay
 * Description: 这个是字符串那一节的题，不小心放错了。
 * 这道题可以用递归也可以用循环，递归好写一点
 * date: 2020/6/3 9:47
 *
 * @author liyh
 */
public class CountAndSay {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        String s = solution38.countAndSay2(4);
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



    public String countAndSay2(int n) {
        if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        String prev = countAndSay2(n - 1);
        int left = 0;
        int right = 1;
        char[] chars = prev.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(; right < chars.length; ++right){
            if(chars[left] != chars[right]){
                sb.append(right - left).append(chars[left]);
                left = right;
            }
        }
        //这个条件有点秀啊，绕过了下标越界的判断
        //或者使用一个count也挺好
        if(left != right){
            sb.append(right - left).append(chars[left]);
        }
        return sb.toString();
    }


}
