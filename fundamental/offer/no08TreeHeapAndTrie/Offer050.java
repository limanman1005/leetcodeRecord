package offer.no08TreeHeapAndTrie;

import mySummary.Dfs.TreeNode;

import java.util.HashMap;

/**
 * ClassName: Offer050
 * Description:
 * date: 12/5/2022 下午4:35
 *
 * @author liyh
 */
public class Offer050 {
}

/**
 * 此题有两种解法的，其中一种是双递归比较的直观
 * 还有一种是采用记录下路径的总和来计算的
 */
class SolutionOffer050And437{

    /**
     * 记录下到达每个节点的路径上的节点之和出现的次数。
     * 然后对每个节点进行计算，并返回结果即可。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, targetSum, map, 0);
    }

    /**
     * 这个解法的总体思路就是记录下到达每个节点时候组成的路径上的节点组成的总和出现的次数。
     * 然后享减就得到了以当前节点为尾的最后一个节点是否能组成targetSum以及可以组成的次数。
     * 之后将这个值记录下来继续取遍历左右子树，最后删除这个节点组成的pathSum之后，返回上一层。
     * @param root
     * @param targetSum
     * @param map
     * @param pathSum
     * @return
     */
    private int dfs(TreeNode root, int targetSum, HashMap<Integer, Integer> map, int pathSum){
        if(root == null){
            return 0;
        }
        //记录到此的节点的路径之和
        pathSum += root.val;
        //可以直接在路径之和中得到与当前节点值和为targetSum的路径出现的次数，如果没有直接赋值0。
        int count = map.getOrDefault(pathSum - targetSum, 0);
        //更新加入当前节点后pathSum出现的次数
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        //深度搜索其左右子节点出现的次数
        count += dfs(root.left, targetSum, map, pathSum);
        count += dfs(root.right, targetSum, map, pathSum);
        //回溯，删除加入当前节点后的pathSum出现的次数。
        map.put(pathSum, map.get(pathSum) - 1);
        return count;
    }
}
