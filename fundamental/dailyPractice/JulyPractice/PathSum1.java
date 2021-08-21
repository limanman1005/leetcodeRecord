package dailyPractice.JulyPractice;

import mySummary.Dfs.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: PathSum1
 * Description: 给一个树，判断下从树顶到某个叶子节点的和某个特定的值是否相等
 * date: 2020/7/7 9:45
 * 此题有一个扩展就是任意节点到任意节点
 * @author liyh
 */
public class PathSum1 {
}
class Solution112 {
    /**
     * BFS解法，使用两个队列，这两个队列一个使用保存节点信息，一个用来保存顶点到当前节点的和。
     * 在每次取出节点的时候，判断下是不是叶子节点且和等不等于给定值。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while(!queNode.isEmpty()){
            TreeNode cur = queNode.poll();
            int temp = queVal.poll();
            if(cur.left == null && cur.right == null){
                if(temp  == sum){
                    return true;
                }
                else{
                    continue;
                }
            }
            if(cur.left != null){
                queNode.offer(cur.left);
                queVal.offer(temp + cur.left.val);
            }
            if(cur.right != null){
                queNode.offer(cur.right);
                queVal.offer(temp + cur.right.val);
            }
        }
        return false;
    }

    /**
     * 递归解法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }
}
