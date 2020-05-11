package Dfs;

/**
 * ClassName: LowestCommonAncestorInBST
 * Description:
 * date: 2020/5/11 16:42
 *
 * @author liyh
 */
public class LowestCommonAncestorInBST {
}

class Solution235 {
    /**
     * 这个是递归解法。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判断下值，如果都在左边就去左边找
        if(root.val> q.val  && root.val > p.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        //在右边就去右边找
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        //剩下的就是在两边直接返回root。包括了在两边和其中一个是父节点的情况
        return root;
    }

    /**
     * 这个是迭代解法。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        //利用一个循环根据值得大小遍历这个数
        while(node != null){
            int rootVal = node.val;
            //判断在右边
            if(pVal > rootVal && qVal > rootVal){
                node = node.right;
            }
            //判定在左边
            else if(pVal < rootVal && qVal < rootVal){
                node = node.left;
            }
            //剩下得情况包括在两边或者其中一个是父节点说明找到了直接返回。
            else{
                return node;
            }
        }
        //没有返回null。
        return null;
    }
}