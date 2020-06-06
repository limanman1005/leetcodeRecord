package juniorAlgorithm.list;

import explore.ListNode;

/**
 * ClassName: PalindromeList
 * Description: 给定一个链表判断下是不是里面的内容是不是回文的
 * date: 2020/6/5 16:55
 *
 * @author liyh
 */
public class PalindromeList {
}

class Solution {
    /**
     * 这个是非递归解法
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode halfNode = findMiddleOfList(head);
        ListNode reverseHalfListHead = reverseList(halfNode.next);
        ListNode p1 = head;
        ListNode p2 = reverseHalfListHead;
        boolean ans = true;
        while(ans && p2 != null){
            if(p1.val != p2.val){
                ans = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        halfNode.next =  reverseList(reverseHalfListHead);
        return ans;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    private ListNode findMiddleOfList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private ListNode frontPointer;

    /**
     * 这个是递归解法
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private boolean recursivelyCheck(ListNode currentNode){
        if(currentNode != null){
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }
            if(currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}