package explore;

/**
 * ClassName: MergerTwoList
 * Description: 给两个升序链表，把他们合并到一块
 * date: 2020/5/16 16:19
 *
 * @author liyh
 */
public class MergerTwoList {
}
class Solution21 {
    /**
     * 此为递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
