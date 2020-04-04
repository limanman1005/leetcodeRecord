package chapter7;

/**
 * ClassName: recurisive
 * Description:
 * date: 2020/4/4 11:30
 *
 * @author liyh
 */
public class Recursive {

    public static int robotR(int x, int y){
        if(x == 1 || y == 1){
            return 1;
        }
        return robotR(x-1, y) + robotR(x, y-1);
    }

    public static int robot(int x, int y){
        int[][] dp = new int[x+1][y+1];
        for(int i = 1; i<=x; ++i){
            dp[1][i] = 1;
        }
        for(int i = 1; i<=y; ++i){
            dp[i][1] = 1;
        }
        for(int i = 2; i <= x; ++i){
            for(int j= 2; j <= y; ++j){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        System.out.println(robotR(6, 6));
        System.out.println(robot(6, 6));
    }
}
