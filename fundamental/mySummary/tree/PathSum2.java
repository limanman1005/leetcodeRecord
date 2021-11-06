package mySummary.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * ClassName: PathSum2
 * Description:
 * date: 2021/11/2 15:36
 *
 * @author liyh
 */
public class PathSum2 {

    public static void main(String[] args) {
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Solution113 solution113 = new Solution113();
        TreeNode root = generateTree(tree);
        List<List<Integer>> lists = solution113.pathSum(root, 22);
        lists.forEach((o1) -> System.out.println(o1));
        System.out.println("11111111");

    }

    private static TreeNode generateTree(Integer[] arr) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.addLast(root);
        int idx = 1;
        while (idx < arr.length){
            TreeNode curNode = queue.pollFirst();
            Integer leftVal = arr[idx];
            Integer rightVal = arr[idx + 1];
            if(leftVal != null){
                TreeNode left = new TreeNode(leftVal);
                curNode.left = left;
                queue.addLast(left);
            }
            if(rightVal != null){
                TreeNode right = new TreeNode(rightVal);
                curNode.right = right;
                queue.addLast(right);
            }
            idx += 2;
        }
        return root;
    }

    private static TreeNode generateTree2(Integer[] arr) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.addLast(root);
        int idx = 1;
        while (idx < arr.length){
            TreeNode curNode = queue.pollFirst();
            Integer leftVal = arr[idx];
            Integer rightVal = arr[idx + 1];
            if(leftVal != null){
                TreeNode left = new TreeNode(leftVal);
                curNode.left = left;
                queue.addLast(left);
            }
            if(rightVal != null){
                TreeNode right = new TreeNode(rightVal);
                curNode.right = right;
                queue.addLast(right);
            }
            idx += 2;
        }
        return root;
    }
}

class Solution113{

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans){
        path.add(root.val);
        if(targetSum == root.val && root.left == null && root.right == null){
            ans.add(new LinkedList<>(path));
        }
        if(root.left != null){
            dfs(root.left, targetSum - root.val, path, ans);
        }
        if(root.right != null){
            dfs(root.right, targetSum - root.val, path, ans);
        }
        path.remove(path.size() - 1);
    }
}
