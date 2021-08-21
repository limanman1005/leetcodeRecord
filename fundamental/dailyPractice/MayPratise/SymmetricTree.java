package dailyPractice.MayPratise;

import mySummary.Dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: SymmetricTree
 * Description: 判断一个树是不是对称树
 * date: 2020/6/2 18:34
 * 本质还是树的遍历。一种方法就是找到一个序列化方法，得到结果比较一下。
 * 另一种就是使用递归直接模拟遍历过程，有不一样的直接返回false
 * @author liyh
 */
public class SymmetricTree {
}
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    /**
     * 此为非递归方法
     * @param root1
     * @param root2
     * @return
     */
    public boolean helper(TreeNode root1, TreeNode root2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    /**
     * 这个方法是非递归的方法
     * @param root1
     * @param root2
     * @return
     */
    public boolean helper2(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return helper(root1.left, root2.right) && helper(root1.right, root2.left);
        }
        else{
            return false;
        }
    }
}
