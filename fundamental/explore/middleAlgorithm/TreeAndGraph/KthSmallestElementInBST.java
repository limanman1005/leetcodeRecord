package explore.middleAlgorithm.TreeAndGraph;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;

/**
 * ClassName: KthSmallestElementInBST
 * Description:给一个二叉搜索树，找到第k个大小的数
 * date: 2020/7/14 19:57
 *
 * @author liyh
 */
public class KthSmallestElementInBST {
}
class Solution230 {
    private int ans;
    private int num;

    /**
     * 递归解法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    private void dfs(TreeNode root, int k){
        if(root == null){
            return ;
        }
        dfs(root.left, k);
        num++;
        if(num == k){
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }


    /**
     * 迭代解法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int num = 0;
        int ans = -1;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                num++;
                if(num == k){
                    ans = cur.val;
                    break;
                }
                cur = cur.right;
            }
        }
        return ans;
    }
}
