package mySummary.tree;

/**
 * ClassName: DeleteLeavesWithAGivenValue
 * Description:
 * date: 26/4/2022 下午3:09
 *
 * @author liyh
 */
public class DeleteLeavesWithAGivenValue {
}
class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return null;
        }
        boolean deleteNode = dfs(root, target);
        if(deleteNode){
            return null;
        }
        else{
            return root;
        }
    }

    /**
     * 使用后续遍历，删除符合条件的叶子节点。
     * 使用返回值判断叶子节点是否符合条件，符合条件的删了。
     * 最后判断下自身节点的情况。和814几乎一样的思路
     * @param root
     * @param target
     * @return
     */
    private boolean dfs(TreeNode root, int target){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null && root.val == target){
            return true;
        }
        boolean leftDelete = dfs(root.left, target);
        boolean rightDelete = dfs(root.right, target);
        if(leftDelete){
            root.left = null;
        }
        if(rightDelete){
            root.right = null;
        }
        return root.val == target && root.left == null && root.right == null;
    }
}
