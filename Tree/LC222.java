/**
 * ClassName: LC222
 * Description:
 * date: 2020/2/27 14:34
 *
 * @author liyh
 */
public class LC222 {
}
    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            //求左子树的高度
            int left = countLevel(root.left);
            //求右子树的高度
            int right = countLevel(root.right);
            //如果左右相等，则说明左子树一定是一个完整的二叉树，可以使用公式求解（1<<left -1），然后递归求解右子树。
            //如果左右不等，则说明右子树一定是一个完整的二叉树，可以使用公式求解，然后递归求接左子树。
            if(left == right){
                return countNodes(root.right) + (1 << left);
            }
            else{
                return countNodes(root.left) + (1<<right);
            }
        }
        //这个函数计算的是当前节点的左子树高度
        public int countLevel(TreeNode root){
            int level = 0;
            while(root != null){
                level ++;
                root = root.left;
            }
            return level;
        }
    }

