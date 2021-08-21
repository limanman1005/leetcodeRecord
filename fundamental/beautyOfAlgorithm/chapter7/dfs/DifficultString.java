package beautyOfAlgorithm.chapter7.dfs;

/**
 * ClassName: DifficultString
 * Description: 一个字符串，这个字符产包含相邻的重复子串，则是容易的串，否则称为困难的串
 * date: 2020/4/9 16:10
 * 输入正整数 n, L，输出前L个大写英文字符组成的字典序第n小的困难的串。
 * 例如L=3时，前7个困难的串分别为
 * A, AB, ABA, ABAC, ABACA, ABACAB, ABACABA
 * n=4的话输出ABAC
 * @author liyh
 */
public class DifficultString {
    private static int count;
    public static void main(String[] args) {
        int n = 4;
        int l = 3;
        dfs(l, n, "");
    }

    /**
     * 状态转移函数，从A开始，到指定的字符宽度结束。
     * @param l 字符的宽度
     * @param n 要求的第几个
     * @param prefix 目前的前缀
     */
    private static void dfs(int l, int n, String prefix) {
        //遍历可选串的范围
        for (char i = 'A'; i < 'A' + l; ++i){
            //首先判断下加上后缀是不是困难的串
            if(isHard(prefix, i)){
                //如果是，加上后缀输出
                String x = prefix + i;
                System.out.println(x);
                //计数加一
                count++;
                if(count == n){
                    System.exit(0);
                }
                //把加上后缀的进一步递归下去
                dfs(l, n, x);
            }
        }
    }

    /**
     * 此方法判断一个困难的串加上一个字符是否还是困难的串。
     * 基本思想是从尾部出发，尾部的一个字符和要加上的最后一个字符
     * 尾部的两个字符和最后一个字符加上倒数一个字符比较
     * 尾部的三个字符和最后一个字符加上倒数的两个字符比较
     * 以此类推，当然比较的字符串不能重叠。
     * @param prefix 前缀
     * @param i 需要加上的后缀
     * @return 判断结果
     */
    private static boolean isHard(String prefix, char i) {
        //这个是宽度。一开始为0
        int count = 0;
        //一开始比较后一个字符，后两个字符，所以j需要减2
        for(int j = prefix.length() - 1; j >=0; j-=2){
            //从prefix后面截取一部分东西
            final String s1 = prefix.substring(j, j + count + 1);
            //需要加上的字符和prefix上截取的一部分组合
            final String s2 = prefix.substring(j + count + 1) + i;
            if(s1.equals(s2)){
                return false;
            }
            count++;
        }
        return true;
    }

}
