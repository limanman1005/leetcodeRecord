package explore.juniorAlgorithm.list;

import explore.recursion.ListNode;

/**
 * ClassName: CycleList2
 * Description: 给一个链表，判断下是否有环，如果有返回环的入口
 * 方法和判断是否存在是一样的，使用hash表或者快慢指针
 * hash表比较的简单，这里就不赘述了。
 * date: 2020/6/18 16:04
 *
 * @author liyh
 */
public class CycleList2 {
}
class Solution142 {
    /**
     * 这个就是快慢指针法
     * 简单证明一些这个做法正确性。
     * 首先第一次相遇时慢指针走的节点数为 s
     * 快指针走的节点数为 f
     * 可得 f = 2s.
     * 又因为相遇的时候快指针走了 f = s + n * b.
     * 得出此时f = 2 * n * b, s = n * b.
     * 又因为 a + n * b是每次路过入环点的步数。
     * 所以此时如果 slow再走a步即可到达入环点。
     * 由于不知道a为多少，这时使用双指针法控制快指针从head走向入环点同时慢指针以相同的速度走，那么就会在入环点相遇。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 补充一个写法
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode solw = head;
        boolean isCycle = false;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            solw = solw.next;
            if(fast == solw){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            fast = head;
            while(fast != solw){
                fast = fast.next;
                solw = solw.next;
            }
            return fast;
        }
        return null;
    }
}
