package juniorAlgorithm.list;

import explore.recursion.ListNode;

/**
 * ClassName: MergeTwoList
 * Description: 合并两个有序的链表
 * date: 2020/6/5 10:25
 *
 * @author liyh
 */
public class MergeTwoList {
}

class Solution21 {
    /**
     * 这个是循环解法，挺好理解的
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 合并的递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }
}
