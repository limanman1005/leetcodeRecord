package mySummary.listAndString;

import explore.recursion.ListNode;

/**
 * ClassName: ReorderList
 * Description:
 * date: 2021/10/27 18:08
 *
 * @author liyh
 */
public class ReorderList {

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode head = solution143.getATestList();
        solution143.reorderList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution143{
    /**
     * 先找到一半，然后在反转后一半，最后merger即可。
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode reverseL2 = reverseList(l2);
        while(reverseL2 != null){
            ListNode tmpL1 = l1.next;
            l1.next = reverseL2;
            ListNode tmpL2 = reverseL2.next;
            reverseL2.next = tmpL1;
            l1 = tmpL1;
            reverseL2 = tmpL2;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode reverseHead = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return reverseHead;
    }

    public ListNode getATestList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}
