package beautyOfAlgorithm.chapter7.dfs;

/**
 * ClassName: NQueuePractise
 * Description:
 * date: 2020/4/10 10:04
 *
 * @author liyh
 */
public class NQueuePractise {

    private static int n;
    private static int cnt;
    private static int[] table;

    public static void main(String[] args) {
        n = 8;
        table = new int[8];
        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int row){
        if(row == n){
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++){
            boolean ok = true;
            for (int i = 0; i < row; ++i){
                if(table[i] == col || table[i] + i == col + row || table[i] - i == col - row){
                    ok = false;
                    break;
                }
            }
            if(ok){
                table[row] = col;
                dfs(row + 1);
                table[row] = 0;
            }
        }
    }
}
