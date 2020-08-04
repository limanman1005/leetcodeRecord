package explore.microsoft.mySupplement;

import Dfs.TreeNode;

/**
 * ClassName: DeleteNodeInBST
 * Description: 在二叉搜索树中删除一个节点
 * date: 2020/8/4 13:47
 *
 * @author liyh
 */
public class DeleteNodeInBST {
}
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode node = root.right;
                while(node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
