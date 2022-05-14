package offer.no08TreeHeapAndTrie;

import java.util.HashMap;

/**
 * ClassName: Offer062
 * Description:
 * date: 4/5/2022 上午11:31
 *
 * @author liyh
 */
public class Offer062 {
}

/**
 * root不占用char的数值
 * insert，isword，startWith三个函数几乎都一样。
 */
class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            char curChar = word.charAt(i);
            if(cur.children.get(curChar) == null){
                cur.children.put(curChar, new TrieNode());
            }
            cur = cur.children.get(curChar);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(cur.children.get(ch) == null){
                return false;
            }
            else{
                cur = cur.children.get(ch);
            }
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for(int i = 0; i < prefix.length(); ++i){
            char ch = prefix.charAt(i);
            if(curNode.children.get(ch) == null){
                return false;
            }
            else{
                curNode = curNode.children.get(ch);
            }
        }
        return true;
    }

    class TrieNode{
        public boolean isWord;
        public HashMap<Character, TrieNode> children;
        public TrieNode(){
            children = new HashMap<>();
        }
    }
}
