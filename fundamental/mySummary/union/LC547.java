package mySummary.union;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LC547
 * Description: 此题也可利用BFS和DFS写，不过暂略吧
 * date: 2021/9/10 17:40
 *
 * @author liyh
 */
public class LC547 {
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind union = new UnionFind();
        for(int i = 0; i < isConnected.length; ++i){
            union.add(i);
            for(int j = 0; j < i; j++){
                if(isConnected[i][j] == 1){
                    union.merge(i, j);
                }
            }
        }
        return union.getSize();

    }
}

/**
 * 封装的并查集结构和算法
 */
class UnionFind{

    private Map<Integer, Integer> father;

    private int size = 0;

    public UnionFind(){
        father = new HashMap<Integer, Integer>();
        size = 0;
    }

    public void add(int x){
        if(!father.containsKey(x)){
            father.put(x, null);
            size++;
        }
    }

    public void merge(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            father.put(rootX, rootY);
            size--;
        }
    }

    public int find(int x){
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        while(x != root){
            int oFather = father.get(x);
            if(root != oFather){
                father.put(x, root);
            }
            x = oFather;
        }
        return root;
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public int getSize(){
        return size;
    }
}
