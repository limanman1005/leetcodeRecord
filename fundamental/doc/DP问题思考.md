[toc]

### DP问题思考

> 遇到DP问题怎么想？
>
> 首先要思考的就是能不能**从规模较小的问题能不能解答，规模比较小的问题怎么样才能推出大的问题。**
>
> 这一点非常重要
>
> DP问题，关键是如何划分出状态，以及找到状态转移方程（其实就是找到小问题如何推成大问题）

```java
public void dp(){
    int[] dp = new int[len];
    small answer;
    推导大问题。
    return;
}
```

#### 最长上升公共子序列（LC 1143）

```java
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; ++i){
            for(int j = 0; j < len2; ++j){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
```



#### 最大子序和（LC 53）

> 给一个数组找到连续子数组的最大子序和
>
> **状态是以当前数组结尾的最大子序和**

```java
public void dp(int[] arr){
    if(boundary condition){
        return special ans;
    }
    int[] dp = new int[arr.length];
    dp[0] = arr[0]
    //利用小问题向大问题推导
    for(int i = 1; i < len; ++i){
        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        ans = Matn.max(dp[i], ans);
    }
}
```

#### 乘积最大的子数组 （LC 152）

> 这个有可能有负数，所以需要维护一个最小的。
>
> **状态是以当前数字结尾的乘积最大的值。**

```java
public void dp(int[] arr){
    if(boundary condition){
        return special ans;
    }
    int[] minValue = new int[len];
    int[] maxValue = new int[len];
    minValue[0] = maxValue[0] = arr[0];
    //利用小问题，推导大问题。
    for(int i = 1; i < len; ++i){
        minValue[i] = Min(minValue[i - 1] * arr[i], maxValue[i - 1] * arr[i], arr[i]);
        maxValue[i] = Max(minValue[i - 1] * arr[i], maxValue[i - 1] * arr[i], arr[i]);
    }
    for(int i = 0; i < len; ++i){
        ans = max(arr[i], ans);
    }
    return ans;
}
```

#### 最低票价（LC 983）

> 这个问题的思考还是有价值的，
>
> **状态表示的是当前天的最小花费**，然后一步一步推到最后一天。

```java
public void dp(int[] days, int[] cost){
    int len = days.length;
    int n = days[len - 1];
    int[] dp = new int[n + 1];
    for(int i = 0; i < len; ++i){
        dp[days[i]] = -1;
    }
    int planA, planB, planC;
    //小问题，一步一步推的大问题
    for(int i = 1; i <= n; ++i){
        //不需要出游，和前一天一样
        if(dp[i] == 0){
            dp[i] = dp[i - 1];
        }
        else{
            planA = dp[i - 1] + costs[0];
            if(i - 7 >= 0){
                planB = dp[i - 7] + costs[1];
            }
            else{
                PlanB = costs[1];
            }
            if(i - 30 >= 0){
                planC = dp[i - 30] + costs[2];
            }
            else{
                planC = costs[2];
            }
            dp[i] = Math.min(a, b, c);
        }
    }
    return dp[n];
}
```

#### 最长回文子串 （LC 5）

> 这个动态规划并不是最优的，但是也有写一些的价值，尤其是这里的填表顺序，值得理清楚的一件事
>
> **状态是以i，j结尾的数字是不是回文。需要前一个状态DP\[i + 1]\[j- 1]**

```java
public void dp(String str){
	    
}
```


#### 221 最大正方形

> 和1277一样。
>
> **状态是dp\[i]\[j]代表当前坐标为右下角的矩形的边长是多少**（也就可以表示矩阵有多少个），转移就是dp\[i - 1]\[j],dp\[i]\[j - 1], dp\[i - 1]\[j - 1]中的最小值再加上1
>
> $$dp[i][j] = \begin{cases} 1 & \text{matrix[i][j] == 1 && (i == 0 || j == 0)} \\ min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1 & \text{matrix[i][j] = =1  && !(i == 0 || j == 0)} \\ 0 & \text{matrix[i][j] == 0} \end{cases}$$
>

```java
public void dp(int[][] matrix){
    if(boundray condition){
        return special ans;
    }
    //小问题推导大问题
    int[][] dp = new int[row][col];
    for(int i = 0; i < rows; ++i){
        for(int j = 0; j < cols; ++j){
            if(matrix[i][j] == '1'){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
    }
    return findMax(dp)^2;
}
```


#### 1277 统计全为一的正方形子矩阵（LC 1277）

> 这个也是典型的动态规划，思想就是如果当前数字为1，那么加上这个1可以组成的最大正方形是(i - 1, j), (i, j - 1), (i - 1, j - 1)中最小的再加上1也是刚好全为一的子矩阵的数量，所以把221数组里面的数字加起来就好了

```java
public void dp(int[][] matrix){
    if(boundary condition){
        return boudary ans;
    }
    int[][] dp = new int[rows][cols];
    for(int i = 0; i < rows; ++i){
        for(int j = 0; j < cols; ++j){
            if(matrix[i][j] == 1){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
            //this is the important point
            ans += dp[i][j];
        }
    }
    return ans;
}
```

#### 198 打家劫舍

> 状态就是前面几个屋子能偷到的最大的钱

```java
public void dp(int[] arr){
    int[] dp = new int[len];
    dp[0] = arr[0];
    dp[1] = max(arr[0], arr[1]);
    //小问题怎么推导出大问题
    for(int i = 1; i < len; ++i){
        dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])
    }
    return dp[n - 1];
}
```

####  121 股票1

> 状态就是截止到目前为止最小的票价
>
> 还有一种就是状态是截止目前为止最大利润。

```java
public void dp(int[] arr){
    int[] dp = new int[len];
    dp[i] = arr[i];
    for(int i = 1; i < len; ++i){
        dp[i] = min(dp[i - 1], arr[i]);
        ans = max(arr[i] - dp[i], ans);
    }
    return ans;
}

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int minPrice = prices[0];
        int[] dp = new int[n];
        for(int i = 1; i < n; ++i){
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }
```

#### 122 股票2

> 可以多次交易的时候，多加一个维度来定义卖出还是没有卖出。

```java
public void dp(int[] arr){
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = -arr[0];
    for(int i = 1; i < len; ++i){
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i]);
    }
    return dp[len - 1][0];
}
```



#### 123股票3

> 规定一个交易的次数
>
> 需要再次多加一个维度进行表示交易了多少次

```java
public void dp(int[] arr){
    int[][][] dp = new int[n][2][2];
    for(int i = 0; i < len; ++i){
        for(int k = 2; k >=0; ++j){
            if(i - 1 == -1){
                //边界条件
                dp[0][k][0] = 0;
                dp[0][k][1] = -prices[i];
                continue;
            }
            dp[i][k][0]  = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
            dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        }
    }
    return dp[n - 1][k][0];
}
```

#### 188 股票4

> 再次将交易的次数参数化

#### 309 含冷冻器的股票

#### 714 买卖股票含手续费

#### 332 硬币兑换

> 这道题我做过很多次。状态是总数是i的时候的最小花费即DP\[i]
>
> 状态转移就是如果对于每一个硬币来说

#### 410 分割数组最大值

> 这个题状态是

#### 312 戳气球

#### 1025 必赢游戏

#### 343 整数拆分

#### 97 交错字符串

#### 329 最长上升子序列的矩阵版

> 这个有点像从上至下的记忆化（动规）



#### 17_13字符串找单词

#### 63 唯一路径2

#### 字符串匹配的动态规划另开一个进行分析吧

