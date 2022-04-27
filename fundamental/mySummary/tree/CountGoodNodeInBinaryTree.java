package mySummary.tree;

/**
 * ClassName: CountGoodNodeInBinaryTree
 * Description:
 * date: 26/4/2022 下午2:29
 *
 * @author liyh
 */
public class CountGoodNodeInBinaryTree {
}

class Solution1448{

    private int ans = 0;

    /**
     * 前序思路加上扩展参数的做法，把路径上的最大值传入和当前节点比较下，如果满足题意使用全局变量记录之。
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int maxValue){
        if(root == null){
            return;
        }
        if(root.val >= maxValue){
            ans++;
        }
        maxValue = Math.max(maxValue, root.val);
        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }


}
