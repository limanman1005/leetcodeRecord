package offer;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: Offer047
 * Description:
 * date: 1/5/2022 下午5:06
 *
 * @author liyh
 */
public class Offer047 {
}

/**
 * 此题比较的简单，但是我还是记录一下思路
 */
class SolutionOffer047And814{

    /**
     * 删除树其实就是将指针置null即可。
     * 通过后续遍历得到子树的信息，判断下该不该剪掉即可。
     * 分开写是为了区分特殊用例的判断和递归的边界判断。
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null|| (root.val == 0 && root.left == null && root.right == null)){
            return null;
        }
        return trimTree(root);
    }

    private TreeNode trimTree(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = trimTree(root.left);
        root.right = trimTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}
