import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: LC94
 * Description: 二叉树的中序遍历
 * date: 2020/2/27 21:59
 *
 * @author liyh
 */
public class LC94 {
}

//这个非递归算法有的还是直接记住化的事件
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //使用自己的栈来代替系统栈，暂存一些信息。
        Stack<TreeNode> stack = new Stack<>();
        //另定义一个引用，使用这个东西追踪树
        TreeNode curNode = root;
        //循环终止条件就是树遍历完成了
        //什么时候树遍历完了？
        //就是当前指针走完了树的结构
        //就是当前指针并且栈为空则说明树的节点都已经在应该访问的时机访问完了。
        //在应该访问的时机访问完了
        //在应该访问的时机访问完了
        while(curNode != null  || !stack.isEmpty()){
            //要先访问左节点的数据，如果有左节点的数据就压栈
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }
            //这时候从栈中取出一个数字来，代表此这个数字就是指针第二次访问它的时候
            if(!stack.isEmpty()){
                curNode = stack.pop();
                ans.add(curNode.val);
                //记得转向右子树
                curNode = curNode.right;
            }
        }
        return ans;
    }
}
