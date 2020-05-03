package Recursive;



/**
 * ClassName: Lc938
 * Description: 在一个二叉搜索树中找到在一定范围内的节点值之和。
 * 这个关键就在练习使用标准的递归形式以及去掉不必要的搜索，dfs剪枝其实也可以
 * date: 2020/4/27 16:20
 *
 * @author liyh
 */
public class Lc938 {
}

class Solution938 {
    /**
     * 这个是标准的递归形式，这个也剪枝了。
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        //如果树为空，直接返回零
        if(root == null){
            return 0;
        }
        //如果树节点的值小于L，则去累加右子树较大的值
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        //如果树节点的值大于R，则去累加左子树较小的值
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        //这个就是处理方法，当前符合条件的值，加上左子树的值符合条件的值和右子树符合条件的值。
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
    private int ans;

    /**
     * 这回使用dfs的解法。
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int useDfs(TreeNode root, int L, int R){
        if(root == null){
            return ans;
        }
        dfs(root, L, R);
        return ans;
    }

    /**
     * dfs解法
     * @param root
     * @param l
     * @param r
     */
    private void dfs(TreeNode root, int l, int r) {
        if(root == null){
            return;
        }
        if(root.val >=l && root.val <= r){
            ans += root.val;
        }
        //这里判断下提前剪枝
        if(root.val > l){
            dfs(root.left, l, r);
        }
        //这里判断下提前剪枝
        if(root.val < r){
            dfs(root.right, l, r);
        }
    }
}

