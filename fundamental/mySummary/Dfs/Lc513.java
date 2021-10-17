package mySummary.Dfs;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * ClassName: Lc513
 * Description: 找到树上的最下层的最靠左的节点
 * date: 2020/4/29 18:12
 * e.m.
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出 7
 * @author liyh
 */
public class Lc513 {

    public static void main(String[] args) {
        Solution513_1 solution513_1 = new Solution513_1();
        TreeNode leftNode = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        int bottomLeftValue2 = solution513_1.findBottomLeftValue2(root);
        System.out.println(bottomLeftValue2);

    }
}

/**
 * 此题还有非递归的解法，可以做一做
 */
class Solution513_1 {
    private int maxLevel = Integer.MIN_VALUE;
    private int ans;

    /**
     * 使用递归的dfs解法
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int level){
        if(root == null){
            return ;
        }
        //这个<号用的妙。
        if(maxLevel < level){
            maxLevel = level;
            ans = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


    public int findBottomLeftValue2(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int ans = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode curNode = queue.pollFirst();
                if(i == 0){
                    ans = curNode.val;
                }
                if(curNode.left != null){
                    queue.addLast(curNode.left);
                }
                if(curNode.right != null){
                    queue.addLast(curNode.right);
                }
            }
        }
        return ans;
    }
}
