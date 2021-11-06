package mySummary.tree;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: InsertIntoABinaryTree
 * Description:
 * date: 2021/10/30 1:23
 *
 * @author liyh
 */
public class InsertIntoABinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Solution701 solution701 = new Solution701();
        solution701.insertIntoBST(treeNode, 2);
    }
}
class Solution701{

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode insertNode = new TreeNode(val);
            return insertNode;
        }
        if(val < root.val){
            TreeNode left = insertIntoBST(root.left, val);
            root.left = left;
        }
        else if(val >= root.val){
            TreeNode right = insertIntoBST(root.right, val);
            root.right = right;
        }
        return root;
    }
}
