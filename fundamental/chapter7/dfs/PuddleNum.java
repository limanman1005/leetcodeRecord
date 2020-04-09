package chapter7.dfs;

import java.util.Scanner;

/**
 * ClassName: PuddleNum
 * Description: 一道经典的题，求水洼的数目。
 * date: 2020/4/9 10:02
 * 测试用例
 *  输入
 *     N=10, M=12
 * 园子如下图（'W'表示积水， '.'表示没有积水）
 *
 * W........WW.
 * .WWW.....WWW
 * ....WW...WW.
 * .........WW.
 * .........W..
 * ..W......W..
 * .W.W.....WW.
 * W.W.W.....W.
 * .W.W......W.
 * ..W.......W.
 *
 * 输出
 *
 *     3
 * @author liyh
 */
public class PuddleNum {

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        char[][] a = new char[n][];
        for(int i = 0; i < n; ++i){
            a[i] = scanner.next().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] == 'W'){
                    dfs(a, i, j);
                    //这个则是判断有几个分支。
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(char[][] a, int i, int j) {
        //这个就是我做的处理，把这个水洼变成干的地。
        a[i][j] = '.';
        //剩下的就是对周围8个元素进行的遍历，把是水洼的转变成干的地。
        //k代表横坐标的偏移量
        //l代表纵坐标的偏移量
        for (int k = -1; k < 2; k++){
            for(int l = -1; l < 2; l++){
                //都不偏移代表自己，不需要处理
                if(k == 0 && l == 0){
                    continue;
                }
                //这个判断是横纵坐标有没有超出边界
                if(i + k >= 0 && i + k <= n - 1 && j +l >= 0 && j + l <= m - 1){
                    //如果没有超出边界，则判断是不是水洼。
                    if(a[i + k][j + l] == 'W'){
                        dfs(a, i+k, j + l);
                    }
                }
            }
        }
    }
}
