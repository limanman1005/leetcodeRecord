package offer.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer086
 * Description:
 * date: 8/5/2022 下午11:18
 *
 * @author liyh
 */
public class Offer086 {
    public static void main(String[] args) {
        SolutionOffer086 solutionOffer086 = new SolutionOffer086();
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        list1.add("123");
        list2.add("456");
        list3.add("789");
        ans.add(list1);
        ans.add(list2);
        ans.add(list3);
        String[][] strs = convertArray(ans);
        System.out.println("strs = " + strs);

    }

    private static String[][] convertArray(List<List<String>> ans) {
        String[][] strings = new String[ans.size()][];
        for(int i = 0; i < ans.size(); ++i){
            strings[i] = new String[ans.get(i).size()];
            for(int j = 0;  j < strings[i].length; ++j){
                strings[i][j] = ans.get(i).get(j);
            }
        }
        return strings;
    }
}
class SolutionOffer086{

    private static String[][] convertArray(List<List<String>> ans) {
        String[][] strings = new String[ans.size()][];
        for(int i = 0; i < ans.size(); ++i){
            strings[i] = new String[ans.get(i).size()];
            for(int j = 0;  j < strings[i].length; ++j){
                strings[i][j] = ans.get(i).get(j);
            }
        }
        return strings;
    }

    public String[][] partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> oneResult = new ArrayList<>();
        helper(s, 0, oneResult, ans);
        return convertArray(ans);
    }

    private void helper(String s, int start, List<String> oneResult, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(oneResult));
            return ;
        }
        for(int i = start; i < s.length(); ++i){
            if(isPalindrome(s, start, i)){
                oneResult.add(s.substring(start, i + 1));
                helper(s, i + 1, oneResult, ans);
                oneResult.remove(oneResult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        int left = start;
        int right = end;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
