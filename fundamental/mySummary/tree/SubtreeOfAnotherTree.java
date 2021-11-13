package mySummary.tree;

/**
 * ClassName: LC572
 * Description: 给两个树s, t 判定t是否是s的子树。
 * 这个题和437路径总和其中一个解法好类似
 * date: 2020/3/3 17:38
 * @author liyh
 */
public class SubtreeOfAnotherTree {
}
class Solution572{
    public boolean subTree(TreeNode s, TreeNode t){
        //出口s为空相当于判断完了
        if(s == null){
            return false;
        }
        //sameTree这个函数判断以当前这个节点为根节点和t比较。比较也使用了递归函数sametree比较。
        //然后递归比较当前节点的左子树和右子树。
        return sameTree(s, t) || subTree(s.left, t) || subTree(s.right, t);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return s.val == t.val || sameTree(s.left, t) || sameTree(s.right, t);
    }
}
