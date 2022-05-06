package mySummary.array;

import java.util.*;

/**
 * ClassName: WordLadder2
 * Description:
 * date: 27/4/2022 下午6:17
 *
 * @author liyh
 */
public class WordLadder2 {
}
class Solution126 {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId;
    private ArrayList<String> idWord;
    private ArrayList<Integer>[] edges;

    public Solution126(){
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        for(String word : wordList){
            if(!wordId.containsKey(word)){
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        if(!wordId.containsKey(endWord)){
            return new ArrayList<>();
        }
        if(!wordId.containsKey(beginWord)){
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        edges = new ArrayList[idWord.size()];
        for(int i = 0; i < idWord.size(); ++i){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < idWord.size(); ++i){
            for(int j = i + 1; j < idWord.size(); ++j){
                if(transformCheck(idWord.get(i), idWord.get(j))){
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int dest = wordId.get(endWord);
        List<List<String>> ans = new ArrayList<>();
        int[] cost = new int[id];
        for(int i = 0; i < id; ++i){
            cost[i] = INF;
        }
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        while(!q.isEmpty()){
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1);
            if(last == dest){
                ArrayList<String> tmp = new ArrayList<>();
                for(int index : now){
                    tmp.add(idWord.get(index));
                }
                ans.add(tmp);
            }
            else{
                for(int i = 0; i < edges[last].size(); ++i){
                    int to = edges[last].get(i);
                    if(cost[last] + 1 <= cost[to]){
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp);
                    }
                }
            }
        }
        return ans;
    }
    private boolean transformCheck(String str1, String str2){
        int differences = 0;
        for(int i = 0; i < str1.length() && differences < 2; ++i){
            if(str1.charAt(i) != str2.charAt(i)){
                ++differences;
            }
        }
        return differences == 1;
    }
}
