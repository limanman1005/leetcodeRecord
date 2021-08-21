package mySummary.Dfs;

/**
 * ClassName: Lc979
 * Description: 二叉树分配硬币
 * date: 2020/5/3 9:51
 * 这个其实没有太想通
 * @author liyh
 */
public class Lc979 {
}

class Solution979 {
    private int ans;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        System.out.println(dfs(root));
        return ans;
    }

    /**
     * 这个函数返回值是当前节点从左右子树移来硬币后留下一个之后应该移动多少硬币给上一层。
     * 正数表示向根节点移动，负数表示向叶子节点移动。如果给定的硬币数一定的话,最后返回的数一定是0
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
