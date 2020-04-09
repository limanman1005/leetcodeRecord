package chapter7;

import java.util.*;

/**
 * ClassName: recursive
 * Description:
 * date: 2020/4/4 11:30
 *
 * @author liyh
 */
public class Recursive {


    /**
     * 机器人走各自那道题。
     * @param x 横坐标
     * @param y 纵坐标
     * @return 答案
     */
    public static int robotR(int x, int y){
        //边界条件
        if(x == 1 || y == 1){
            return 1;
        }
        //状态转移的方法
        return robotR(x-1, y) + robotR(x, y-1);
    }

    /**
     * 机器人走格子的递推解法
     * @param x 格子的横坐标
     * @param y 格子的纵坐标
     * @return 答案
     */
    public static int robot(int x, int y){
        //存结果的数组。dp[i][j]为格子的横为i，纵为j的时候答案。
        int[][] dp = new int[x+1][y+1];
        //初始化一些边界条件
        for(int i = 1; i<=x; ++i){
            dp[1][i] = 1;
        }
        //初始化一些边界条件
        for(int i = 1; i<=y; ++i){
            dp[i][1] = 1;
        }
        //利用递推公式一步步向下推
        for(int i = 2; i <= x; ++i){
            for(int j= 2; j <= y; ++j){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        //dp[x][y]即为答案
        return dp[x][y];
    }

    /**
     * 无限个硬币组成一个固定的数有多少种解法。
     * 我觉得这里稍微有点漏洞的是如果没有1的硬币，结果为0好像不存在
     * @param coins 硬币数组
     * @param target 要凑成的目标
     * @return 组合数
     */
    public static int coin(int[] coins, int target){
        return makeChange(coins, target, coins.length-1);

    }

    /**
     * 凑硬币核心代码
     * @param coins 硬币数组
     * @param target 目标
     * @param index 现在选的硬币下标
     * @return 答案数
     */
    private static int makeChange(int[] coins, int target, int index) {
        //这里的判断其实还是有问题的。不过默认0为1的时候结果还是不错的
        //用硬币1凑只有一种结果
        if(index == 0){
            return 1;
        }
        //使用这个硬币可以凑成的结果数
        int sum = 0;
        //这个循环判断这个硬币可以取几个。
        for(int i = 0; i*coins[index] <= target; ++i){
            //进行递归取小一个面值的硬币可以取几个。
            sum +=makeChange(coins, target, index-1);
        }
        return sum;
    }

    /**
     * 递推方法求硬币那道题
     * @param coins 硬币数组
     * @param n 目前
     * @return 结果
     */
    private static int coin2(int[] coins, int n){
        //这个数组dp[x][y]代表的是使用coins的前x个硬币凑成目前y的答案。
        int[][] dp = new int[coins.length][n+1];
        //这是一些边界条件的处理
        for(int i = 0; i < coins.length; ++i){
            dp[i][0] = 1;
        }
        //这是一些边界条件的处理
        for(int i = 0; i < n + 1; ++i){
            dp[0][i] = 1;
        }
        //外面两层循环代表填充数组的顺序
        for(int i = 1; i < coins.length; ++i){
            for(int j = 1; j < n+1; ++j){
                //最内层的循环控制选取几个外层循环控制的硬币数。
                for(int k = 0; k*coins[i] <= j; k++){
                    dp[i][j] = dp[i][j] + dp[i-1][j-k*coins[i]];
                }
            }
        }
        return dp[coins.length-1][n];
    }

    /**
     * 这个把二位数组压缩成了一维。
     * 应该就是有的空间之后基本不怎么利用，压缩一下，没有什么具体的意思
     * @param coins 硬币数组
     * @param target 目标
     * @return 结果
     */
    public static int coin3(int[] coins, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <coins.length; ++i){
            for(int j = coins[i]; j < target + 1; ++j){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[target];
    }

    /**
     * 这个生成合法括号的题
     * @param n 使用几对括号
     * @return 结果
     */
    public static Set<String> parentThesis(int n){
        //在原来基础上的新结果
        HashSet<String> newRes = new HashSet<>();
        //边界条件
        if(n == 1){
            newRes.add("()");
            return newRes;
        }
        //得到上一次的结果
        Set<String> res = parentThesis(n - 1);
        //对小规模的进行扩展得到新的规模
        //即对小一个量级的结果遍历，不断的加上新的括号
        for(String s : res){
            //取出一个结果，对其进行遍历，发现可以加括号的就加上
            //这个是把可以加在右边的都加上去了。
            for(int i = 0; i < s.length(); ++i){
                if(s.charAt(i) == '('){
                    newRes.add(s.substring(0, i+1) + "()" + s.substring(i+1));
                }
            }
            //这个补充一个可以添加到左边的
            newRes.add("()" + s);
        }
        return newRes;
    }

    /**
         *求子集
         * @param arr 原数组
         * @param n 数组大小
         * @return 答案
         */
        public static Set<Set<Integer>> subset(int[] arr, int n){
            return getSubSet(arr, n, n - 1);

    }

    /**
     * 加了指向当前指针的的求子集的方法。感觉一般吧，我觉得回溯的方法是正解
     * @param arr 原数组
     * @param n 这个n在这看来好像没有必要。
     * @param cur 当前要不要选的元素
     * @return 选择或者不选择当前元素的结果
     */
    private static Set<Set<Integer>> getSubSet(int[] arr, int n, int cur) {
        //当前规模下的新set
        Set<Set<Integer>> nSet  = new HashSet<>();
        //边界条件。一个空的，一个加了第一个元素
        if(cur == 0){
            HashSet<Integer> nil = new HashSet<>();
            HashSet<Integer> first = new HashSet<>();
            first.add(arr[0]);
            nSet.add(first);
            nSet.add(nil);
            return nSet;
        }
        //得到规模较小的集合。
        Set<Set<Integer>> oldSet = getSubSet(arr, n, cur - 1);
        //遍历这个集合
        for(Set<Integer> set : oldSet){
            //取出一个集合后，新的结果加上这个集合。
            nSet.add(set);
            //然后把取出的集合复制一份。
            HashSet<Integer> clone = new HashSet<>(set);
            //拷贝的这一份添加一个元素
            clone.add(arr[cur]);
            //然后放到结果中
            nSet.add(clone);
        }
        return nSet;
    }

    /**
     * 求解子集的位运算法
     * @param arr
     * @return
     */
    public static List<List<Integer>> subSetsWithBit(int[] arr){
        Arrays.sort(arr);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i = (int) Math.pow(2, arr.length) - 1; i >= 0; --i){
            ArrayList<Integer> n = new ArrayList<>();
            for(int j = arr.length - 1; j >= 0; --j){
                if(((i>>j)&1) == 1){
                    n.add(arr[j]);
                }
            }
            res.add(n);
        }
        return res;
    }


    /**
     * 逐步生成打法，生成全排列。从第一个字符开始一个一个字符生成整个字符的全排列
     * 如何改编成递归解法，暂留。
     * 这个应该还有一个顺序的问题。不能控制
     * @param str 字符串
     * @return 结果
     */
    public static  ArrayList<String> permutation(String str){
        int n = str.length();
        ArrayList<String> res = new ArrayList<>();
        res.add(str.charAt(0) + "");
        //一个字符一个字符生成。
        for (int i = 1; i < n; i++) {
            //每次都创建一个新的数组来添加一个字符表示的全排列
            ArrayList<String> newRes = new ArrayList<>();
            //选择这个字符
            char charAt = str.charAt(i);
            //从原来的结果里面逐个挑出来，插入位置
            for(String s : res){
                //插前面是一个结果
                String newStr = charAt + s;
                newRes.add(newStr);
                //插后面是一个结果
                newStr = s + charAt;
                newRes.add(newStr);
                //插中间形成各个结果
                for(int j = 1; j < s.length(); j++){
                    newStr = s.substring(0, j) + charAt + s.substring(j);
                    newRes.add(newStr);
                }
            }
            res = newRes;
        }
        return res;
    }





    public static void main(String[] args) {
//        System.out.println(robotR(6, 6));
//        System.out.println(robot(6, 6));

        ArrayList<String> ans = permutation("abc");
        ans.forEach(System.out::println);
    }
}
