package explore.recursion;

/**
 * ClassName: KthPattern
 * Description:
 * date: 2020/5/13 11:23
 *
 * @author liyh
 */
public class KthPattern {
    public static void main(String[] args) {
        System.out.println(new Solution779().kthGrammar(1, 1));

    }
}
class Solution779 {
    public int kthGrammar(int N, int K) {
        char[] ans = getPattern(N).toCharArray();
        return ans[K - 1] - '0';
    }

    /**
     * 递归的思路对了，但是不够高效。堆内存也溢出了。
     * @param n
     * @return
     */
    public String getPattern(int n) {
        if(n == 1){
            return "0";
        }
        String prevPattern = getPattern(n - 1);
        char[] chars = prevPattern.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : chars){
            if(ch == '0'){
                sb.append("01");
            }
            else{
                sb.append("10");
            }
        }
        return sb.toString();
    }


    /**
     * 这个是根据规律，然后使用递归的做法。
     * 总体的思路就是计算出要算的那一位是根据哪一位生成的。
     * 然后根据这一位生成的规律，求出要算的是哪一位。
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar2(int N, int K) {
        if(N == 1){
            return 0;
        }
        int parent = kthGrammar2(N - 1, (K + 1)/2);
        //这个关系可以理解成parent为1或者parent为0的时候（k%2）相加等于1。
        //(k%2)的结果代表是生成的第几位。需要在每一层维护。在最底层和K没关系，但是在其他层的答案可就和他有关系了
        if(parent == 0){
            return 1 - (K % 2);
        }
        else{
            return K % 2;
        }
    }
}