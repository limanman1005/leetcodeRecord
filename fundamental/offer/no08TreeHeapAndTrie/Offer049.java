package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: Offer049
 * Description: 根节点到叶节点的路径数字之和
 * date: 14/5/2022 上午10:18
 * @author liyh
 */
public class Offer049 {
}
class SolutionOffer049{
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[]{0};
        dfs(root, sb, ans);
        return ans[0];
    }

    /**
     * 遍历的时候记录下每个节点的值，到了叶子节点之后在记录下这个路径的值。
     * @param root
     * @param sb 记录值
     * @param ans 使用一个数组变量记录下每个路径的答案
     */
    private void dfs(TreeNode root, StringBuilder sb, int[] ans){
        if(root == null){
            return ;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            //这里切记不能return，否则的话将无法回溯。
            ans[0] += Integer.parseInt(sb.toString());
        }
        dfs(root.left, sb, ans);
        dfs(root.right, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
    }




    public int sumNumbers2(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pathSum){
        if(root == null){
            return 0;
        }
        int curSum = pathSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return curSum;
        }
        int leftSum = dfs(root.left, curSum);
        int rightSum = dfs(root.right, curSum);
        return leftSum + rightSum;
    }
}
