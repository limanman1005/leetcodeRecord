package chapter4;

/**
 * ClassName: ZTraverseMatrix
 * Description:
 * date: 2020/4/17 22:38
 *
 * @author liyh
 */
public class ZTraverseMatrix {


    /**
     * Z型遍历矩阵
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int num = rowNum * colNum;
        int[] ans = new int[num];
        int index = 0;
        //这个是观察得知Z型的遍历需要的数目
        int maxIndexSum = rowNum + colNum;
        for(int i = 0; i < maxIndexSum; ++i){
            int x = 0, y = 0;
            //从零开始
            //这个是奇数次
            if(i % 2 == 1){
                //这个判断如果没有过对角线的时候开始的x坐标是0，由数学关系可得y坐标
                if(i < colNum){
                    x = 0;
                    y = i;
                }
                else{
                    y = colNum - 1;
                    x = i - y;
                }
                //然后向下走
                //边界条件是x不能超过行数，y不能左边的0列
                while(x < rowNum && y >=0){
                    ans[index++] = matrix[x][y];
                    x++;
                    y--;
                }
            }
            //这边代表偶数的往上走的遍历。
            else{
                //如果没有过对角线这个初始坐标是y容易得是0，由数学关系可得x为i。
                if(i < rowNum){
                    x = i;
                    y = 0;
                }
                //过了对角线得化，x坐标易得为rowNum - 1, 有数学关系得y为i-x。
                else{
                    x = rowNum - 1;
                    y = i - x;
                }
                //然后向上走，边界条件注意判断一下
                while(x >= 0 && y < colNum){
                    ans[index++] = matrix[x][y];
                    x--;
                    y++;
                }
            }
        }
        return ans;
    }
}
