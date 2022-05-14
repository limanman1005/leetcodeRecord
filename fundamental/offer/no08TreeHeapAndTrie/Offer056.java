package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * ClassName: Offer56
 * Description:
 * date: 3/5/2022 下午11:50
 *
 * @author liyh
 */
public class Offer056 {
    public static void main(String[] args) {
        Solution056And653 solution056And653 = new Solution056And653();

        TreeNode root = solution056And653.getATestTree();

        boolean result = solution056And653.findTarget(root, 12);
        System.out.println("result = " + result);
    }
}

class Solution056And653{

    /**
     * 这个解法其实并没有运用到BST的性质
     * 要想使用的话可能需要正向和反向迭代器的编写了。
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                if(set.contains(k - cur.val)){
                    return true;
                }
                //先判断还是先加set还是有顺序可言的，先加的化会碰到偶数的一半的时候直接返回true
                set.add(cur.val);
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            cur = cur.right;
        }
        return false;
    }


    public TreeNode getATestTree(){
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);
        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        return node8;
    }



}
