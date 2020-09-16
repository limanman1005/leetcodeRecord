package inAndOut.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2020/9/12 20:06
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0; i < num; ++i){
            strings.add(scanner.nextLine());
        }
        for(String str : strings){
            int ans = calculate(str);
            if(ans == Integer.MAX_VALUE){
                System.out.println("invalid");
            }
            else{
                System.out.println(ans);
            }
        }
    }

    public static int calculate(String str){
        return 1;
    }
}
