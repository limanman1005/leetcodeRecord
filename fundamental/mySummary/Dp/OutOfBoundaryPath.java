package mySummary.Dp;

/**
 * ClassName: LC576
 * Description:
 * date: 2021/8/19 0:15
 *
 * @author liyh
 */
public class OutOfBoundaryPath {
}
class Solution576 {
    /**
     * 目前写的这个dfs暴力搜索还是有问题的，1，3，3，0，1。这个测试用例通不过。
     * 思路没有问题就是边界有点问题，暂时放一放
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 1){
            if(startRow == 0 && (startColumn == 0 || startColumn == n - 1)){
                return 2;
            }
            else if(startRow == n - 1 && (startColumn == 0 || startColumn == n - 1)){
                return 2;
            }
            else if(startRow == 0 || startColumn == 0 || startRow == m - 1 || startRow == n - 1){
                return 1;
            }
            else{
                return 0;
            }
        }
        int sum = 0;
        int upPathNum = findPaths(m, n, maxMove - 1, startRow - 1, startColumn);
        int downPathNum = findPaths(m, n, maxMove - 1, startRow + 1, startColumn);
        int leftPathNum = findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
        int rightPathNum = findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
        sum = upPathNum + downPathNum + leftPathNum + rightPathNum;
        return sum;
    }
}
