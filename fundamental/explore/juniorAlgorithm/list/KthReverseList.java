package explore.juniorAlgorithm.list;

import explore.recursion.ListNode;


/**
 * ClassName: KthReverseList
 * Description: k个一组反转链表，这一题的的思路值得好好学一学
 * date: 2020/5/16 9:29
 *
 * @author liyh
 */
public class KthReverseList {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode aTestList = solution25.getATestList();
        ListNode listNode = solution25.reverseKGroup(aTestList, 2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution25{
    /**
     * 这个是纯递归解法。（用循环的思路理解貌似更好一点，系统栈记录下现场，到哪一层调用那一层的东西）
     * 首先做一些操作，找一下相聚为k的两个节点。
     * 找到之后调用反转链表方法根据给定的两个指针反转链表，并返回然转后的头节点。
     * 然后这个返回的头节点的指针域递归调用本方法，去反转后面的节点。
     * 最后返回反转后的头节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null){
            return null;
        }
        ListNode a, b;
        a = b = head;
        //这个循环过后b指向的是下一组的头节点
        for(int i = 0; i < k; ++i){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode reverseHead = reverse(a, b);
        //逆转过后a已经变成了当前组的尾节点。接上下一组的头节点
        a.next = reverseKGroup(b, k);
        return reverseHead;
    }

    /**
     * 这个是反转[a, b)之间的链表，并返回表头。
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        if(a.next == b || a.next == null){
            return a;
        }
        ListNode curHead = reverse(a.next, b);
        a.next.next = a;
        a.next = null;
        return curHead;
    }

    /**
     * 非递归解法。直观的模拟，使用头节点和保存第一个头节点的hair来应对各种边界情况。
     * 然后每K个一组反转连接
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        //加一个头节点避免特判（因为想要每一个需要处理的节点前面都有一个节点，头节点没有所以加一个）
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        //加一个hair保存最后的答案,pre后面要复用，有可能不是答案了。
        ListNode hair = pre;
        //初始化第一组的尾节点。
        ListNode tail = pre;
        //定义一个start和next待用
        //next用于保存下一组节点的头一个节点，避免丢失后面的节点
        //start用于保存当前一组节点的头节点
        ListNode start, next;
        while(tail.next != null){
            //找到这一组的尾节点
            for(int i = 0; i < k && tail != null; ++i){
                tail = tail.next;
            }
            //如果半道为空，那么说明这一组不够k个不用反转，直接跳出
            if(tail == null){
                break;
            }
            //暂存下一组链表第一个节点
            next = tail.next;
            //获得本组节点的开始位置
            start = pre.next;
            //将这一组和主链表断开，也方便之后逆置有个终止条件。
            tail.next = null;
            //pre是上一组的链表组的尾节点接上这一组的逆转过后的头节点
            pre.next = reverse(start);
            //这时候start变成了这一组节点的尾节点，这一组的尾部接上下一个节点的头部
            start.next = next;
            //下一组的头节点的前置节点是start，将start赋给下一组节点要重复利用的pre和start
            pre = start;
            tail = pre;
        }
        //最后返回第一组，不管逆置或者没有逆置的第一组的头节点
        return hair.next;
    }

    /**
     * 反转链表的循环写法
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
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

    public ListNode getATestList(){
        ListNode[] arr = new ListNode[6];
        for(int i = 1; i < 6; i++){
            arr[i] = new ListNode(i);
        }
        for (int i = 1; i < 5; i++) {
            arr[i].next = arr[i + 1];
        }
        return arr[1];
    }


    /**
     * 删减了一些不必要的条件
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode a, b;
        a = b = head;
        for(int i = 0; i < k; ++i){
            if(b == null){
                return head;
            }
            else{
                b = b.next;
            }
        }
        ListNode preKHead = reverseKGroup(b, k);
        ListNode reverseKHead = reverseList2(a, b);
        a.next = preKHead;
        return reverseKHead;
    }


    public ListNode reverseList2(ListNode a, ListNode b){
        if(a.next == b){
            return a;
        }
        ListNode reverseHead = reverseList2(a.next, b);
        ListNode next = a.next;
        next.next = a;
        a.next = null;
        return reverseHead;
    }
}
