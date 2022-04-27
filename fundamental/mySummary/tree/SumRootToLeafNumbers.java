package mySummary.tree;

/**
 * ClassName: SumRootToLeafNumbers
 * Description:
 * date: 26/4/2022 下午2:21
 *
 * @author liyh
 */
public class SumRootToLeafNumbers {
}

class Solution129{
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 0);
        return ans;
    }

    /**
     * 这个扩展了下参数信息，还是挺不错的。
     * @param root
     * @param num
     */
    private void dfs(TreeNode root, int num){
        if(root == null){
            return ;
        }
        num = 10 * num + root.val;
        if(root.left == null && root.right == null){
            ans += num;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
