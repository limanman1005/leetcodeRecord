package offer.no08TreeHeapAndTrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * ClassName: DebugOffer063
 * Description:
 * date: 15/5/2022 下午12:27
 *
 * @author liyh
 */
public class DebugOffer063 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> strs = new ArrayList<>();
        strs.add("cat");
        strs.add("bat");
        strs.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String s = solution.replaceWords(strs, sentence);
        System.out.println(s);
    }
}
class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = builderTrie(dictionary);
        String[] splits = sentence.split(" ");
        for(int i = 0; i < splits.length; ++i){
            splits[i] = findPreix(root, splits[i]);
        }
        return String.join(" ", splits);
    }

    private TrieNode builderTrie(List<String> dictionary){
        TrieNode root = new TrieNode();
        for(String str : dictionary){
            TrieNode curTrieNode = root;
            char[] strChars = str.toCharArray();
            for(int i = 0; i < strChars.length; ++i){
                if(curTrieNode.children.get(strChars[i]) == null){
                    curTrieNode.children.put(strChars[i], new TrieNode());
                }
                curTrieNode = curTrieNode.children.get(strChars[i]);
            }
            curTrieNode.isWord = true;
        }
        return root;
    }

    private String findPreix(TrieNode root, String word){
        TrieNode curNode = root;
        StringBuilder preix = new StringBuilder();
        for(int i = 0; i < word.length(); ++i){
            if(curNode.children.get(word.charAt(i)) == null){
                return word;
            }
            else{
                curNode = curNode.children.get(word.charAt(i));
                preix.append(word.charAt(i));
                if(curNode.isWord){
                    return preix.toString();
                }
            }
            Set<Character> characters = curNode.children.keySet();
        }
        return preix.toString();
    }

    class TrieNode{
        boolean isWord;

        HashMap<Character, TrieNode> children;

        public TrieNode(){
            children = new HashMap<>();
        }
    }
}
