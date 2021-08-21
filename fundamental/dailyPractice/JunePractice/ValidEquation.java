package dailyPractice.JunePractice;

/**
 * ClassName: ValidEquation
 * Description: 给定一个系列等式和不等式，判断下这个等式是不是相互矛盾。
 * 使用了并查集的手法，把等式看成一系列的树。建立并查集之后遍历一遍看有没有相互矛盾的
 * date: 2020/6/8 9:37
 *
 * @author liyh
 */
public class ValidEquation {
}
class Solution990 {
    public boolean equationsPossible(String[] equations) {
        int len = equations.length;
        int[] parent = new int[26];
        for(int i = 0; i < 26; ++i){
            parent[i] = i;
        }
        for(String str : equations){
            if(str.charAt(1) == '='){
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for(String str : equations){
            if(str.charAt(1) == '!'){
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if(find(parent, index1) == find(parent, index2)){
                    return false;
                }
            }
        }
        return true;
    }
    private void union(int[] parent, int index1, int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }
    private int find(int[] parent, int index){
        while(parent[index] != index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
