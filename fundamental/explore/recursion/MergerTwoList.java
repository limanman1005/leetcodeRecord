package explore.recursion;

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
     * 首先要明白这个问题是可以被划分成为更小的子问题的，比如一个节点，一个节点的削下去。最后到达某个终点，即基本条件。
     * 然后就是如何把问题分解成更小的子问题了。这个是每个递归题都不一样的地方。
     * 还有就是最底层需不需要给最上层返回什么东西作为上一层的某一步。如果都成了就可以完整的写出递归程序了。
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


    /**
     * 这个循环解法的技巧也记一下
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
            //与后面的断开连接。避免产生问题
            tail.next = null;
        }
        return dummyHead.next;
    }
}
