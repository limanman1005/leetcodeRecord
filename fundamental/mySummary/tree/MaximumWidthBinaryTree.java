package mySummary.tree;

import java.util.LinkedList;

/**
 * ClassName: MaximumWidthBinaryTree
 * Description:
 * date: 2021/10/27 20:35
 *
 * @author liyh
 */
public class MaximumWidthBinaryTree {
    public static void main(String[] args) {
        Solution662 solution662 = new Solution662();
        TreeNode root = solution662.getATestTree();
        int i = solution662.widthOfBinaryTree(root);
        System.out.println(i);
    }



}
class Solution662 {

    //todo 这个我还真的没有特别合理的解法了
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int ans = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(notAllNull(queue)){
                ans = Math.max(ans, size);
            }
            else{
                break;
            }
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.pollFirst();
                if(node != null){
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }
        return ans;
    }

    private boolean notAllNull(LinkedList<TreeNode> queue) {
        return false;
    }


    public TreeNode getATestTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node33 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node9 = new TreeNode(1);
        node1.left = node3;
        node1.right = node2;
        node3.left = node5;
        node3.right = node33;
        node2.right = node9;
        return node1;
    }
}
