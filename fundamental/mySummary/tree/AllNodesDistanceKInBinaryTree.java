package mySummary.tree;

import java.util.*;

/**
 * ClassName: AllNodesDistanceKInBinaryTree
 * Description:
 * date: 23/4/2022 下午5:46
 *
 * @author liyh
 */
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution863 solution863 = new Solution863();
        TreeNode root = solution863.getATestTree();
        List<Integer> integers = solution863.distanceK(root, root.left, 2);
        integers.forEach(System.out::println);

    }
}
class Solution863{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        getParent(root, null, parentMap);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(target);
        set.add(target);
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode curNode = queue.pollFirst();
                if(distance == k){
                    ans.add(curNode.val);
                }
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
                TreeNode curParent = parentMap.get(curNode);
                if(curParent != null && !set.contains(curParent)){
                    queue.add(curParent);
                }
                distance++;
            }
        }
        return ans;
    }


    private void getParent(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> map){
        if(node == null){
            return ;
        }
        map.put(node, parent);
        getParent(node.left, node, map);
        getParent(node.right, node, map);
    }

    public TreeNode getATestTree(){
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        for(int i = 0; i < 9; ++i){
            treeNodes.add(new TreeNode(i));
        }
        treeNodes.get(3).left = treeNodes.get(5);
        treeNodes.get(3).right = treeNodes.get(1);
        treeNodes.get(5).left = treeNodes.get(6);
        treeNodes.get(5).right = treeNodes.get(2);
        treeNodes.get(2).left = treeNodes.get(7);
        treeNodes.get(2).right = treeNodes.get(4);
        treeNodes.get(1).left = treeNodes.get(0);
        treeNodes.get(1).right = treeNodes.get(8);
        return treeNodes.get(3);
    }
}
