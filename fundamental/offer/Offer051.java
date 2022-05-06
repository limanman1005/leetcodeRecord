package offer;

import mySummary.Dfs.TreeNode;

import java.util.TreeMap;

/**
 * ClassName: Offer051
 * Description:
 * 这道题收获还是蛮大的，至少知道了写递归的时候，要清楚自己想要什么，递归可以给自己什么。然后才能精进。
 * date: 3/5/2022 下午4:54
 *
 * @author liyh
 */
public class Offer051 {

    public static void main(String[] args) {
        SolutionOffer051And124 solutionOffer051And124 = new SolutionOffer051And124();
        TreeNode root = solutionOffer051And124.getATestTree();
        int ans = solutionOffer051And124.maxPathSum2(root);
        System.out.println(ans);
//        TreeNode treeNode = new TreeNode(-3);
//        int ans = solutionOffer051And124.maxPathSum(treeNode);
//        System.out.println("ans = " + ans);
    }
}
class SolutionOffer051And124{
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum){
        if(root == null){
            return 0;
        }
        //这样定义了一个数组是为了可以在递归的下一层可以改变这个值。
        //否则的话，这样的值传递是无法返回上一层的
        //此题相当于对每一层都传递了一个可以改变的最小值给下一层，然后拿到这个值进行比较
        //这是一个很巧妙的一个思路。
        int[] maxLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, maxLeft));
        int[] maxRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, maxRight));
        maxSum[0] = Math.max(maxLeft[0], maxRight[0]);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum2(TreeNode root){
        dfs(root);
        return ans;
    }

    /**
     * 终于过了，一个边界调一天，还是有点难受的。
     * 但是收获也是有的，至少知道了自己想要什么，然后递归可以给自己什么。
     * @param root
     * @return
     */
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //每个节点的四种情况，选择左子树的值，选择右子树的值，都选和都不选。
        ans = Math.max(ans, root.val + left);
        ans = Math.max(ans, root.val + right);
        ans = Math.max(ans, root.val);
        ans = Math.max(ans, root.val + left + right);
        //最后返回的值是单独一个根节点和加上左或者右的最大值。
        return Math.max(root.val, root.val + Math.max(left, right));
    }

    public TreeNode getATestTree(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-6);
        TreeNode node4 = new TreeNode(-6);
        TreeNode node5 = new TreeNode(-6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        return node1;
    }




}
