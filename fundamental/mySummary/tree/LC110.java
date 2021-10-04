package mySummary.tree;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: LC110
 * Description:
 * date: 2021/9/21 11:19
 *
 * @author liyh
 */
public class LC110 {
}
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = getDepth(root.left);
        int rh = getDepth(root.right);
        if(Math.abs(lh - rh) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        else{
            return false;
        }
    }
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = getDepth(root.left);
        int rh = getDepth(root.right);
        return Math.max(lh, rh) + 1;

    }
}
