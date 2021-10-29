package mySummary.tree;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: InvertBinaryTree
 * Description:
 * date: 2021/10/29 18:35
 *
 * @author liyh
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution226 solution226 = new Solution226();
        TreeNode treeNode = solution226.invertTree(solution226.getATestTree());
        System.out.println(treeNode.val);
    }
}

class Solution226{

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode getATestTree(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        return root;
    }

}
