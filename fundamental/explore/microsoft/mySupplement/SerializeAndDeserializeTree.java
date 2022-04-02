package explore.microsoft.mySupplement;

import mySummary.Dfs.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: SerializeAndDeserializeTree
 * Description:
 * date: 2020/8/3 17:58
 *
 * @author liyh
 */
public class SerializeAndDeserializeTree {
    public static void main(String[] args) {
//        Solution297 solution297 = new Solution297();
//        TreeNode trNode = solution297.getTrNode();
//        String serialize = solution297.serialize(trNode);
//        System.out.println(serialize);
//        TreeNode deserialize = solution297.deserialize(serialize);
        Solution297_2 solution297_2 = new Solution297_2();
        TreeNode trNode = solution297_2.getTrNode();
        String serialize = solution297_2.serialize(trNode);
        System.out.println(serialize);
        TreeNode deserialize = solution297_2.deserialize(serialize);
        System.out.println(deserialize.val);



    }
}
class Solution297{
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
        StringBuilder res = mySeri(root, new StringBuilder());
        return res.toString();
    }

    /**
     * 使用dfs进行序列化。用了递归的手法完成了dfs。
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
}

class Solution297_2{

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
        StringBuilder sb =  new StringBuilder();
        return seri(root, sb).toString();
    }

    public StringBuilder seri(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return sb;
        }
        sb.append(root.val);
        sb.append(",");
        StringBuilder left = seri(root.left, new StringBuilder());
        StringBuilder right = seri(root.right, new StringBuilder());
        return sb.append(left).append(right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
        TreeNode root = deri(strings);
        return root;
    }

    private TreeNode deri(ArrayList<String> strings) {
        if(strings.size() == 0){
            return null;
        }
        String val = strings.get(0);
        if("null".equals(val)){
            strings.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        strings.remove(0);
        TreeNode left = deri(strings);
        TreeNode right = deri(strings);
        root.left = left;
        root.right = right;
        return root;
    }

}
