package inAndOut.test2;

import explore.recursion.ListNode;

/**
 * ClassName: Main
 * Description:
 * date: 2020/9/12 20:42
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        ListNode node1 = instance.getInstance();
        ListNode node2 = instance.getInstance();
        System.out.println(node1 == node2);
    }
}
enum  SingletonEnum{
    INSTANCE;
    private ListNode node;
    SingletonEnum(){
        ListNode listNode = new ListNode(3);
        this.node = listNode;
    }
    public ListNode getInstance(){
        return node;
    }
}
