package offer;

import explore.juniorAlgorithm.list.ListNode;

/**
 * ClassName: Offer077
 * Description:
 * date: 6/5/2022 下午5:31
 *
 * @author liyh
 */
public class Offer077 {
    public static void main(String[] args) {
        SolutionOffer077 solutionOffer077 = new SolutionOffer077();
        ListNode head = getATestList();
        ListNode sortedNode = solutionOffer077.sortList(head);
        System.out.println(sortedNode.val);

    }

    private static ListNode getATestList() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        return node4;
    }

}
class SolutionOffer077{

    /**
     * 根据堆排序的思想写出的代码，这个整合了一些知识点。例如链表排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = splitHead(head);
        head1 = sortList(head1);
        head2 = sortList(head2);
        return mergeList(head1, head2);
    }

    /**
     * 不如当个模板记下来比较好
     * @param head
     * @return
     */
    private ListNode splitHead(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode pNode = dummyHead;
        while(l1 != null || l2 != null){
            int val1 = (l1 != null? l1.val: Integer.MAX_VALUE);
            int val2 = (l2 != null? l2.val: Integer.MAX_VALUE);
            if(val1 < val2){
                pNode.next = l1;
                l1 = l1.next;
            }
            else{
                pNode.next = l2;
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        return dummyHead.next;
    }
}
