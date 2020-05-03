package Dfs;

/**
 * ClassName: Lc513
 * Description: 找到树上的最下层的最靠左的节点
 * date: 2020/4/29 18:12
 * e.m.
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出 7
 * @author liyh
 */
public class Lc513 {
}

/**
 * 此题还有非递归的解法，可以做一做
 */
class Solution513_1 {
    private int maxLevel = Integer.MIN_VALUE;
    private int ans;

    /**
     * 使用递归的dfs解法
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int level){
        if(root == null){
            return ;
        }
        //这个<号用的妙。
        if(maxLevel < level){
            maxLevel = level;
            ans = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
