package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: TreeOrder
 * Description:
 * date: 11/5/2022 下午10:02
 *
 * @author liyh
 */
public class TreeOrder {
    public static void main(String[] args) {
        TreeNode root = getATree();
        List<Integer> preorder = preOrderTree(root);
        System.out.println("preOrder");
        preorder.forEach(System.out::print);
        System.out.println();
        List<Integer> inOrder = InOrderTree(root);
        System.out.println("inOrder");
        inOrder.forEach(System.out::print);
        System.out.println();
        List<Integer> postOrder = postOrderTree(root);
        System.out.println("postOrder");
        postOrder.forEach(System.out::print);
    }

    private static List<Integer> postOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.peekLast();
            //这里的表示当前节点的右子树不为空且当前节点的右节点还没有被访问过的时候就需要先访问右子树。
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
            }
            else{
                stack.pollLast();
                ans.add(cur.val);
                pre = cur;
                //这个必须要置空才能从栈中弹出父节点进行遍历。
                cur = null;
            }
        }
        return ans;
    }

    private static List<Integer> InOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    private static List<Integer> preOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                ans.add(cur.val);
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            cur = cur.right;
        }
        return ans;
    }

    private static TreeNode getATree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }
}
