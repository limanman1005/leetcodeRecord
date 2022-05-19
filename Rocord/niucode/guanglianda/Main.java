package niucode.guanglianda;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/20 14:04
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] split = firstLine.split(" ");
        int n = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int ans = 0;
        LinkedList<Circle> circles = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            String numLine = scanner.nextLine();
            String[] numSplit = numLine.split(" ");
            int u = Integer.parseInt(numSplit[0]);
            int v = Integer.parseInt(numSplit[1]);
            int r = Integer.parseInt(numSplit[2]);
            Circle circle = new Circle(u, v, r);
            circles.addLast(circle);
            ans = judge(circles, b);
        }
        System.out.println(ans);
    }

    private static int judge(LinkedList<Circle> circles, int b) {
        int ans = 0;
        while(!circles.isEmpty()){
            Circle circle = circles.pollFirst();
            if(circle.v + circle.r < b && circle.v - circle.r > 0 ){
                ans++;
            }
            else{
                Circle nextCircle = circles.peekFirst();

            }

        }
        return ans;
    }
}
class Circle{
    public int u;
    public int v;
    public int r;

    public Circle(int u, int v, int r) {
        this.u = u;
        this.v = v;
        this.r = r;
    }
}
