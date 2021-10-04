package mySummary.tree;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: symmetryTree
 * Description:
 * date: 2020/5/14 13:23
 *
 * @author liyh
 */
public class SymmetryTree {
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }
        else if(root1.val == root2.val){
            return helper(root1.left, root2.right) && helper(root1.right, root2.left);
        }
        else{
            return false;
        }

    }
}
