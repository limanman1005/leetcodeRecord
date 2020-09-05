package explore.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ImplementTrieTree208
 * Description: 字典树的实现，还是不难的
 * date: 2020/8/4 18:12
 *
 * @author liyh
 */
public class ImplementTrieTree208 {
}
class Trie {
    class TrieNode{
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                cur.childrenMap.put(c, new TrieNode());
            }
            //添加了节点之后还需要向下走一步呢
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); ++i){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null){
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
