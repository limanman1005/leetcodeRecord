package mySummary.tree;

/**
 * ClassName: BinaryTreePruning
 * Description:
 * date: 26/4/2022 下午2:57
 *
 * @author liyh
 */
public class BinaryTreePruning {
}

class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        boolean allZero = trim(root);
        if(allZero){
            return null;
        }
        else{
            return root;
        }
    }

    /**
     * 由底自上后序遍历，需要子树的结果。删去子树直接置null就好了。
     * 返回值是左右子树是否符合条件。
     * @param root
     * @return
     */
    private boolean trim(TreeNode root){
        if(root == null){
            return true;
        }
        boolean allZeroInLeft = trim(root.left);
        boolean allZeroInRight = trim(root.right);
        if(allZeroInLeft){
            root.left = null;
        }
        if(allZeroInRight){
            root.right = null;
        }
        return allZeroInRight && allZeroInLeft && root.val == 0;

    }
}
