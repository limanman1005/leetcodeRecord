package mySummary.Dfs;

/**
 * ClassName: LowestCommonAncestor
 * Description: 找到二叉树的最近公共祖先.
 * date: 2020/5/11 15:50
 *
 * @author liyh
 */
public class LowestCommonAncestor {
}
class Solution236 {
    /**
     * 这个是递归解法。本质上就是一个递归遍历。这个后序的其实和求高度和展开链表有点像
     * 这个怎么说呢？都是从最底下向上返回的。所以可以返回最低的节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //找到或者到底了没找到。都返回root
        if(root == null || root == p || root == q){
            return root;
        }
        //这个就是在左边找和在右边找。拿到结果
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //根据找到的结果进行一些处理。如果左右都不为空。说明这个就是最小高度的节点了。
        if(left != null && right != null){
            return root;
        }
        //说明找到一个在左子树，返回左节点。
        else if(left != null){
            return left;
        }
        //找到一个在右子树，返回右节点。
        else if(right != null){
            return right;
        }
        return null;
    }
}

