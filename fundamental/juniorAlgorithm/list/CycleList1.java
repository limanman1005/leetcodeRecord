package juniorAlgorithm.list;

import explore.ListNode;

/**
 * ClassName: CycleList
 * Description: 判断下链表是否有环
 * date: 2020/6/18 16:01
 * 两种思路，一个是hash表i另一个就是快慢指针
 * @author liyh
 */
public class CycleList1 {
}
class Solution141 {
    /**
     * 使用快慢指针。看下快指针是否会追上慢指针。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow , fast;
        slow = fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
