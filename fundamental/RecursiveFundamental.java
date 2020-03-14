/**
 * ClassName: RecursiveFundamental
 * Description:
 * date: 2020/3/15 0:09
 *
 * @author liyh
 */
public class RecursiveFundamental {


    /**
     * 求阶乘
     * @param n
     * @return
     */
    public static int printFactorial(int n){
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * printFactorial(n - 1);
    }

    /**
     * 打印i到j的总和
     * @param i
     * @param j
     */
    public static void printItoJ(int i , int j){
        if(i > j){
            return;
        }
        System.out.println(i);
        printItoJ(i+1, j);
    }

    /**
     * 数组arr的总和
     */
    public static int arrSum(int[] nums, int begin){
        if(begin >= nums.length){
            return 0;
        }
        return nums[begin] + arrSum(nums, begin + 1);
    }

    /**
     * 反转一个字符串
     * @param target
     * @param end
     * @return
     */
    public static String reverseString(String target, int end){
        if(end == 0){
            return "" + target.charAt(end);
        }
        return target.charAt(end) + reverseString(target, end -1);
    }
    public static String reverseStringChar(char[] src, int end){
            if(end == 0){
                return "" + src[0];
            }
            return src[end] + reverseStringChar(src, end - 1);
    }

    /**
     * 求斐波那契
     * @param n
     * @return
     */
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    /**
     * 辗转相除法的递归写法
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n){
        if(n == 0){
            return m;
        }
        return gcd(n, m%n);
    }

    /**
     * 这个hanoi塔提醒了我递归其实就是把问题划分成一个甚至多个子问题和一系列步骤的。
     * 如果能划分，我就在子问题处写递归，剩下的地方该怎么操作就怎么操作
     * @param n
     * @param from
     * @param to
     * @param help
     */
    public static void hanoi(int n, String from, String to , String help){
        if(n == 1){
            System.out.println("move " +n +  " form " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, help, to);
        System.out.println("move " + n + " from " + from + " to " +to);
        hanoi(n - 1, help, to, from);
    }

    public static void main(String[] args) {
        String src = "abcd";
//        System.out.println("reverseString(src, src.length() - 1) = " + reverseString(src, src.length() - 1));
//        System.out.println(reverseStringChar(src.toCharArray(), src.length() - 1));
        hanoi(3, "start", "end", "help");
    }
}
