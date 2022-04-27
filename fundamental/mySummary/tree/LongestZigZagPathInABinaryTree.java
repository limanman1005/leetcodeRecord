package mySummary.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LongestZigZagPathInABinaryTree
 * Description:
 * date: 22/4/2022 下午3:45
 *
 * @author liyh
 */
public class LongestZigZagPathInABinaryTree {
}

class Solution1372{


    /**
     * 典型的双递归题。
     */
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, 1);
        int right = dfs(root.right, -1);
        int leafLeftRootLongest = longestZigZag(root.left);
        int leftRightRootLongest = longestZigZag(root.right);
        int maxOfRoot = Math.max(left, right);
        int maxOfLeaf = Math.max(leafLeftRootLongest, leftRightRootLongest);
        return Math.max(maxOfLeaf, maxOfRoot);
    }



    private int dfs(TreeNode root, int dir){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        if(dir == -1 && root.left != null){
            int leftDownValue = dfs(root.left, dir * -1);
            map.put(root, leftDownValue + 1);
            return leftDownValue + 1;
        }
        else if(dir == 1 && root.right != null){
            int rightDownValue = dfs(root.right, dir * -1);
            map.put(root, rightDownValue + 1);
            return rightDownValue + 1;
        }else{
            return 1;
        }
    }
}
