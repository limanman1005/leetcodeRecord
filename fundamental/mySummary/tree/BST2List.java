package mySummary.tree;

/**
 * ClassName: BST2List
 * Description:
 * date: 14/6/2022 上午12:11
 *
 * @author liyh
 */
public class BST2List {
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

/**
 * 非递归版本等下再说吧
 */
class Solution426AndOffer36{
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        inorder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inorder(Node root){
        if(root == null){
            return ;
        }

        inorder(root.left);

        if(pre == null){
            head = root;
            pre = head;
        }
        else{
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        inorder(root.right);
    }

}
