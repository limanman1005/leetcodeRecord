### 与树相关的基础比掌握知识点

### 最最重要的就是树的遍历，三种遍历方式的迭代写法是真的需要非常熟练

```java
    private static List<Integer> postOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.peekLast();
            //这里的表示当前节点的右子树不为空且当前节点的右节点还没有被访问过的时候就需要先访问右子树。
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
            }
            else{
                stack.pollLast();
                ans.add(cur.val);
                pre = cur;
                //这个必须要置空才能从栈中弹出父节点进行遍历。
                cur = null;
            }
        }
        return ans;
    }

    private static List<Integer> InOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    private static List<Integer> preOrderTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                ans.add(cur.val);
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            cur = cur.right;
        }
        return ans;
    }
```
