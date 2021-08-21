package explore.juniorAlgorithm.tree;

import mySummary.Dfs.TreeNode;
import explore.recursion.ListNode;

/**
 * ClassName: SortedList2BST
 * Description: 这里补一个链表转成二叉搜索树
 * 还有一个甜姨的快慢指针法。
 * date: 2020/6/18 19:55
 *
 * @author liyh
 */
public class SortedList2BST {
}
class Solution109 {
    private ListNode cur;

    /**
     * 这个也是使用的递归
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        int len = findLength(head);
        cur = head;
        return convertList2BST(0, len - 1);
    }
    public int findLength(ListNode head){
        int ans = 0;
        while(head != null){
            ans++;
            head = head.next;
        }
        return ans;
    }
    public TreeNode convertList2BST(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r)/2;
        TreeNode left = convertList2BST(l, mid - 1);
        TreeNode node = new TreeNode(cur.val);
        node.left = left;
        //这段代码不好理解，使用快慢指针找到中间节点也行
        cur = cur.next;
        node.right = convertList2BST(mid + 1, r);
        return node;
    }
}


