package mySummary.Dfs;

/**
 * ClassName: ValidBST
 * Description: 验证二叉搜索树
 * date: 2020/5/5 19:00
 *
 * @author liyh
 */
public class ValidBST {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Double.MIN_VALUE);
    }
}

class Solution98 {
    private double tempMin = -Double.MAX_VALUE;

    /**
     * 这个是第一种解法。直接来一个中序遍历检查是否是升序判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //这一步其实还有剪枝
        if(isValidBST(root.left)){
            if(tempMin < root.val){
                tempMin = root.val;
                return isValidBST(root.right);
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * 第二种解法。在每层递归上传入最大最小值
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        //基准条件
        if(root == null){
            return true;
        }
        //做判断。
        if(min != null && min >= root.val){
            return false;
        }
        if(max != null && max <= root.val){
            return false;
        }
        //缩小范围。
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
