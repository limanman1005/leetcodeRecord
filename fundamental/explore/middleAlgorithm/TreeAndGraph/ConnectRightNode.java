package explore.middleAlgorithm.TreeAndGraph;

import java.util.LinkedList;

/**
 * ClassName: ConnectRightNode
 * Description: 对于一个完美二叉树右边有节点，那么使用在节点里面加一个next指针指向右边的节点
 * date: 2020/7/14 14:48
 *
 * @author liyh
 */
public class ConnectRightNode {
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution116 {
    /**
     * 这个dfs太秀了
     * @param root
     * @return
     */
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }
    private void dfs(Node node, Node next){
        if(node != null){
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null? node.next.left: null);
        }
    }

    /**
     * 贴一个递归的方法。
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if(root == null || root.left == null){
            return root;
        }
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    /**
     * 补一个使用队列，增加了空间复杂度的做法
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node tmp = queue.get(0);
            //将该层的节点连接起来
            for(int i = 1; i < queue.size(); ++i){
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            //在队列中填充下一层
            for(int i = 0; i < size; ++i){
                tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }

    /**
     * 加一个不用额外空间的循环解法
     * @param root
     * @return
     */
    public Node connect4(Node root) {
        if(root == null){
            return root;
        }
        Node cur = root;
        while(cur.left != null){
            Node tmp = cur;
            while(tmp != null){
                tmp.left.next = tmp.right;
                if(tmp.next != null){
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            cur = cur.left;
        }
        return root;
    }

    /**
     * 在提供一个递归的解法
     * @param root
     * @return
     */
    public Node connect5(Node root) {
        dfs2(root);
        return root;
    }
    private void dfs2(Node root){
        if(root == null){
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs2(root.left);
        dfs2(root.right);
    }

}
