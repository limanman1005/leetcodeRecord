package offer.no08TreeHeapAndTrie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: Offer064
 * Description:
 * date: 4/5/2022 下午1:26
 *
 * @author liyh
 */
public class Offer064 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dict = new String[]{"hello", "leetcode"};
        magicDictionary.buildDict(dict);
        boolean hell = magicDictionary.search("hello");
        System.out.println(hell);
    }
}
class MagicDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        root = new TrieNode();
        for(String str : dictionary){
            char[] strChars = str.toCharArray();
            TrieNode curNode = root;
            for(int i = 0; i < strChars.length; ++i){
                if(curNode.children.get(strChars[i]) == null){
                    curNode.children.put(strChars[i], new TrieNode());
                }
                curNode = curNode.children.get(strChars[i]);
            }
            curNode.isWord = true;
        }

    }

    public boolean search(String searchWord) {
        char[] searchChars = searchWord.toCharArray();
        int repalceCount = 0;
        TrieNode curNode = root;
        a: for(int i = 0; i < searchChars.length; ++i){
            if(curNode.children.size() == 0){
                return false;
            }
            if(curNode.children.get(searchChars[i]) == null){
                repalceCount++;
                if(repalceCount > 1){
                    return false;
                }
                Set<Character> keys = curNode.children.keySet();
                for(Character key : keys){
                    searchChars[i] = key;
                    i--;
                    continue a;
                }
            }
            else{
                curNode = curNode.children.get(searchChars[i]);
            }
        }
        if(curNode.isWord && repalceCount <= 1){
            return true;
        }
        else{
            return false;
        }
    }

    class TrieNode{
        boolean isWord;

        HashMap<Character, TrieNode> children;

        public TrieNode(){
            children = new HashMap<>();
        }
    }
}
