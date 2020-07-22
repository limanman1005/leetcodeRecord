package explore.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SwapNodeInPairs
 * Description: 给一个链表，两两反转，循环写法暂空
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
        new Solution24().swapPairs(node1);
        List<List<Integer>> ans = new ArrayList<>();
    }
}
class Solution24 {
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

    /**
     * 迭代解法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        //使用哑节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(head != null && head.next != null){
            //找到要交换的两个节点
            ListNode first = head;
            ListNode second = head.next;
            //开始交换，pre连上第二个节点
            pre.next = second;
            //第一个节点连上后面未交换的节点
            first.next = second.next;
            //second连上第一个节点
            second.next = first;
            //交换完成后first变成了下一个pre
            //要交换的head是first.next
            pre = first;
            head = first.next;
        }
        return dummyHead.next;
    }
}
