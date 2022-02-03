package mySummary.stack;

/**
 * ClassName: LC321
 * Description: 此题将选取数字扩展到了2个数组，使用分治算法分别求出在归并。
 * date: 2021/9/8 17:04
 *
 * @author liyh
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("0123456789");
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        System.out.println(stringBuilder.toString());

    }
}



class Solution321{

}
