package niucode.ebay.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/19 18:46
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if(judge(str)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }


    /**
     * 这道题和之前做过的不一样，修改一次，可以用删除一次思路参考以下做。
     * @param str
     * @return
     */
    private static boolean judge(String str) {
        int low = 0;
        int high = str.length() - 1;
        char[] strChars = str.toCharArray();
        while(low < high){
            if(strChars[low] == strChars[high]){
                low++;
                high--;
            }
            else {
                boolean leftFlag = true;
                boolean rightFlag = true;
                char tmp = strChars[low];
                strChars[low] = strChars[high];
                for(int i = low + 1, j = high - 1; i < j; i++, j--){
                    if(strChars[i] != strChars[j]){
                        leftFlag = false;
                        break;
                    }
                }
                strChars[high] = tmp;
                for(int i = low + 1, j = high - 1; i < j; ++i, j--){
                    if(strChars[i] != strChars[j]){
                        rightFlag = false;
                        break;
                    }
                }
                return leftFlag || rightFlag;

            }
        }
        return true;

    }
}
