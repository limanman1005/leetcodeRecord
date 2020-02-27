/**
 * ClassName: LC98
 * Description: 判断一个树是否是二叉搜索树
 * date: 2020/2/27 15:59
 *
 * @author liyh
 */
public class LC98 {

    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
    }
}
class Solution98_1 {
    private Integer max;
    private Integer min;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, min, max);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        //基准条件
        if(root == null){
            return true;
        }
        //应有条件
        int val = root.val;
        if(min != null && val <= min){
            return false;
        }
        if(max != null && val >= max){
            return false;
        }
        //结果
        //也可以写成 return helper(root.left, min, val) && helper(root.right, val, max)
        if(helper(root.left, min, val) && helper(root.right, val, max)){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution98_2 {
    private double temp = - Double.MAX_VALUE;
    //此方法有点意思，里面暗含了中序遍历，判断了每一个数是不是比后面的一个数小。
    //我为什么一开始想不到这个答案？？？
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(isValidBST(root.left)){
            if(temp < root.val){
                temp = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}


