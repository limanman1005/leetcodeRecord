package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

/**
 * ClassName: Debug
 * Description:
 * date: 12/5/2022 上午11:21
 *
 * @author liyh
 */
public class Debug {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(codec.getTrNode());
        System.out.println(serialize);
        TreeNode root = codec.deserialize(serialize);
        System.out.println(root.val);
    }
}
class Codec {

    private int idx = 0;

    public TreeNode getTrNode(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        return treeNode1;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        String left = serialize(root.left);
        String right = serialize(root.right);
        return sb.append(left).append(right).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        return dfs(strs);
    }

    private TreeNode dfs(String[] strs){
        if("null".equals(strs[idx])){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        root.left = dfs(strs);
        root.right = dfs(strs);
        return root;
    }
}
