package mySummary.tree;

/**
 * ClassName: PathsWithSumLCCI
 * Description:
 * date: 26/4/2022 下午2:11
 *
 * @author liyh
 */
public class PathsWithSumLCCI {
}

class Solution0412 {
    private int ans = 0;

    /**
     * 双递归求解，pathSum求的自身和其他节点开始的和sum，相当于外递归
     * dfs求的是以此节点开始路径开始的和，相当于求内递归
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        if(root.val == sum){
            ans++;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        return ans;
    }


    private void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }
        if(root.val == sum){
            ans++;
        }
        if(root.left != null){
            dfs(root.left, sum - root.val);
        }
        if(root.right != null){
            dfs(root.right, sum - root.val);
        }
    }
}
