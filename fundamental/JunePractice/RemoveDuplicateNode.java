package JunePractice;

import explore.recursion.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: RemoveDuplicateNode
 * Description: 给一个未排序的链表，里面的节点有重复的值。给节点去重
 * date: 2020/6/26 16:37
 *
 * @author liyh
 */
public class RemoveDuplicateNode {
}

class Solution02_01 {
    /**
     * 使用set的方法
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pos = head;
        while(pos.next != null){
            ListNode cur = pos.next;
            if(set.add(cur.val)){
                pos = pos.next;
            }
            else{
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    /**
     * 使用set的递归写法
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        return helper(head, new HashSet<>());
    }

    private ListNode helper(ListNode head, Set<Integer> set){
        if(head == null){
            return null;
        }
        if(set.contains(head.val)){
            return helper(head.next, set);
        }
        set.add(head.val);
        head.next = helper(head.next, set);
        return head;
    }


    /**
     * 这个不使用额外空间的写法，算法的时间复杂度上升
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes3(ListNode head) {
        ListNode first = head;
        if(first == null){
            return head;
        }
        while(first != null){
            ListNode second = first;
            //这里必须要写second.next.否则会出现空指针异常
            while(second.next != null){
                if(second.next.val == first.val){
                    //这里next要提前检查，否则会出空指针异常。
                    second.next = second.next.next;
                }
                else{
                    second = second.next;
                }
            }
            first = first.next;
        }
        return head;
    }
}
