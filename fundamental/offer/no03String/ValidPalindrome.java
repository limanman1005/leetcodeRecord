package offer.no03String;

/**
 * ClassName: ValidPalindrome
 * Description:
 * date: 29/4/2022 下午6:09
 *
 * @author liyh
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        SolutionOffer019And680 solutionOffer019And680 = new SolutionOffer019And680();
        boolean abca = solutionOffer019And680.validPalindrome("abca");
        System.out.println("abca = " + abca);
    }
}
class SolutionOffer019And680{
    public boolean validPalindrome(String s) {
        if(s == null){
            throw new NullPointerException();
        }
        if(s.length() < 2){
            return true;
        }
        int len  = s.length();
        int left = 0;
        int right = len - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                break;
            }
        }
        if(left == right){
            return true;
        }

        boolean leftPalind = isPalindRome(s, left + 1, right);
        boolean rightPalind = isPalindRome(s, left, right - 1);
        return leftPalind || rightPalind;
    }


    private boolean isPalindRome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
