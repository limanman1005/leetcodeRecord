package explore.juniorAlgorithm.tree;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: ValidateBST
 * Description: 给一个树，判断下是不是二叉搜索树
 * date: 2020/6/18 19:36
 *
 * @author liyh
 */
public class ValidateBST {
}
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }

    /**
     * 这个方法的思路是开两个分支，然后传过去然后传过去验证分支对应的条件。进行验证
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min != null && min >= root.val){
            return false;
        }
        if(max != null && max <= root.val){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }


    long pre = Long.MIN_VALUE;

    /**
     * 这里直接贴甜姨的解法咯。
     * 和之前那个写的那个思路差不多
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST2(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST2(root.right);
    }


}
