package JunePractice;

/**
 * ClassName: QuerySum
 * Description: 有限制的求和
 * date: 2020/6/2 18:44
 * 还有一种位运算的题目。应该看一看
 * @author liyh
 */
public class QuerySum {
}

class SolutionM64 {
    /**
     * 有限制的求和
     * 因为不能使用循环选择使用递归。
     * @param n
     * @return
     */
    public int sumNums(int n) {
        //使用条件运算符短路，避免无穷递归。
        boolean tmp = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
    //此处应有位运算的解法
}
