package offer.no04List;

import explore.juniorAlgorithm.list.ListNode;

/**
 * ClassName: Offer023
 * Description:
 * date: 9/5/2022 下午6:35
 *
 * @author liyh
 */
public class Offer023 {
}
class SolutionOffer023{


    /**
     * 有细节的，最后需要走到空节点的否则不相交的情况下可能无限循环
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            if(p1 != null){
                p1 = p1.next;
            }
            else{
                p1 = headB;
            }
            if(p2 != null){
                p2 = p2.next;
            }
            else{
                p2 = headA;
            }
        }
        return p1;
    }
}
