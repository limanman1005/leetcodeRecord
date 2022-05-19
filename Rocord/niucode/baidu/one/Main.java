package niucode.baidu.one;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/18 18:53
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < caseNum; ++i){
            int stateNum = Integer.parseInt(scanner.nextLine());
            if(judge(stateNum)){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }

    }

    private static boolean judge(int stateNum) {
        if(stateNum >= 400 && stateNum <= 599){
            return true;
        }
        else {
            return false;
        }

    }


}


class Solution1BaiDu{



}
