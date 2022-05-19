package niucode.shein;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/18 21:54
 *
 * @author liyh
 */
public class Main {
}

class SolutionSheIn1{
    public String changespaceto20(String str){
        if(str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                stringBuilder.append("%20");
            }
            else{
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }
}
