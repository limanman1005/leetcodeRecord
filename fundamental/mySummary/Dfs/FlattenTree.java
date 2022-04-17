package mySummary.Dfs;

/**
 * ClassName: FlattenTree
 * Description: 此题把一个二叉树展开成为一个链表。链表顺序是按照先序遍历来的
 * date: 2020/4/30 15:49
 * 还有非递归写法，暂时放一放
 * @author liyh
 */
public class FlattenTree {
}



class Solution114 {
    /**
     * 这个是标准的后序遍历做法，没有使用一个全局的指针。
     * 就是将节点的右节点挂到左节点的最右边节点上，然后将左节点挂到右节点上。
     * @param root root
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left != null){
            //这个pre指向根节点的左子树的最右边节点
            TreeNode pre = root.left;
            while(pre.right != null){
                pre = pre.right;
            }
            //然后把根节点的右边子树挂到pre的右子树上
            pre.right = root.right;
            //root的left节点挂到root的右节点上
            root.right = root.left;
            //最后将root的左节点置为null。
            root.left = null;
        }
    }

    /**
     * 有返回值的递归很难懂的。
     * @param root
     */
    public void flatten2(TreeNode root) {
        flat(root);
    }



    private TreeNode flat(TreeNode root) {
        if(root == null) {
            return null;
        }
        //先将当前节点的右指针（右子树）保存下来
        TreeNode oldRight = root.right;
        //先把当前节点的左子树挂到当前节点的右子树上
        root.right = flat(root.left);
        //将当前子树的左指针置空
        root.left = null;

        //找到当前节点的最右节点
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        //root节点的右子树展开挂到当前节点的右边
        cur.right = flat(oldRight);
        return root;
    }


    private TreeNode pre = null;

    /**
     * 这个方法使用一个全局的指针。
     * 然后为了避免覆盖右指针，使用RLD的方式遍历。
     * @param root
     */
    public void flatten3(TreeNode root) {
        if(root == null){
            return ;
        }
        flatten3(root.right);
        flatten3(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    /**
     * 非递归解法，妙啊
     * @param root
     */
    public void flatten4(TreeNode root) {
        while(root != null){
            //从根节点开始，判断下有没有左节点，如果没有就不需要操作。直接去展开右节点
            if(root.left != null){
                //如果有找到左子树的最右节点
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                //然后将根节点的右子树挂到左子树的最右节点上
                //然后把左子树挂到根节点的右指针上。最后左节点置空。
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            //向右走，遍历整个树。
            root = root.right;
        }
    }
}
