package sort;

import Dfs.TreeNode;

import java.util.LinkedList;

/**
 * ClassName: sort.TreeTraversal0401
 * Description:
 * date: 2020/4/1 11:42
 *
 * @author liyh
 */
public class TreeTraversal0401 {
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void preOrder2(TreeNode curNode){
        if(curNode == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()){
            while(curNode != null){
                System.out.println(curNode.val);
                stack.add(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()){
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
    }
    public static void inOrder2(TreeNode curNode){
        if(curNode == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(curNode != null || !stack.isEmpty()){
            while(curNode != null){
                stack.add(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()){
                curNode = stack.pop();
                System.out.println(curNode.val);
                curNode = curNode.right;
            }
        }
    }
    public static void postOrder2(TreeNode curNode){
        if(curNode == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> array = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                array.add(0, curNode.val);
                stack.add(curNode);
                curNode = curNode.right;
            }
            if(!stack.isEmpty()){
                curNode = stack.pop();
                curNode = curNode.left;
            }
        }
        array.forEach(System.out::println);
    }


    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.removeFirst();
            System.out.println(curNode.val);
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeTraversal.getTreeNode();
        postOrder(root);
        System.out.println("===================================");
        postOrder2(root);
        System.out.println("===================================");
        levelOrder(root);
    }
}
