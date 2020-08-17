### DP问题思考

> DP问题，关键是如何划分出状态，以及找到状态转移方程（其实就是找到小问题如何推成大问题）

```java
public void dp(){
    
}
```



#### 最大子序和（LC 53）

> 给一个数组找到连续子数组的最大子序和

```java
public void dp(int[] arr){
    if(boundary condition){
        return special ans;
    }
    int[] dp = new int[arr.length];
    dp[0] = arr[0]
    for(int i = 1; i < len; ++i){
        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        ans = Matn.max(dp[i], ans);
    }
}
```

#### 乘积最大的子数组 （LC 152）

> 这个有可能有负数，所以需要维护一个最小的

```java
public void dp(int[] arr){
    if(boundary condition){
        return special ans;
    }
    int[] minValue = new int[len];
    int[] maxValue = new int[len];
    minValue[0] = maxValue[0] = arr[0];
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

