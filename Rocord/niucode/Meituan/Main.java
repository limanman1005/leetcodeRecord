package niucode.Meituan;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/17 11:43
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCase; i++) {
            String nAndm = scanner.nextLine();
            String[] s = nAndm.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] edges = new int[m][2];
            String edgeStr = scanner.nextLine();
            getEdgesArr(edgeStr, edges);
            if(judge(n, edges)){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    private static boolean judge(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if(unionFind.find(x) == unionFind.find(y)){
                return false;
            }
            else {
                unionFind.union(x, y);
            }
        }
        return unionFind.getCount() == 1;
    }

    private static void getEdgesArr(String edgeStr, int[][] edges) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < edgeStr.length(); ++i){
            if(edgeStr.charAt(i) == ' ' || edgeStr.charAt(i) == '[' || edgeStr.charAt(i) == ']'){
                if(edgeStr.charAt(i) == ']'){
                    stringBuilder.append(',');
                }
            }
            else{
                stringBuilder.append(edgeStr.charAt(i));
            }
        }
        String s = stringBuilder.toString();
        String[] num = s.split(",");
        int idx = 0;
        for(int i = 0; i <edges.length; ++i){
            for(int j = 0; j < 2; ++j){
                edges[i][j] = Integer.parseInt(num[idx++]);
            }
        }

    }
}

class UnionFind{
    private int[] father;
    private int count;

    public UnionFind(int n){
        father = new int[n];
        count = n;
        for(int i = 0; i < n; ++i){
            father[i] = i;
        }
    }

    public int find(int p){
        int root = father[p];
        while(root != father[root]){
            root = father[root];
            while(p != root){
                int tmp = father[p];
                father[p] = root;
                p = tmp;
            }
        }
        return root;
    }


    public void union(int x, int y){
        int fatherX = find(x);
        int fatherY = find(y);
        if(fatherX != fatherY){
            father[fatherX] = fatherY;
            count--;
        }
    }

    public int getCount(){
        return this.count;
    }



}
