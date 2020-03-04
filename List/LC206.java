
/**
 * ClassName: No206
 * Description:反转链表
 * date: 2020/3/3 17:26
 *
 * @author liyh
 */
public class LC206 {
}


//递归解法
class Solution_1 {
    //这个方法返回List的d头节点
    public ListNode reverseList(ListNode head) {
        //递归终止条件，碰到只有一个节点或者只有一个节点就返回，现在的头节点
        if(head == null || head.next == null){
            return head;
        }
        //这个得到反转链表的头节点
        ListNode p = reverseList(head.next);
        //把目前节点的下一个节点的指针指向自己即反转
        head.next.next = head;
        //讲当前节点的下个指针域置零。
        head.next = null;
        //返回反转好的头节点
        return p;
    }
}
