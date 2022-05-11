package offer.str;

/**
 * ClassName: IsPalindrome
 * Description:
 * date: 29/4/2022 下午5:21
 *
 * @author liyh
 */
public class IsPalindrome {
    public static void main(String[] args) {
        SolutionOffer018And125 solutionOffer018And125 = new SolutionOffer018And125();
        boolean op = solutionOffer018And125.isPalindrome("0P");
        System.out.println("op = " + op);
        System.out.println('a' - 'A');
    }
}
class SolutionOffer018And125{
    public boolean isPalindrome(String s) {
        if(s == null){
            throw new NullPointerException();
        }
        if(s.length() == 0 || s.length() < 2){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && !isLetterOrDigit(s, left)){
                left++;
            }
            while(left < right && !isLetterOrDigit(s, right)){
                right--;
            }
            if(!areCharactersEqual(s, left, right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isLetterOrDigit(String s, int idx){
        char ch = s.charAt(idx);
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')|| (ch >= '0' && ch <='9')){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean areCharactersEqual(String s, int left, int right){
        char leftChar = Character.toLowerCase(s.charAt(left));
        char rightChar = Character.toLowerCase(s.charAt(right));
        if((leftChar == rightChar)){
            return true;
        }
        else{
            return false;
        }
    }
}
