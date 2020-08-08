### DFS思想简介

如果能一致找那就一致向下走。直到达到条件返回。

伪代码如下

```java
public void dfs(...){
    if(到达边界条件){
        可以做一个操作，如添加一个状态的结果，或者进行判断
        返回
    }
    做一些操作
    for(对当前状态的每一个状态都进行遍历){
        //进入下一个状态,做一些操作也可以加到这里来
        dfs(...)
    }
}
```



#### 岛屿数量

>岛屿数量这道题是一个典型的多元DFS
>
>

```java
public int islandNum(char[][] island){
    if(island == null || island.length == 0 || island[0].length == 0){
        return 0;
    }
    int ans = 0;
    int rows = island.length;
    int cols = island[0].length;
    for(int i = 0; i < rows; ++){
        for(int j = 0; j < cols; ++j){
            if(island[i][j] == '1'){
                dfs(island, i, j);
                ans++;
            }
        }
    }
    return ans;
}
private void dfs(char[][] island, int x, int y){
    if(!inIsland(x, y) || island[x][y] == '0'){
        return ;
    }
    island[x][y] = '0';
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    for(int i = 0; i < 4; ++i){
        int nx = x + dx[i];
        int ny = y + dy[i];
        dfs(island, nx, ny);
    }
}
```



#### 目标和

>给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
>
>返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
>
>输入：nums: [1, 1, 1, 1, 1], S: 3
>输出：5
>解释：
>
>-1+1+1+1+1 = 3
>+1-1+1+1+1 = 3
>+1+1-1+1+1 = 3
>+1+1+1-1+1 = 3
>+1+1+1+1-1 = 3
>
>一共有5种方法让最终目标和为3。

这里就可以提供dfs遍历的方法对某一个状态进行遍历。

这个有点回溯的意思啊

```java
private int ans = 0;
public int findTarget(int[] nums, int target){
    dfs(nums, target, 0, 0);
    return ans;
}
private void dfs(int[] nums, int target, int i , int curSum){
    //一直向后走，走到头了就返回。
    if(i == nums.length){
        if(curSum == target){
            ans++;
        }
    }
    dfs(nums, target, i + 1, curSum + nums[i]);
    dfs(nums, target, i + 1, curSum - nums[i]);
}
```

#### LC 17电话号码的组合

>典型DFS遍历加回溯

```java
public List<String> letterCombination(String digits){
    if(特殊用例){
        直接返回结果
    }
    //对digits进行dfs遍历
    dfs(digits, 0);
    return ans;
}
public void dfs(String digit, int cur){
    //到达边界dfs的边界
    if(cur == digit.length){
        //将当前结果加入到ans中
        ans.add(当前进行的结果)
    }
    for(对当前所有能到到的状态进行遍历){
        sb.append(digit.charAt(i))
        dfs(digits, cur + 1 , sb);
        sb.deleteCharAt(sb.length - 1)
    }
}
```

#### LC 51，52N皇后问题

>经典DFS问题。

```java
//52求N皇后的解法个数的问题
private int ans = 0;
public int getNQUeueNum(int n){
    if(n == 1){
        return 1;
    }
    if(n < 4){
        return 0;
    }
    int[] arr = new int[n];
    dfs(arr, 0, n);
    return ans;
}
private void dfs(int arr, int cur, int n){
    if(reach the boundary){
        进行处理返回
    }
    //
    for(int i = 0; i < n; ++i){
        arr[cur] = i;
        if(check(arr, cur)){
            dfs(arr, cur + 1, n);
        }
        arr[cur] = 0;
    }
}
private void check(int[] arr, int cur){
    for(int i = 0; i < cur; ++i){
        //行减行，列减列，取绝对值都一样。
        if(arr[cur] == arr[i] || Math.abs(i - cur) == Math.abs(arr[i] - arr[cur])){
            return false;
        }
    }
    return true;
}

//51找出所有的Nqueue排列
class Solution51 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n < 0 || (n < 4 && n != 1)){
            return ans;
        }
        int[] arr = new int[n];
        List<String> oneResult = new ArrayList<>();
        dfs(arr, 0, n, oneResult);
        return ans;
    }
    private void dfs(int[] arr, int cur, int n, List<String> oneResult){
        if(cur == n){
            ans.add(new ArrayList<>(oneResult));
            return;
        }
        StringBuilder curRow = new StringBuilder();
        for(int i = 0; i < n; ++i){
            curRow.append('.');
        }
        for(int i = 0; i < n; ++i){
            arr[cur] = i;
            if(check(arr, cur)){
                curRow.setCharAt(i, 'Q');
                oneResult.add(curRow.toString());
                dfs(arr, cur + 1, n, oneResult);
                curRow.setCharAt(i, '.');
                oneResult.remove(oneResult.size() - 1);
            }
            //这里回不回溯都行
            arr[cur] = 0;
        }
    }
    private boolean check(int[] arr, int cur){
        for(int i = 0; i < cur; ++i){
            if(arr[i] == arr[cur] || Math.abs(i - cur) == Math.abs(arr[i] - arr[cur])){
                return false;
            }
        }
        return true;
    }
}
```



