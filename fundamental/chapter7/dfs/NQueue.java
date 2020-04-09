package chapter7.dfs;

/**
 * ClassName: NQueue
 * Description: 在n*n的棋盘上摆放N皇后
 * date: 2020/4/9 10:31
 *
 * @author liyh
 */
public class NQueue {

    private static int n;
    private static int cnt;
    private static int[] table;

    public static void main(String[] args) {
        n = 8;
        table = new int[8];
        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int row) {
        //边界条件，代表已经排放好了n个皇后了
        if(row == n){
            cnt++;
            return;
        }
        //外层循环代表，对每一个列都试一下。
        for(int col = 0; col < n; col++){
            boolean  ok = true;
            //这个循环代表和之前摆放好的皇后判断下冲突不冲突。row是之前已经摆好的皇后数目。
            for (int i = 0; i < row; i++) {
                //table数组的下标代表行号，内容代表列号。
                //table[i] == col 代表在同一列
                //table[i] + i == row + col 代表副对角线上的
                //table[i] - i == col -row 代表主对角线上的
                //如果满足其中一个条件则不能在这个位置摆放
                if(table[i] == col || i + table[i] == row + col || table[i] - i == col -row){
                    ok = false;
                    break;
                }
            }
            if(ok){
                //如果能在这里拜访的话那么，尝试在这里放一个。
                table[row] = col;
                //然后尝试在这里去摆放下一行。
                dfs(row + 1);
                //然后回溯。这里其实不回溯也行。
                table[row] = 0;
            }
        }
    }
}
