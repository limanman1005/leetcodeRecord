package juniorAlgorithm.list;

import explore.ListNode;

/**
 * ClassName: MergeTwoList
 * Description:
 * date: 2020/6/5 10:25
 *
 * @author liyh
 */
public class MergeTwoList {
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while(l1 != null || l2 != null){
            int x = (l1 != null? l1.val: Integer.MAX_VALUE);
            int y = (l2 != null? l2.val: Integer.MAX_VALUE);
            if(x  < y){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        return dummyHead.next;
    }
}
