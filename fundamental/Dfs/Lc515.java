package Dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Lc
 * Description:
 * date: 2020/5/6 11:37
 *
 * @author liyh
 */
public class Lc515 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
    }
}

class Solution515 {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return ans;
        }
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.val);
        }
        else if(ans.size() > level && ans.get(level) < root.val){
            ans.remove(level);
            ans.add(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


}
