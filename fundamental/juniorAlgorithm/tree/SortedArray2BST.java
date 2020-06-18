package juniorAlgorithm.tree;

import Dfs.TreeNode;

/**
 * ClassName: SortedArray2BST
 * Description: 给一个有序的数组转换成二叉搜索树
 * date: 2020/6/18 19:53
 *
 * @author liyh
 */
public class SortedArray2BST {
}
class Solution108 {

    /**
     * 典型的递归解法使用
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}

