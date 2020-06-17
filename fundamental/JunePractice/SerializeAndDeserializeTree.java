package JunePractice;

import Dfs.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * ClassName: SerializeAndDeserializeTree
 * Description: 序列化和解序列化一个树
 *
 * date: 2020/6/16 10:51
 *
 * @author liyh
 */
public class SerializeAndDeserializeTree {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode specTree = codec.getSpecTree();
        String serialize = codec.serialize(specTree);
        System.out.println(serialize);
    }
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = mySeri(root, new StringBuilder());
        return res.toString();
    }

    /**
     * 使用了前序遍历，序列化。相当于对树进行了一次遍历。
     * @param root
     * @param sb
     * @return
     */
    public StringBuilder mySeri(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return sb;
        }else{
            sb.append(root.val);
            sb.append(",");
            mySeri(root.left, sb);
            mySeri(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.

    /**
     * 解序列化方法，每次碰到的都是根，直接拿出来。然后从待接序列化的序列中移出即可。
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(temp));
        return myDeSeri(list);
    }
    public TreeNode myDeSeri(List<String> list){
        TreeNode root;
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }else{
            root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = myDeSeri(list);
            root.right = myDeSeri(list);
        }
        return root;
    }

    public TreeNode getSpecTree(){
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
}