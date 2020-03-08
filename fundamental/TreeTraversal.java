import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 * ClassName: TreeTraversal
 * Description: 此类写树的三种遍历，前序，中序，后序，层序。
 * date: 2020/3/8 19:23
 *
 * @author liyh
 */
public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = getTreeNode();
        levelOrder(root);
        ArrayList<Integer> integers = new ArrayList<>();
    }

    public static void preOrderRecurrence(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderRecurrence(root.left);
        preOrderRecurrence(root.right);
    }

    public static void preOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                System.out.println(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
    }

    public static void inOrderRecurrence(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        inOrderRecurrence(curNode.left);
        System.out.println(curNode.val);
        inOrderRecurrence(curNode.right);
    }


    public static void inOrder(TreeNode curNode) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                System.out.println(curNode.val);
                curNode = curNode.right;
            }
        }
    }

    public static void postOrderRecurrence(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        postOrderRecurrence(curNode.left);
        postOrderRecurrence(curNode.right);
        System.out.println(curNode.val);
    }

    public static void postOrder(TreeNode curNode) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> reverseArray = new ArrayList<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                reverseArray.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.right;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.left;
            }
        }
        Collections.reverse(reverseArray);
        reverseArray.forEach(System.out::print);
    }

    public static TreeNode getTreeNode() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void levelOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(curNode);
        while (!queue.isEmpty()) {
            curNode = queue.removeFirst();
            System.out.println(curNode.val);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }
}
