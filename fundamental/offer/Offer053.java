package offer;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;

/**
 * ClassName: Offer053
 * Description:
 * date: 3/5/2022 下午10:25
 *
 * @author liyh
 */
public class Offer053 {
}


class SolutionOffer053And285{

    /**
     * 事件复杂度为O(n)的解法
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        boolean findP = false;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            if(findP){
                return cur;
            }
            if(cur.val == p.val){
                findP = true;
            }
            cur = cur.right;
        }
        return null;
    }

    /**
     * 时间复杂度是O(Logn)的算法。有点意外，注意二叉树还有这种做法和写法
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        //直接向每一层的下方走就是了，直到走到为null的叶子节点
        while(cur != null){
            if(cur.val > p.val){
                result = cur;
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return result;
    }




}
