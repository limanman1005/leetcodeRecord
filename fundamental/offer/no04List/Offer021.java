package offer.no04List;

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


    //这种题，感觉某些点需要记住。才能一次AC
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pNode = dummyHead;
        ListNode pre = dummyHead;
        //这里就是走了n步
        for(int i = 0; i < n; ++i){
            pNode = pNode.next;
        }
        //走到最后一个节点而不是null
        while(pNode.next != null){
            pNode = pNode.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
