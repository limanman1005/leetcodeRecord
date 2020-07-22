package juniorAlgorithm.list;

import explore.recursion.ListNode;

/**
 * ClassName: DeleteNthNodeInLinkedList
 * Description: 给一个链表和一个数n (n <len)删除节点得倒数第n个节点
 * date: 2020/6/18 15:20
 *
 * @author liyh
 */
public class DeleteNthNodeInLinkedList {
}

class Solution19 {
    /**
     * 此题一般有两种方法，一种是两次遍历，另一种是使用双指针一遍遍历。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        //使用头节点，避免特殊头节点的操作
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        //第一个指针先走n + 1步
        for(int i = 0; i <= n; ++i){
            first = first.next;
        }
        //然后两个节点都走，知道第一个节点到null。此时second指向倒数第K个节点。
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }
}

