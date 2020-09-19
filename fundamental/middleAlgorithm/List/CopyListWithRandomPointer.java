package middleAlgorithm.List;

import java.util.HashMap;

/**
 * ClassName: CopyListWithRandomPointer
 * Description:
 * date: 2020/9/16 16:00
 *
 * @author liyh
 */
public class CopyListWithRandomPointer {
}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
class Solution138 {
    /**
     * 使用了一个map来存放随机指针的信息
     */
    private HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null, null);
        map.put(oldNode, newNode);
        while(oldNode  != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }
    private Node getClonedNode(Node node){
        if(node != null){
            if(map.containsKey(node)){
                return map.get(node);
            }
            else{
                map.put(node, new Node(node.val, null, null));
                return map.get(node);
            }
        }
        return null;
    }
}
