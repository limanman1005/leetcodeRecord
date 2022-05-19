package niucode.qushi.main;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/17 17:02
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();
//        String[] split1 = str1.split(" ");
//        String[] split2 = str2.split(" ");
        int[] movies = new int[]{1, 3, 1, 3};
        int[] time = new int[]{2, 3, 3, 6};
//        for (int i = 0; i < split1.length; i++) {
//            movies[i] = Integer.parseInt(split1[i]);
//            time[i] = Integer.parseInt(split2[i]);
//        }
        int ans = 0;
        int len = 0;
        //这里写错了，太失误了、
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j <= i; ++j){
                if(i < j + time[i] && movies[j] > 0){
                    ans++;
                    movies[j]--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

/**
 * 构造一个数据结构来做吗？
 */
class SolutionQushi1{

}

class TimeAndDuration{
    public int nums;

    public int time;
}
