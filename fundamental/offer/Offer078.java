package offer;

import explore.juniorAlgorithm.list.ListNode;

/**
 * ClassName: Offer078
 * Description:
 * date: 6/5/2022 下午6:03
 *
 * @author liyh
 */
public class Offer078 {

    public static void main(String[] args) {

    }
}
class SolutionOffer078 {

    /**
     * 归并的思想，做的。有几个基本的算法需要练熟。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int end = lists.length - 1;
        return helper(lists, 0, end);
    }

    private ListNode helper(ListNode[] lists, int start, int end){
        if(start >= end){
            return lists[start];
        }
        int mid = (start + end + 1) >>> 1;
        ListNode l1 = helper(lists, start, mid - 1);
        ListNode l2 = helper(lists, mid, end);
        return mergeTwoList(l1, l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode pNode = dummyHead;
        while(l1 != null || l2 != null){
            int val1 = (l1 != null? l1.val: Integer.MAX_VALUE);
            int val2 = (l2 != null? l2.val: Integer.MAX_VALUE);
            if(val1 < val2){
                pNode.next = l1;
                l1 = l1.next;
            }
            else{
                pNode.next = l2;
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        return dummyHead.next;
    }
}
