package AugustPractice;

/**
 * ClassName: LonelyPixel
 * Description:
 * date: 2020/8/27 18:17
 *
 * @author liyh
 */
public class LonelyPixel {
    public static void main(String[] args) {
        Solution531 solution531 = new Solution531();
        char[][] arr = new char[][]{{'B', 'B', 'B'}};
        System.out.println(solution531.findLonelyPixel(arr));
    }
}

class Solution531 {
    /**
     * 甜姨的解法，找到满足行和列的最小值.（不容易想到）
     * 官方的解法提前统计下行或者列中的满足条件的值。
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0){
            return 0;
        }
        int rows = picture.length;
        int cols = picture.length;
        int rowNum = 0;
        for(int i = 0;  i < rows; ++i){
            int count = 0;
            for(int j = 0; j < cols; ++j){
                if(picture[i][j] == 'B'){
                    count++;
                }
            }
            if(count == 1){
                rowNum++;
            }
        }
        int colNum = 0;
        for(int i = 0; i < cols; ++i){
            int count = 0;
            for(int j = 0; j < rows; ++j){
                if(picture[j][i] == 'B'){
                    count++;
                }
            }
            if(count == 1){
                colNum++;
            }
        }
        return Math.min(rowNum, colNum);
    }
}
