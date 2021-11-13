package mySummary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LC1382
 * Description: 将一个二叉搜索树变平衡。
 * 此题使用108的思路，首先将节点放入数组中就将问题转化为了108。
 * date: 2021/9/24 1:34
 *
 * @author liyh
 */
public class BalanceABinarySearchTree {
}
class Solution1382 {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null){
            return root;
        }
        List<Integer> treeVal = new ArrayList<>();
        dfs(root, treeVal);
        TreeNode bstTree = generateTree(treeVal, 0, treeVal.size() - 1);
        return bstTree;
    }

    public void dfs(TreeNode root, List<Integer> treeVal){
        if(root == null){
            return;
        }
        dfs(root.left, treeVal);
        treeVal.add(root.val);
        dfs(root.right, treeVal);
    }

    public TreeNode generateTree(List<Integer> treeVal, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(treeVal.get(mid));
        root.left = generateTree(treeVal, left, mid - 1);
        root.right = generateTree(treeVal, mid + 1, right);
        return root;
    }
}
