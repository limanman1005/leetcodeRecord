package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;

/**
 * ClassName: Offer054
 * Description:
 * date: 3/5/2022 下午11:08
 *
 * @author liyh
 */
public class Offer054 {
}
class Solution054And538{

    /**
     *  反向的中序迭代遍历轻松可解。有时间可以再试试递归的
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int sum = 0;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.right;
            }
            cur = stack.pollLast();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
