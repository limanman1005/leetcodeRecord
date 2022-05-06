package offer;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;

/**
 * ClassName: Offer052
 * Description:
 * date: 3/5/2022 下午9:28
 *
 * @author liyh
 */
public class Offer052 {
    public static void main(String[] args) {
        SolutionOffer052And897 solutionOffer052And897 = new SolutionOffer052And897();
        TreeNode root = solutionOffer052And897.getATestNode();
        TreeNode treeNode = solutionOffer052And897.increasingBST(root);
        System.out.println(treeNode.val);
    }

}

class SolutionOffer052And897{

    /**
     * 将BST转化为一个从根节点到右节点的递增链表
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            //还是使用cur
            cur = stack.pollLast();
            //找到第一个节点，初始化一下
            if(pre == null){
                pre = cur;
                first = cur;
            }
            else{
                pre.right = cur;
                pre = cur;
            }
            //这两行是每次都必须执行的
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }

    public TreeNode getATestNode(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node8;
        node2.left = node1;
        node8.left = node7;
        node8.right = node9;
        return node5;
    }
}
