package juniorAlgorithm.tree;

import Dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: MaxDepthTree
 * Description: 计算二叉树的最大深度
 * date: 2020/6/18 19:06
 * 贴上一个题解的网址，可以看看上面的多种解法
 *  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/python-3di-gui-zi-ding-xiang-xia-zi-di-xiang-shang/
 * @author liyh
 */
public class MaxDepthTree {
}


class Solution104 {
    /**
     * 使用递归，老基础了。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max(lh, rh) + 1;
    }


    /**
     * 贴一个bfs的解法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i = 0; i < num; ++i){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            //每过一层，level++
            level++;
        }
        return level;
    }


}

