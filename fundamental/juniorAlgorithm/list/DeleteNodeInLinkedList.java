package juniorAlgorithm.list;

import explore.ListNode;

/**
 * ClassName: DeleteNodeInLinkedList
 * Description: 给一个链表其中一个节点（非末尾节点）得引用。把他给删除了
 * 注：没有给头节点
 * date: 2020/6/18 15:15
 *
 * @author liyh
 */
public class DeleteNodeInLinkedList {
}

class Solution237 {
    /**
     * 此题算法就是把下一个节点得拿过来，然后把写一个节点给删了，效果和删除自己是一样的
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}