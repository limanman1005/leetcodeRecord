package offer.no04List;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import explore.recursion.ListNode;

import java.util.List;

/**
 * ClassName: ListCore
 * Description:
 * date: 11/5/2022 下午9:23
 *
 * @author liyh
 */
public class ListCore {

    public static void main(String[] args) {
        ListNode head = getATestList();
        ListNode halfHead = splitListInHalf(head);
        System.out.println(halfHead.val);
        ListNode reverseHead = reverseList(head);
        System.out.println(reverseHead.val);

    }

    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode splitListInHalf(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //注意这里是返回的是slow.next。且这里前半个链表比较长
        return slow.next;

    }

    private static ListNode getATestList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        return node1;
    }
}




