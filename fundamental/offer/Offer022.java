package offer;

import explore.juniorAlgorithm.list.ListNode;

/**
 * ClassName: Offer022
 * Description:
 * date: 29/4/2022 下午7:49
 *
 * @author liyh
 */
public class Offer022 {
}
class SolutionOffer022And142{
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        //这个循环怎么写要记住。
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            return null;
        }
        ListNode pNode = head;
        while(pNode != slow){
            pNode = pNode.next;
            slow = slow.next;
        }
        return pNode;
    }
}
