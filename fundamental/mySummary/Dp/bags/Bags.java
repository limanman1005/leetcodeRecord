package mySummary.Dp.bags;

/**
 * ClassName: Bags
 * Description: 此类讲解三叶的背包问题。
 * date: 2021/8/22 0:00
 *
 * @author liyh
 */
public class Bags {
}
class SolutionBags{

    //输入: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
    //输出: 4
    //解释: 只选第一件物品，可使价值最大。
    //输入: N = 3, V = 5, v = [4,2,3], w = [4,2,3]
    //输出: 5
    //解释: 不选第一件物品，选择第二件和第三件物品，可使价值最大。
    /**
     * 01背包dp解法之一，使用了O(n2)的空间复杂度
     * @param value
     * @param weight
     * @param num 当前的物品
     * @param volume 当前的容量
     * @return
     */
    public int bags01(int[] value, int[] weight, int num,int volume){
        int[][] dp = new int[num][volume + 1];
        //baseCase初始化
        for(int i = 0; i <= volume; ++i){
            dp[0][i] = (i >= weight[0]? value[0]: 0);
        }
        //状态转移方程的转化
        //本解的状态定义为选择前i件物品且还剩下volume的容量的时候，价值最大。
        //关键是如何发现的状态定义，且发现状态的定义无后效性
        for(int i = 1; i < num; ++i){
            for(int j = 0; j <= volume; ++j){
                if(j >= weight[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[num - 1][volume];
    }

    /**
     * 压缩二维数组
     * @param value
     * @param weight
     * @param num
     * @param volume
     * @return
     */
    public int bags01Compress(int[] value, int[] weight, int num, int volume){
        int[][] dp = new int[2][volume + 1];
        for(int i = 0; i < volume; ++i){
            dp[0][i] = (i >= weight[0]? value[0]: 0);
        }
        for(int i = 1; i < num; ++i){
            for(int j = 0; j <= volume; ++j){
                if(j >= weight[i]){
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[(i - 1) & 1][j - volume]);
                }
                else{
                    dp[i & 1][j] = dp[(i - 1) & 1][j];
                }
            }
        }
        return dp[num - 1][volume];
    }

    /**
     * 将01背包问题压缩成为一维数组的形式，没有什么状态定义的意义理解，
     * 但是记住的话后面有个完全背包可以变一变直接用，节省点时间。
     * @param value
     * @param weight
     * @param num
     * @param volume
     * @return
     */
    public int bags01Compress2(int[] value, int[] weight, int num, int volume){
        //这里的dp数和上一维压缩之后是相同的
        int[] dp = new int[volume + 1];
        for(int i = 0; i < num; ++i){
            //这里倒着遍历是为了避免上一行的小的数据被覆盖
            //其实这样的边界没有覆盖所有的情况，可能会出问题，数据集大了可能会有错误
            for(int j = volume; j >= weight[i]; --j){
                int no = dp[j];
                int yes = dp[j - weight[i]] + value[i];
                dp[j] = Math.max(no, yes);
            }
        }
        return dp[volume];
    }

    /**
     * 完全背包的一般解法。
     * @param value
     * @param weight
     * @param num
     * @param volume
     * @return
     */
    public int fullBags(int[] value, int[] weight, int num, int volume){
        int[][] dp = new int[num][volume + 1];
        //如果只有一件物品，那么自然是取的越多越好
        //这里也是初始化条件
        for(int i = 0; i <= volume; ++i){
            int maxK = i / weight[0];
            dp[0][i] = maxK * weight[0];
        }
        //进入状态转移方程
        //在选择的时候需要一个循环在容量允许的情况下，枚举所有可能取的情况选择最大值之后在和没有选择的情况进行比较选择最大值
        for(int i = 1; i < num; ++i){
            for(int j = 0; j < volume; ++j){
                //不选的情况
                int notChoose = dp[i - 1][j];
                //选择的情况处理
                int choose = 0;
                for(int k = 1; ; k++){
                    if(j < value[i] * k){
                        break;
                    }
                    //选出一个k，当选择k件i商品的时候价值最大。
                    choose = Math.max(choose, dp[i - 1][j - weight[i] * k] + value[i] * k);
                }
                dp[i][j] = Math.max(notChoose, choose);
            }
        }
        return dp[num - 1][volume];
    }

    /**
     * 使用&优化的空间复杂度一种方案
     * @param value
     * @param weight
     * @param num
     * @param volume
     * @return
     */
    public int fullBags02(int[] value, int[] weight, int num, int volume){
        int[][] dp = new int[2][volume + 1];
        for(int i = 0; i <= volume; ++i){
            int maxK = i / weight[0];
            dp[0][i] = maxK * value[0];
        }
        for(int i = 1; i < num; ++i){
            for(int j = 0; j <= volume; ++j){
                int notChoose = dp[(i - 1) & 1][j];
                int choose = 0;
                for(int k = 1; ; k++){
                    if(k * weight[i] > j){
                        break;
                    }
                    choose = Math.max(choose, dp[(i - 1) & 1][j - k * weight[i]] + k * value[i]);
                }
                dp[i & 1][j] = Math.max(choose,notChoose);
            }
        }
        return dp[num - 1][volume];
    }

    /**
     * 完全背包的一维空间解法，此解法发现还降低时间复杂度。
     * 本质上就是发现了一些重复计算。
     * 这是因为dp[i][j]选择k个编号为i的物品的时候，此情况和dp[i][j - weight[i]]
     * 选择k - 1个编号为i的情况是相同的且这个情况已经算过了所以无需在计算。
     * @param value
     * @param weight
     * @param num
     * @param volume
     * @return
     */
    public int fullBags03(int[] value, int[] weight, int num, int volume){
        //没有进行初始化
        int[] dp = new int[volume + 1];
        for(int i = 0; i < num; ++i){
            //因为依赖本行的正上方和左边，所以需要先计算左边（j较小的），和01背包不一样
            for(int j = 0; j <= volume; ++j){
                if(j > weight[i]){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[volume];
    }
}
