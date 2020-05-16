package backTrack;

import Dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AllPathInTree
 * Description: 给一个二叉树。返回所有从根到叶子节点的路径
 * 这题典型的回溯法应用。使用一个path数组保存相应的数值信息。然后用完移除掉即可
 * date: 2020/5/11 17:37
 *
 * @author liyh
 */
public class AllPathInTree {
}

class Solution257 {
    private List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return ans;
        }
        dfs(root, new ArrayList<Integer>());
        return ans;
    }

    /**
     * 使用dfs进行遍历还有进行回溯
     * @param root
     * @param path
     */
    public void dfs(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }
        //每次的时候都把值加进path里面。
        path.add(root.val);
        //碰到叶子节点说有一条路径到底。把这个数组组装成String
        //这段代码可以放的位置挺多的。放到后序的位置貌似更好理解
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int val : path){
                sb.append(val).append("->");
            }
            int len = sb.length();
            ans.add(sb.toString().substring(0, len - 2));
            //这如果要加return。那么需要在这里加上回溯。
        }
        //前往左子树
        dfs(root.left, path);
        //前往右子树
        dfs(root.right, path);
        //使用完毕后从当前路径删除掉当前的节点的值。
        path.remove(path.size() - 1);
    }
}