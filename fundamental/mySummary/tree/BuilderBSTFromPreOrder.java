package mySummary.tree;

/**
 * ClassName: BuilderBSTFromPreOrder
 * Description:
 * date: 23/4/2022 上午11:11
 *
 * @author liyh
 */
public class BuilderBSTFromPreOrder {
    public static void main(String[] args) {
        Solution1008 solution1008 = new Solution1008();
        int[] arr = {8, 5, 1, 7, 10, 12};
        TreeNode treeNode = solution1008.bstFromPreorder(arr);

    }
}

class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return buildBSTFromPreorder(preorder, 0, preorder.length - 1);
    }

    /**
     * 此题的边界情况没有考虑完全，未过全部用例
     * @param preorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildBSTFromPreorder(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int rightIdx = right;
        for(int i = right; i > left; --i){
            if(preorder[i] > preorder[left]){
                rightIdx = i;
            }
        }
        root.left = buildBSTFromPreorder(preorder, left + 1, rightIdx - 1);
        root.right = buildBSTFromPreorder(preorder, rightIdx, right);
        return root;
    }
}
