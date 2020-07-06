package middleAlgorithm.List;

import explore.ListNode;

/**
 * ClassName: AddInList
 * Description: 给一个list，里面是数字，对里面的数字进行加减法，一个节点表示一个数字。
 * date: 2020/7/6 19:07
 * e.g.
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 这个是倒序的，还有一个不是倒序的
 * @author liyh
 */
public class AddInList {
}
class Solution02 {
    /**
     * 这种题只能记住怎么写了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, cur = head;
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = (p1 != null? p1.val: 0);
            int y = (p2 != null? p2.val: 0);
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
            if(carry != 0){
                cur.next = new ListNode(carry);
            }
        }
        return head.next;
    }
}