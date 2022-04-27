package mySummary.tree;

/**
 * ClassName: Solution783And530
 * Description:
 * date: 26/4/2022 下午4:25
 *
 * @author liyh
 */
public class MinimunDistanceBetweenBSTNodes {
}
class Solution783And530 {


    private int ans = Integer.MAX_VALUE;
    private int pre = -1;
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return ans;
    }

    /**
     * 扩展参数只能向下一层传递
     * @param root
     */
    private void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        dfs(root.left);
        if(pre != -1){
            ans = Math.min(ans, Math.abs(pre - root.val));
            pre = root.val;
        }
        else{
            pre = root.val;
        }
        dfs(root.right);
    }
}
