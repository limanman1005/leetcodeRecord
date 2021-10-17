package mySummary.Dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Lc515
 * Description:
 * date: 2020/5/6 11:37
 *
 * @author liyh
 */
public class FindLargestValueInEachTree {
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

    /**
     * 层序便利的的写法
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
