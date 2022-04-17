package mySummary.Dfs;

/**
 * ClassName: Lc979
 * Description: 二叉树分配硬币
 * date: 2020/5/3 9:51
 *
 * @author liyh
 */
public class DistributeCoinsInBinaryTree {
}

class Solution979 {
    private int ans;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        System.out.println(dfs(root));
        return ans;
    }

    /**
     * 这个函数返回值是当前节点和其子树平衡需要移动的硬币数量，如果是负数代表需要移过来多少硬币。
     * 左右节点需要移动的数量加上节点本身的值就是这个子树需要移动的硬币数量。
     * 但是函数返回值并不是答案，答案是每个子树移动的次数相加。
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //先求出左子树和右子树的应该以得硬币数
        int left = dfs(root.left);
        int right = dfs(root.right);
        //他们的绝对值之和就是这个这个子树需要移的次数。
        ans += Math.abs(left) + Math.abs(right);
        //返回这个节点应该移的硬币数
        return left + right - 1 + root.val;
    }
}
