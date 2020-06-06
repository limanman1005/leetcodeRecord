import java.util.List;

/**
 * ClassName: No206
 * Description:反转链表
 * date: 2020/3/3 17:26
 *
 * @author liyh
 */
public class LC206 {
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        ListNode aList = solution_1.getAList();
        ListNode listNode = solution_1.reverseList2(aList);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}


//递归解法
class Solution_1 {
    public ListNode getAList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
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

    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode reverseHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return  reverseHead;
    }

    /**
     * 反转链表的迭代版本
     * @param node
     * @return
     */
    public ListNode reverseNode(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
