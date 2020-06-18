package JunePractice;

import Dfs.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: RecoverTreeFromPreOrder
 * Description: 给定一个字符串，上面有各个节点的值和深度信息，并且知道这个序列是先序遍历
 * 要求将这个树还原。
 * date: 2020/6/18 9:50
 *
 * @author liyh
 */
public class RecoverTreeFromPreOrder {
}
class Solution1028 {
    int idx;
    private int start;

    public TreeNode recoverFromPreorder(String S) {
        idx = 0;
        return helper(S,0);
    }

    /**
     * 递归法
     * @param S
     * @param depth
     * @return
     */
    public TreeNode helper(String S, int depth ) {
        if (idx>=S.length()) {
            return null;
        }
        int curDepth = 0;
        int k = idx;
        while ( k<S.length() && S.charAt(k)=='-'){
            curDepth++;
            k++;
        }
        if (curDepth!=depth){
            return null;
        }
        idx = k;
        int val = 0;
        while (idx < S.length() && Character.isDigit(S.charAt(idx))){
            val = val*10 + (S.charAt(idx) - '0');
            idx++;
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(S,depth+1);
        node.right = helper(S,depth+1);
        return node;
    }

    int count=0;

    /**
     * 递归法2
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder2(String S) {

        TreeNode root=get(S,0);
        return root;
    }

    /**
     *
     * @param s
     * @param dep 记录的是当前的深度
     * @return
     */
    public TreeNode get(String s,int dep){
        if(count==s.length()){
            return null;
        }
        TreeNode node=null;
        //使用start和end确定当前数字的位数，并解析出来
        start = count;
        while(s.charAt(start)=='-'){
            start++;
        }
        int end= start;
        while(end<s.length()&&(s.charAt(end)>='0'&&s.charAt(end)<='9')){
            end++;
        }
        //count是记录上一个数字最后一位结束的位置。使用当前的start - count可得到当前的节点的level信息。
        if(start -count==dep){
            node=new TreeNode(Integer.parseInt(s.substring(start,end)));
            count=end;
        }
        if(node!=null){
            node.left=get(s,dep+1);
            node.right=get(s,dep+1);
        }
        return node;
    }

    /**
     * 官方提供的非递归的解法
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder3(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while(pos < S.length()){
            int level = 0;
            while(S.charAt(pos) == '-'){
                ++level;
                ++pos;
            }
            int value = 0;
            while(pos < S.length() && Character.isDigit(S.charAt(pos))){
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            //相等了就是左孩子
            if(level == path.size()){
                if(!path.isEmpty()){
                    path.peek().left = node;
                }
            }
            else{
                //否则挂到上一个level的右孩子身上
                while(level != path.size()){
                    path.pop();
                }
                path.peek().right = node;
            }
            //压下栈
            path.push(node);
        }
        while(path.size() > 1){
            path.pop();
        }
        return path.peek();
    }


    /**
     * 在答案里面找的第二种非递归写法。
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder4(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            //记录level信息
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            //算出值得信息
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            //如果大于就出栈？
            //size代表节点得level，要找到上一个层的。
            while (stack.size() > level) {
                stack.pop();
            }
            //创建节点
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                //如果栈不空，并且左孩子为null，就加到左孩子上去
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                }
                //否则加到右孩子上去
                else {
                    stack.peek().right = node;
                }
            }
            //当前节点进栈
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}
