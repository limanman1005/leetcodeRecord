package mySummary.tree;

import mySummary.Dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: ZigZagTree
 * Description:给一棵树进行zig或者zag遍历。
 * date: 2020/7/6 18:29
 *
 * @author liyh
 */
public class ZigZagTree {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
    }
}
class Solution103 {
    /**
     * 这个BFS代码写的有点臃肿。但是我觉得清晰易懂。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftOrder = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            if(leftOrder){
                for(int i = 0; i < size; ++i){
                    TreeNode curNode = queue.poll();
                    if(curNode.left != null){
                        queue.offer(curNode.left);
                    }
                    if(curNode.right != null){
                        queue.offer(curNode.right);
                    }
                    curLevel.addLast(curNode.val);
                }
            }
            else{
                for(int i = 0; i < size; ++i){
                    TreeNode curNode = queue.poll();
                    if(curNode.left != null){
                        queue.offer(curNode.left);
                    }
                    if(curNode.right != null){
                        queue.offer(curNode.right);
                    }
                    curLevel.addFirst(curNode.val);
                }
            }
            ans.add(curLevel);
            leftOrder = !leftOrder;
        }
        return ans;
    }


    /**
     * dfs解法，使用先序遍历，添加一个level信息。在第一次到这个level的时候，加一个新的list
     * 然后判断下level的奇偶性，看下添加到头还是尾。
     * 最后遍历即可。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> result){
        if(level >= result.size()){
            LinkedList<Integer> nLevel = new LinkedList<>();
            nLevel.add(root.val);
            result.add(nLevel);
        }
        else{
            if(level % 2 == 0){
                result.get(level).add(root.val);
            }
            else{
                result.get(level).add(0, root.val);
            }
        }
        if(root.left != null){
            dfs(root.left, level + 1, result);
        }
        if(root.right != null){
            dfs(root.right, level + 1, result);
        }
    }
}
