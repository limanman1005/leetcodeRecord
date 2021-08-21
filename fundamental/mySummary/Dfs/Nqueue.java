package mySummary.Dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Nqueue
 * Description:
 * date: 2020/8/8 19:07
 *
 * @author liyh
 */
public class Nqueue {
}
class Solution51 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n < 0 || (n < 4 && n != 1)){
            return ans;
        }
        //这题这个是关键，使用了这个使得计算机可以判断什么时候冲突了，什么时候没有冲突。
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

class Solution52 {
    private int ans = 0;
    public int totalNQueens(int n) {
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n];
        dfs(arr, 0, n);
        return ans;
    }
    private void dfs(int[] arr, int cur, int n){
        if(cur == n){
            ans++;
            return ;
        }
        for(int i = 0; i < n; ++i){
            arr[cur] = i;
            if(check(cur, arr)){
                dfs(arr, cur + 1, n);
            }
            arr[cur] = 0;
        }
    }
    private boolean check(int k, int[] arr){
        for(int i = 0; i < k; ++i){
            if(arr[k] == arr[i] || Math.abs(k - i) == Math.abs(arr[k] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
