package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: Offer063
 * Description:
 * date: 4/5/2022 下午1:12
 *
 * @author liyh
 */
public class Offer063 {

    public static void main(String[] args) {
        SolutionOffer063 solutionOffer063 = new SolutionOffer063();
        String sentence = "the cattle was rattled by the battery";
        ArrayList<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String ans = solutionOffer063.replaceWords(dict, sentence);
        System.out.println("ans = " + ans);
    }
}
class SolutionOffer063 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = BuildTrie(dictionary);
        String[] splitSentence = sentence.split(" ");
        for(int i = 0;  i < splitSentence.length; ++i){
            String prefix = findPreix(root, splitSentence[i]);
            if(!prefix.isEmpty()){
                splitSentence[i] = prefix;

            }
        }
        return String.join(" ", splitSentence);
    }


    private TrieNode BuildTrie(List<String> dictionary){
        TrieNode root = new TrieNode();
        for(String curStr : dictionary){
            TrieNode pNode = root;
            for(int i = 0; i < curStr.length(); ++i){
                char curInsertChar = curStr.charAt(i);
                if(pNode.children.get(curInsertChar) == null){
                    pNode.children.put(curInsertChar, new TrieNode());
                }
                pNode = pNode.children.get(curInsertChar);
            }
            pNode.isWord = true;
        }
        return root;
    }

    private String findPreix(TrieNode root, String word){
        StringBuilder prefix = new StringBuilder();
        TrieNode pTrieNode = root;
        for(int i = 0; i < word.length(); ++i){
            char curChar = word.charAt(i);
            if(pTrieNode.children.get(curChar) == null){
                break;
            }
            else{
                //找到最短的前缀
                if(pTrieNode.isWord){
                    return prefix.toString();
                }
                else{
                    prefix.append(curChar);
                    pTrieNode = pTrieNode.children.get(curChar);
                }
            }
        }
        //判断最后一个是不是前缀
        if(pTrieNode.isWord){
            return prefix.toString();
        }
        else{
            return "";
        }
    }
}

class TrieNode{
    public boolean isWord;

    public HashMap<Character, TrieNode> children;

    public TrieNode(){
        children = new HashMap<>();
    }
}
