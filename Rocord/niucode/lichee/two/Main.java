package niucode.lichee.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/30 14:39
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        SolutionLeZhi02 solutionLeZhi02 = new SolutionLeZhi02();
        String[] words = {"abc", "bc", "ab", "qwe"};
        String[] words2 = {"k", "ki", "kir", "kira", "kiran"};
        String[] words3 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String s = solutionLeZhi02.longestWord2(words);
        System.out.println(s);
    }
}

class SolutionLeZhi02{


    public String longestWord(String[] words){
        if(words.length == 0){
            return "";
        }
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while(j < prefix.length() && j < words[i].length()){
                if(prefix.charAt(j) != words[i].charAt(j)){
                    break;
                }
                else {
                    j++;
                }
            }
            prefix = prefix.substring(0, j);
        }
        if("".equals(prefix)){
            return "";
        }
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].indexOf(prefix) == 0){
                strings.add(words[i]);
            }
        }
        Collections.sort(strings, (s1, s2) ->{
            if(s1.length() != s2.length()){
                return s2.length() - s1.length();
            }
            else{
                return s1.compareTo(s2);
            }
        });
        return strings.get(0);
    }


    public String longestWord2(String[] words){
        if(words == null || words.length == 0){
            return "";
        }
        HashSet<String> prefixes = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            prefixes.add(words[i]);
        }
        ArrayList<String> tmpAns = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            boolean contains = true;
            for(int j = 1; j <= tmp.length(); ++j){
                if(prefixes.contains(tmp.substring(0, j))){
                    continue;
                }
                else{
                    contains = false;
                }
            }
            if(contains){
                tmpAns.add(tmp);
            }
        }
        if(tmpAns.size() == 0){
            return "";
        }
        Collections.sort(tmpAns, (s1, s2) ->{
            if(s1.length() != s2.length()){
                return s2.length() - s1.length();
            }
            else{
                return s1.compareTo(s2);
            }
        });
        return tmpAns.get(0);
    }
}
