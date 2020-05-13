package explore;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SwapNodeInPairs
 * Description: 给一个链表，两两反转
 * date: 2020/5/12 14:12
 *
 * @author liyh
 */
public class SwapNodeInPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        new Solution2().swapPairs(node1);
        List<List<Integer>> ans = new ArrayList<>();
    }
}
class Solution2 {
    /**
     * 两两反转节点的递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
