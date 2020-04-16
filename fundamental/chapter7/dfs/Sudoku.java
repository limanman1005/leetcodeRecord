package chapter7.dfs;

import java.util.Scanner;


/**
 * ClassName: Sudoku
 * Description: 还是体验dfs+上剪枝的解法
 * date: 2020/4/8 17:40
 * 测试用例
 * 输入：
 *
 * 005300000
 * 800000020
 * 070010500
 * 400005300
 * 010070006
 * 003200080
 * 060500009
 * 004000030
 * 000009700
 *
 * 程序应该输出：
 *
 * 145327698
 * 839654127
 * 672918543
 * 496185372
 * 218473956
 * 753296481
 * 367542819
 * 984761235
 * 521839764
 * @author liyh
 */
public class Sudoku {

    /**
     * 深度优先搜索加上剪枝。
     * @param table 数独数组
     * @param x x坐标
     * @param y y坐标
     */
    public static void dfs(char[][] table, int x, int y){
        //到达边界，输出结果
        if(x == 9){
            printArr(table);
            System.exit(0);
        }
        //这里需要填进去个数字
        if(table[x][y] == '0'){
            //这个循环遍历数字，选一个数字填进去。
            for(int k = 1; k < 10; k++){
                //判断能不能填上去，如果能填，则使用循环把所有能填进去的都试试
                if(check(table, x, y, k)){
                    table[x][y] = (char) ('0' + k);
                    //处理下一个状态。这里使用了数学的公式进行了状态转换。
                    dfs(table, x + (y + 1)/9, (y + 1) % 9);
                }
            }
            //回溯原来的结果。
            table[x][y] = '0';
        }
        else{
            //这个位置不需要填，直接进入下一个数字。
            dfs(table, x + (y + 1)/9, (y + 1) % 9);
        }
    }

    private static void printArr(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }

    /**
     * 检查某个数字能不能放进某个空格里面
     * @param table 数独数组
     * @param x 要放的x坐标
     * @param y 要放的y坐标
     * @param k 要放的数字
     * @return 能否放进去的结果
     */
    private static boolean check(char[][] table, int x, int y, int k) {
        //判断某个行或者某一列能否是否有重复的数字
        for (int i = 0; i < 9; ++i) {
            if (table[x][i] == (char) ('0' + k)) {
                return false;
            }
            if (table[i][y] == (char) ('0' + k)) {
                return false;
            }
        }
        //判断这个数字所在的九宫格是否有重复的数字。
        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for(int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++){
                if(table[i][j] == (char)('0' + k)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = scanner.nextLine().toCharArray();
        }
        dfs(table, 0, 0);
    }
}
