package bytedance;

public class 另一棵树的子树 {


    // 这个就是LeetCode100 题的那个函数
    public boolean isSameTree(TreeNode s,TreeNode t){
        // 同时为空 说明树一起到底，两树相同
        if (s==null && t == null){
            return true;
        }
        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (s == null || t == null){
            return false;
        }
        // 如果判断到了这一步，说明两个都不为空
        // 先序遍历 自己--左 -- 右
        if (s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 我s都遍历完了。你居然还没匹配上。那就返回false
        if (s==null){
            return false;
        }
        // 短路运算符，有一个为真，返回真
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
