package explore.middleAlgorithm.List;

import explore.recursion.ListNode;

/**
 * ClassName: M0207
 * Description:
 * date: 2021/9/21 9:37
 *
 * @author liyh
 */
public class M0207 {
}
class SolutionM0207 {
    /**
     * 相交链表的简单解法，两个链表的指针一直向前走，到了终点就换条链表走，
     * 直到相遇走了相同的长度，所以相遇之后一定是相交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            p1 = (p1 == null ? headB: p1.next);
            p2 = (p2 == null ? headA: p2.next);
        }
        return p1;
    }
}
