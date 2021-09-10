package mySummary.stack;

/**
 * ClassName: LC321
 * Description:
 * date: 2021/9/8 17:04
 *
 * @author liyh
 */
public class LC321 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("0123456789");
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        System.out.println(stringBuilder.toString());

    }
}
