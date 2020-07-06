package middleAlgorithm.TreeAndGraph;

import Dfs.TreeNode;

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
}
class Solution103 {
    /**
     * 这个代码写的有点臃肿。
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
                    curLevel.add(curNode.val);
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
                    curLevel.add(0, curNode.val);
                }
            }
            ans.add(curLevel);
            leftOrder = !leftOrder;
        }
        return ans;
    }
}