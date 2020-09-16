package inAndOut;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2020/8/30 13:18
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] tokens = s.split(" ");
        String s1 = tokens[0];
        String s2 = tokens[1];
        String s3 = tokens[2];
        int K = Integer.parseInt(tokens[3]);
        for(int i = 0; i < K; ++i){
            System.out.println(dfs(s1, s2, s3, new StringBuilder(), K, 0, 0));
        }
    }

//    public static int dfs(String s1, String s2, int p1, int p2, int k){
//        if(p1 == 0)
//    }
    public static boolean dfs(String s1, String s2, String s3,StringBuilder append,int k, int p1, int p2){
        if(k >= 0 && append.toString().equals(s3)){
            return true;
        }
       for(int i = 0; i < s1.length(); ++i){

       }
        return false;

    }

}
