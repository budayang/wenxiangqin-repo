package bytedance;

public class 二叉搜索树的第K大节点 {

    int count = 0, ans = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode node, int k) {
        if (node.right != null) {
            dfs(node.right, k);
        }
        if (++count == k) {
            ans = node.val;
            return;
        }

        if (node.left != null) {
            dfs(node.left, k);
        }
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
