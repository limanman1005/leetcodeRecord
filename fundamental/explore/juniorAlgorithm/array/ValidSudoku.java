package explore.juniorAlgorithm.array;

/**
 * ClassName: ValidSudoku
 * Description: 给一个矩阵，判断一下这个矩阵里面的东西是不是一个有效的数独
 * date: 2020/6/2 18:51
 *
 * @author liyh
 */
public class ValidSudoku {
}
class Solution36 {
    /**
     * 遍历这个二维数组，使用额外的空间记录每一行，每一列，每一个小格子的信息。
     * 用数组的第一维分别代表第几行，第几列，第几个小格子。
     * 第二位代表这个数字出现的次数。
     * 每填入一个数字，就更新这个数字在辅助空间的信息。
     * 然后判断满不满足要求。如果不满组直接返回false
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxs = new int[9][10];
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char c = board[i][j];
                if(c != '.'){
                    int num = c - '0';
                    //这个计算的盒子索引太秀了，要记住啊
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i][num]++;
                    cols[j][num]++;
                    boxs[boxIndex][num]++;
                    if(rows[i][num] > 1 || cols[j][num] > 1 || boxs[boxIndex][num] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
