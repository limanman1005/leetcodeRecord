package niucode.shopee.one;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/25 14:55
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        SolutionShopee01 solutionShopee01 = new SolutionShopee01();
        String str = "hello world, my friends";
        String ans = solutionShopee01.ReverseString(str);
        System.out.println(ans);
    }
}

class SolutionShopee01{


    public String ReverseString(String originStr) {
        // write code here
        char[] strChar = originStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strChar.length; i++){
            if(Character.isLetter(strChar[i]) || strChar[i] != ' '){
                stringBuilder.append(strChar[i]);
            }
            else {
                ans.append(stringBuilder.reverse().toString());
                ans.append(strChar[i]);
                stringBuilder.setLength(0);
            }
        }
        ans.append(stringBuilder.reverse().toString());
        return ans.toString();
    }
}
