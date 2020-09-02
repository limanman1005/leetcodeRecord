package inAndOut;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ClassName: Main
 * Description:
 * date: 2020/8/30 13:18
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int inSize = sc.nextInt();
//        String line  = sc.nextLine();
        String line2  = sc.nextLine();
        String[] lineArray = line2.split(" ");
        Arrays.sort(lineArray);
        for(int i = 0; i < inSize; ++i){
            System.out.print(lineArray[i]);
            if(i != inSize - 1){
                System.out.print(" ");
            }
        }
    }
}
