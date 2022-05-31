package explore.microsoft.mySupplement;

import explore.recursion.ListNode;

/**
 * ClassName: MergeNLists
 * Description:
 * date: 2020/7/29 17:14
 *
 * @author liyh
 */
public class MergeNLists {
    public static void main(String[] args) {
    }
}
class Solution23 {




    /**
     * 合并K个链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 这里使用分支法进行优化
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = (left + right) >>> 1;
        ListNode l1 = merge(lists,left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge2Lists(l1, l2);
    }
    private ListNode merge2Lists(ListNode first, ListNode second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        if(first.val < second.val){
            first.next = merge2Lists(first.next, second);
            return first;
        }
        else{
            second.next = merge2Lists(first, second.next);
            return second;
        }
    }
}
