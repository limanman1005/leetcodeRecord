import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: LC144
 * Description:二叉树的前序遍历（非递归）
 * date: 2020/2/27 23:02
 *
 * @author liyh
 */
public class LC144 {
}


class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curNode != null || !stack.isEmpty()){
            while(curNode != null){
                ans.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()){
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
        return ans;
    }
}