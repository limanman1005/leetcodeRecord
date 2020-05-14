package explore;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: YanghuiTriangle
 * Description: 生成杨辉三角的递归和非递归的解法。
 * date: 2020/5/12 14:52
 *
 * @author liyh
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(1);
        List<Integer> row = new Solution118().getRow2(0, 4, cur);
        for (Integer integer : row) {
            System.out.println(integer);
        }
    }
}
class Solution118 {
    /**
     * 循环解法
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0){
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            row.add(1);
            for(int j = 1; j < rowNum; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 迭代解法
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0){
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            row.add(1);
            for(int j = 1; j < rowNum; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 杨辉三角取得其中一行，递归解法。
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex == 0){
            ans.add(1);
            return ans;
        }
        List<Integer> preRows = getRow(rowIndex - 1);
        ans.add(1);
        for(int i = 1; i < rowIndex; ++i){
            ans.add(preRows.get(i - 1) + preRows.get(i));
        }
        ans.add(1);
        return ans;
    }

    /**
     * 从前往后递归有点难啊，从小推向大有点循环的意思。
     * @param cur
     * @param target
     * @param prevRow
     * @return
     */
    public List<Integer> getRow2(int cur, int target, List<Integer> prevRow){
        if(cur == target){
            return prevRow;
        }
        ArrayList<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        for(int i = 1; i < prevRow.size(); ++i){
            curRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        curRow.add(1);
        return getRow2(cur + 1, target, curRow);
    }
}