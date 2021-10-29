package mySummary.listAndString;


import explore.recursion.ListNode;

/**
 * ClassName: RemoveDuplicatesFromSortedList
 * Description:
 * date: 2021/10/29 18:28
 *
 * @author liyh
 */
public class RemoveDuplicatesFromSortedList {
}

class Solution82{

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
                cur = cur.next;
                continue;
            }
            else{
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
