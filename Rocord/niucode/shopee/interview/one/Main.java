package niucode.shopee.interview.one;

import mySummary.Dfs.TreeNode;


/**
 * ClassName: Main
 * Description:
 * date: 2021/10/31 23:04
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2};
        TreeNode root = generateTree(arr, 0);
        System.out.println("===============================");
    }

    private static TreeNode generateTree(Integer[] arr, int i) {
        if(i >= arr.length){
            return null;
        }
        TreeNode root = new TreeNode(arr[i]);
        TreeNode left = generateTree(arr, i * 2 + 1);
        TreeNode right = generateTree(arr, i * 2 + 2);
        root.left = left;
        root.right = right;
        return root;
    }
}

