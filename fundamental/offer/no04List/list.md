### 剑指Offer书的List问题总结

#### 必须要掌握的两个点：一、就是将链表分为两半。二、就是反转链表。

这个两点是很多题的基础，必须要会的。

还有一个常考的点就是使用链表或者字符串实现大数加法的常用写法值得牢记。

剩下的都是一些变形，题目不难理解，最难的就是考虑到各种

```java
//将一个链表分为两半
    private static ListNode splitListInHalf(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //注意这里是返回的是slow.next。且这里前半个链表比较长
        return slow.next;

    }
```

```java
//反转链表的循环写法，非常基础
private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
```

