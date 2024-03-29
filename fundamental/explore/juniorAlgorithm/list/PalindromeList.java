package explore.juniorAlgorithm.list;

import explore.recursion.ListNode;

import java.util.Scanner;

/**
 * ClassName: PalindromeList
 * Description: 给定一个链表判断下是不是里面的内容是不是回文的
 * date: 2020/6/5 16:55
 *
 * @author liyh
 */
public class PalindromeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String s1 = scanner.nextLine();
        System.out.println(s1);
    }
}

class Solution234 {
    /**
     * 这个是非递归解法
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        //找到中间节点并反转
        ListNode halfNode = findMiddleOfList(head);
        ListNode reverseHalfListHead = reverseList(halfNode.next);
        ListNode p1 = head;
        ListNode p2 = reverseHalfListHead;
        boolean ans = true;
        //然后和反转过后的节点进行比较
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
     * 这个是递归解法， 使用一个全局变量来比较。
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

    private ListNode frontHead;
    public boolean isPalindrome3(ListNode head){
        if(head == null){
            return true;
        }
        frontHead = head;
        boolean ans = helper(head);
        return ans;
    }
    private boolean helper(ListNode head){
        //这里要注意到某个地方才能返回。
        if(head == null){
            return true;
        }
        boolean preAns = helper(head.next);
        if(!preAns){
            return false;
        }
        if(head.val == frontHead.val){
            frontHead = frontHead.next;
            return true;
        }
        else{
            return false;
        }
    }
}
