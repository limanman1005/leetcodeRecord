/**
 * ClassName: LC437
 * Description: 给一个树，找一个路径，该路径可以从任何一个节点出发，到达任意一个节点
 * 找到从上到下所有路径的和为指定数的个数
 * date: 2020/3/3 18:06
 *
 * @author liyh
 */
public class LC437 {
}




class Solution437_1{
    //这个函数遍历每个节点当成根节点，然后调用另一个递归函数判断
    //有没有满足条件的值。
    public int pathSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        return judgePathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    //这个函数从根节点出发，判断有没有满足条件的值，用的是递归。
    private int judgePathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        sum -= root.val;
        return (sum == 0? 1: 0) + judgePathSum(root.left, sum) + judgePathSum(root.right, sum);
    }
}
//还有一种前缀和的解法。暂时略


