package mySummary.tree;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * ClassName: RecoverBinarySearchTree
 * Description:
 * date: 2021/10/27 20:27
 * 此题不适用常数级的空间的话需要使用莫瑞斯遍历
 *
 * @author liyh
 */
public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        TreeNode root = solution99.getTree();
        solution99.recoverTree(root);
        System.out.println(1);
    }
}

class Solution99{

    public void recoverTree(TreeNode root) {
        if(root == null){
            return ;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.addLast(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pollLast();
                if(firstNode == null){
                    firstNode = node;
                }
                else if(firstNode.val > node.val){
                    secondNode = node;
                    break;
                }
                else if(firstNode.val < node.val){
                    firstNode = node;
                }
                node = node.right;

            }
        }
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
        return ;
    }

    public TreeNode getTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node3.right = node2;
        return node1;

    }
}
