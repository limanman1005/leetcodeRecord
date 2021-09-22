package explore.juniorAlgorithm.list;

import explore.recursion.ListNode;

/**
 * ClassName: LC203
 * Description: 简单的删除操作
 * date: 2021/9/20 20:54
 *
 * @author liyh
 */
public class LC203 {
}
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp, p = tmp.next;
        while(p!=null){
            if(p.val == val){
                pre.next = p.next;
                p = p.next;
            }else{
                pre = p;
                p = p.next;
            }
        }
        return tmp.next;
    }
}
