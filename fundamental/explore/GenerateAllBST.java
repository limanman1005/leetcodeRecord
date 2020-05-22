package explore;

import Dfs.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: GenerateAllBST
 * Description: 给一个参数n，生成所有节点1。。。n组成的二叉搜索树。
 * date: 2020/5/16 16:55
 *
 * @author liyh
 */
public class GenerateAllBST {
    public static void main(String[] args) {
//        new Solution95().generateTrees(1);
//        List<List<Integer>> ans = new ArrayList<>(16);
//        int[] arr = new int[2];
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
        int[] ints = new int[]{1, 2};
        System.out.println(ints.toString());

    }
}
class Solution95{
    /**
     * 这个算法的确有点难理解。
     * 从循环和递归的角度来说都难理解。
     * 使用状态树应该好一点吧
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        for(int i = start; i <= end; ++i){
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);
            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = left;
                    curTree.right = right;
                    ans.add(curTree);
                }
            }
        }
        return ans;
    }
}

