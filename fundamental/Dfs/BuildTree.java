package Dfs;

import java.util.HashMap;

/**
 * ClassName: BuildTree
 * Description:
 * date: 2020/5/2 20:42
 *
 * @author liyh
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] arr1 = {9,3,15,20,7};
        int[] arr2 = {9, 15, 7, 20, 3};
        new Solution106().buildTree(arr1, arr2);
        System.out.println("==============================");
        new Solution106().buildTree2(arr1, arr2);
    }
}

class Solution106{
    private int[] inorder;
    private int[] postorder;
    private HashMap<Integer, Integer> val2Index = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int start = 0;
        int end = inorder.length - 1;
        int root = end;
        //把中序遍历的值和序号对应上关系
        for(int i = 0; i <= end; ++i){
            val2Index.put(inorder[i], i);
        }
        return helper(root, start, end);
    }

    public TreeNode helper(int root, int start, int end){
        if(start > end){
            return null;
        }
        //这里直接得到根节点在中序序里的位置
        int rootIndex = val2Index.get(postorder[root]);
        TreeNode node = new TreeNode(postorder[root]);
        System.out.println(root);
        //根据数学关系在中序序列中的end - rootIndex + 1为右子树的节点数。在被root减去就是左子树的序列的最后一个
        //这样就找到了左子树的根的下标。不断的划分就成了。
        node.left = helper(root - 1 - end + rootIndex, start, rootIndex - 1);
        node.right = helper(root - 1, rootIndex + 1, end);
        return node;
    }


    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int start = 0;
        int end = inorder.length -1;
        int root = end;
        TreeNode ans = null;
        if(start > end){
            return ans;
        }
        ans = helper(root, start, end, inorder, postorder);
        return ans;
    }
    public TreeNode helper(int root, int start, int end, int[] inorder, int[] postorder){
        if(start > end){
            return null;
        }
        int i = start;
        while(i < end && inorder[i] != postorder[root]){
            i++;
        }
        System.out.println(root);
        TreeNode node = new TreeNode(postorder[root]);
        node.left = helper(root - 1 - end + i, start, i - 1, inorder, postorder);
        node.right = helper(root - 1, i + 1, end, inorder, postorder);
        return node;
    }

    //加上这个太妙了，不用计算左右子树序列的根节点在哪了
    private int post_index;
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int len = inorder.length;
        if(len == 0){
            return null;
        }
        post_index = len - 1;
        int index = 0;
        for(int val : inorder){
            val2Index.put(val, index++);
        }
        return helper(0, len - 1);
    }
    public TreeNode helper(int l, int r){
        if(l > r){
            return null;
        }
        int val = postorder[post_index];
        TreeNode node = new TreeNode(val);
        //因为递归顺序的原因post-1肯定是根节点
        post_index--;
        int rootIndex = val2Index.get(val);
        //先右后左的顺序不能变。
        node.right = helper(rootIndex + 1, r);
        node.left = helper(l, rootIndex - 1);
        return node;
    }

}
