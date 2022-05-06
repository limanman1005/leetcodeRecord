package offer;

import explore.juniorAlgorithm.list.ListNode;

/**
 * ClassName: Offer021
 * Description:
 * date: 29/4/2022 下午6:19
 *
 * @author liyh
 */
public class Offer021 {
}
class SolutionOffer021And19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pNode = dummyHead;
        ListNode pre = dummyHead;
        for(int i = 0; i < n; ++i){
            pNode = pNode.next;
        }
        while(pNode.next != null){
            pNode = pNode.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
