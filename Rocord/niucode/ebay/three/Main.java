package niucode.ebay.three;

import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/19 20:46
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numLine = scanner.nextLine();
        String[] numSplit = numLine.split(" ");
        int M = Integer.parseInt(numSplit[0]);
        int N = Integer.parseInt(numSplit[1]);
        int K = Integer.parseInt(numSplit[2]);
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        String set1Str = scanner.nextLine();
        String set2Str = scanner.nextLine();
        String[] set1Split = set1Str.split(" ");
        String[] set2Split = set2Str.split(" ");
        for (int i = 0; i < M; i++) {
            set1.add(Integer.parseInt(set1Split[i]));
        }
        for (int i = 0; i < N; i++) {
            set2.add(Integer.parseInt(set2Split[i]));
        }
        int ans = getTargetNumCount(set1, set2, 0);
        System.out.println(ans);
    }

    private static int getTargetNumCount(HashSet<Integer> set1, HashSet<Integer> set2, int K) {
        int count = 0;
        HashSet<Integer> integers = new HashSet<>();
        for(Integer numOfSet1: set1){
            if(set2.contains(K - numOfSet1)){
                integers.add(K - numOfSet1);
                count++;
            }
        }
        set2.removeAll(set1);
        for(Integer numOfSet2: set2){
            if(set1.contains(K - numOfSet2)){
                count++;
            }
        }
        return count;
    }
}
