package bytedance;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 不修改原二叉树的解法 1
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        // 先合并根节点
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        // 再递归合并左右子树
        root.left = mergeTrees1(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees1(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }

    /**
     * 不修改原二叉树的解法 2
     * 复用 t1，t2 不重叠处的节点，既题目所说“不为 NULL 的节点将直接作为新二叉树的节点”
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        TreeNode root = new TreeNode(t1.val + t2.val);
        // 再递归合并左右子树
        root.left = mergeTrees2(t1.left, t2.left);
        root.right = mergeTrees2(t1.right, t2.right);
        return root;
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
