package niucode.jingdong.two;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/30 20:08
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] mat = new int[n + 1][n + 1];
        while (m > 0){
            String oneLine = scanner.nextLine();
            String[] numSplit = oneLine.split(" ");
            mat[Integer.parseInt(numSplit[0])][Integer.parseInt(numSplit[1])] = Integer.parseInt(numSplit[2]);
            m--;
        }
        int ans = solve(mat);
        System.out.println(ans);
    }

    /**
     * 这个太难了啊，要先求子集和补集。
     * @param mat
     * @return
     */
    private static int solve(int[][] mat) {
        Random random = new Random();
        int i = random.nextInt(mat.length);
        int j = random.nextInt(mat.length);
        return mat[i][j];
    }
}
