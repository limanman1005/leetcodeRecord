package juniorAlgorithm.tree;

import Dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: BFSTree
 * Description: 给一个二叉树，得到层序遍历的数列
 * date: 2020/6/18 19:51
 *
 * @author liyh
 */
public class BFSTree {
}
class Solution102 {

    /**
     * 使用队列，没啥好说的
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            ans.add(curLevel);
        }
        return ans;
    }
}