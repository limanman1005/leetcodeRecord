package middleAlgorithm.List;

import explore.ListNode;

/**
 * ClassName: TwoLinkedListIntersection
 * Description: 给两个链表，如果相交找到相交点
 * 否则返回null
 * date: 2020/7/6 19:13
 *
 * @author liyh
 */
public class TwoLinkedListIntersection {
}

class Solution160 {
    /**
     * 这个的解法还是很巧妙的
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            p1 = (p1 == null ? headB: p1.next);
            p2 = (p2 == null ? headA: p2.next);
        }
        return p1;
    }
}