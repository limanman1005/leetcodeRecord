package explore.middleAlgorithm.TreeAndGraph;

import mySummary.Dfs.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: BuildTreeInPreAndInOrder
 * Description: 给前序和中序遍历建树
 * date: 2020/7/7 10:34
 * 此题还有迭代解法
 * @author liyh
 */
public class BuildTreeInPreAndInOrder {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = solution105.buildTree(pre, in);
        Solution105.rootIndex = 0;
        solution105.buildTree2(pre, in);

    }
}

class Solution105 {
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> inVal2Index = new HashMap<>();
    /**
     * 使用了这个是真的秀，直接利用了递归的顺序，精准找到当前层次的根节点在先序中的下标，不用在计算一个root在后或者前序里面的坐标传过去
     * 当然这时候要注意递归键左右子树的顺序。
     */
    public static int rootIndex;



    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }
        return helper2(0, inorder.length - 1);
    }
    private TreeNode helper2(int start, int end){
        if(start > end){
            return null;
        }
        System.out.println(preorder[rootIndex]);
        TreeNode curRoot = new TreeNode(preorder[rootIndex]);
        int rootIndexInInorder = map.get(preorder[rootIndex]);
        rootIndex++;
        curRoot.left = helper2(start, rootIndexInInorder - 1);
        curRoot.right = helper2(rootIndexInInorder + 1, end);
        return curRoot;
    }

    /**
     * 递归解法
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int len = preorder.length;
        //这个是为了方便的划分数组，找到当根节点在inorder中的位置，便于递归。
        //避免每次都需要遍历找到当前root在中序遍历中的位置。
        for (int i = 0; i < len; ++i) {
            inVal2Index.put(inorder[i], i);
        }
        return helper(0, len - 1);
    }

    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[rootIndex++];
        System.out.println(val);
        TreeNode root = new TreeNode(val);
        int rootValIndexInInorder = inVal2Index.get(val);
        root.left = helper(start, rootValIndexInInorder - 1);
        root.right = helper(rootValIndexInInorder + 1, end);
        return root;
    }


    /**
     * 迭代解法，使用一个栈。记录信息。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            //把根节点的所有左节点都全部的压入栈中
            //这个条件是真说明，这个目前的节点全是左节点。
            if (node.val != inorder[inorderIndex]){
                //这时候直接挂载到当前根节点的左边
                node.left = new TreeNode(preorderVal);
                //压栈存起来，以便可以以后找到右节点挂上去
                stack.push(node.left);
            }
            //这个说明目前遇到的是右节点
            else {
                //根据栈中的信息和前序和后序的性质，找到当前节点是栈中保存的哪一个节点的右节点。
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                //把当前的右节点赋给当前节点
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}

