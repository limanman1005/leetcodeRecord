package explore.middleAlgorithm.List;

import explore.recursion.ListNode;

/**
 * ClassName: OddEvenList
 * Description: 把一个链表重排，把在奇数位的放在前面
 * 偶数位的放在后面。
 * date: 2020/7/6 19:11
 *
 * @author liyh
 */
public class OddEvenList {
}
class Solution328 {
    /**
     * 这个解法还是挺厉害的。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
